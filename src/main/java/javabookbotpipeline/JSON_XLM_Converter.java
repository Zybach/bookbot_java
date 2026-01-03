package javabookbotpipeline;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class JSON_XLM_Converter {

    private String csvDateiname;
    private String Dateiname;


    /**
     * constructor für den Converter
     * @param csvDateiname
     * @param Dateiname
     */
    public JSON_XLM_Converter(String csvDateiname, String Dateiname){
        this.csvDateiname = csvDateiname;
        this.Dateiname = Dateiname;
    }

    /**
    convertiert CSV dateien an einem angegebenen Speicherort zu JSON Dateien. im moment doppelt in Gson und Jackson
     */
    public void convertToJSON(){

        try (BufferedReader reader = new BufferedReader(new FileReader(this.csvDateiname))) {
            String zeile;
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonArray jsonArrayGson = new JsonArray();

            final ObjectMapper objectMapper = new ObjectMapper();
            ArrayNode arrayNode = objectMapper.createArrayNode();

            reader.readLine();

            while ((zeile = reader.readLine()) != null) {
//teilt die eingelesene Zeile bei der Kommatrennung
//[,;] als regex characterclass oder alternativ (", | ;") mit einfacher pipe sorgt dafür, dass entweder bei komma ODER simikolon getrennt wird
                String[] parts = zeile.split("[,;]");
                if (parts.length == 2){
//falls nach der trennung beim komma die anzahl der elemente der zeile zwei ist, was sie immer sein sollte, dann
//wissen wir, dass das Char an index 0 ist, und die anzahl an index 1
                    String zeichen = parts[0];
                    String anzahl = parts[1];
//<====hier nur zu Übungszwecken Gson UND Jackson
//<====Gson Object implementation
                    JsonObject jsonObjectGson = new JsonObject();
//kreiert JsonObject,befüllt es über addProperty mit den Parametern je Zeichen und Anzahl und deren Werte
                    jsonObjectGson.addProperty("Zeichen", zeichen);
                    jsonObjectGson.addProperty("Anzahl", anzahl);
//übergibt dem json array das object 
                    jsonArrayGson.add(jsonObjectGson);
//<===== Jackson Object Implementation ----- man nutze einen der Beiden, nicht Beide, das wäre redundant
                    ObjectNode jsonObjectJackson = objectMapper.createObjectNode();
                    jsonObjectJackson.put("Zeichen", zeichen); // or character if you want numeric representation
                    jsonObjectJackson.put("Anzahl", anzahl);
                    arrayNode.add(jsonObjectJackson);
                }
            }

            //Gson JSON 
            String gsonJsonString = gson.toJson(jsonArrayGson); //gets converted here to string for file write
            Hilfsclass.showOutPutDialog(gsonJsonString);        //verify output


            // Jackson JSON 
            String jacksonJsonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(arrayNode); //gets converted here to string for file write
            Hilfsclass.showOutPutDialog(jacksonJsonString);      //verify output


            try (FileWriter writer = new FileWriter(this.Dateiname +  "_gson.json")) {
                writer.write(gsonJsonString);
                System.out.println("JSON-Datei über Gson gespeichert unter: " + this.Dateiname + "_gson.json");
            } catch (IOException e) {
                System.err.println("JSONWriteErrorGSON-----------------------:Sieht nicht gut aus John... Error writing to JSON: " + e.getMessage());
            }

            // Jackson JSON
            try (FileWriter writer = new FileWriter(this.Dateiname +  "_jackson.json")) {
                writer.write(jacksonJsonString);
                System.out.println("JSON-Datei über Jackson gespeichert unter: " + this.Dateiname + "_jackson.json");
            } catch (IOException e) {
                System.err.println("JSONWriteErrorJACKSON-----------------------:Sieht nicht gut aus John... Error writing to JSON: " + e.getMessage());
            }
        } catch (IOException e) { 
                    System.err.println("Error converting CSV to JSON (File Reading): " + e.getMessage());
            }
    }


    /**
    convertiert eine gegebene CSV atei in eine XML datei
     */
    public void convertToXLM(){

        try (BufferedReader reader = new BufferedReader(new FileReader(this.csvDateiname))) {
            String zeile;

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            // root elements
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("Buchstabenhaufigkeit"); //wird die Root des Dokuments
            doc.appendChild(rootElement);


            reader.readLine(); // Skip header row

            while ((zeile = reader.readLine()) != null) {
                String[] parts = zeile.split("[,;]");
                if (parts.length == 2) {
                    String zeichen = parts[0];
                    String anzahl = parts[1];

                    Element zeichenElement = doc.createElement("Zeichen");
                    rootElement.appendChild(zeichenElement);

                    Element charElement = doc.createElement("Buchstabe");
                    charElement.setTextContent(zeichen);
                    zeichenElement.appendChild(charElement);

                    Element anzahlElement = doc.createElement("Anzahl");
                    anzahlElement.setTextContent(anzahl);
                    zeichenElement.appendChild(anzahlElement);

                }
            }

        // write the content into xml file
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = null;
//unkonfigurierter Transformer schreibt den XML Head <?xml version="1.0" encoding="UTF-8" standalone="no"?>
        try {
            transformer = transformerFactory.newTransformer();
        } catch (TransformerConfigurationException e) {
            System.err.println("Error XML transformer: " + e.getMessage());
            return; // Or handle the error as needed
        }

        if (transformer != null) {
//deklaration und inizialisierung der source sowie des results
            DOMSource source = new DOMSource(doc);
            try (FileWriter writer = new FileWriter(this.Dateiname + ".xml")) {
                StreamResult result = new StreamResult(writer);
//um es mittels des transformers z utransformen von source zu result
                transformer.transform(source, result);
                System.out.println("XML-Datei gespeichert unter: " + this.Dateiname + ".xml");
            } catch (IOException | TransformerException e) {
                System.err.println("Error writing to XML: " + e.getMessage());
            }
        }
        } catch (IOException | ParserConfigurationException e) {
            System.err.println("Error converting CSV to XML: " + e.getMessage());
        }

    }



}


