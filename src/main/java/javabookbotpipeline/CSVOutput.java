package javabookbotpipeline;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


/**
ein csvWriter der KeyValuePairs erwartet
@param dateiname
@param BuchstabenDIC
 */
public class CSVOutput {

    private String dateiname;
    private ArrayList<KeyValuePair> pairs;


        /**
         * 
         * @param dateiname - sei der variable Dateiname
         * @param auflistungDerBuchstaben - bekommt das DIC, aber pullt im constructor nur die .get des KeyValuePairs
         */    
        public CSVOutput (String dateiname, BuchstabenDIC auflistungDerBuchstaben){
            this.dateiname = dateiname;
            this.pairs = auflistungDerBuchstaben.getAuflistungDerBuchstaben();
    }

        public void toCSV() {  
        try (FileWriter writer = new FileWriter(this.dateiname +  ".csv")) {                          //al instanzvariable
            // Header row erstmal die HeaderRow - für die Spaltenüberschrift
            writer.write("Zeichen,Anzahl" + System.lineSeparator());

            //für jedes Paar in Paare - Schreibt die DataRow - also jede Zeile, pro Zeile je ein Char, getrennt durch ein Komma und dann den Value des Chars
            for (KeyValuePair pair : this.pairs) {
                if (Character.isAlphabetic(pair.getKey()) && pair.getKey() != 'è' && pair.getKey() != 'é' && pair.getKey() != 'à' && pair.getKey() != 'â' && pair.getKey() != 'ê' && pair.getKey() != 'æ' && pair.getKey() != 'ô'){
                    //wenn man hier das Komma in ein Semikolon tauschen würde, könnte man die Datei für Excel anpassen
                    writer.write(String.format("%c,%d%s", pair.getKey(), (int) pair.getValue(), System.lineSeparator()));
                }
            }
        } catch (IOException e) {
            System.err.println("CSVOutput-----------------------:Sieht nicht gut aus John... Error writing to CSV: " + e.getMessage());
        }
    }

        public void toSSV() {           //eine Semikolonversion der CSV für Excel
        try (FileWriter writer = new FileWriter(this.dateiname + "_ssv" + ".csv")) {                          //al instanzvariable
            // Header row erstmal die HeaderRow - für die Spaltenüberschrift
            writer.write("Zeichen,Anzahl" + System.lineSeparator());

            //für jedes Paar in Paare - Schreibt die DataRow - also jede Zeile, pro Zeile je ein Char, getrennt durch ein Komma und dann den Value des Chars
            for (KeyValuePair pair : this.pairs) {
                if (Character.isAlphabetic(pair.getKey()) && pair.getKey() != 'è' && pair.getKey() != 'é' && pair.getKey() != 'à' && pair.getKey() != 'â' && pair.getKey() != 'ê' && pair.getKey() != 'æ' && pair.getKey() != 'ô'){
                    //wenn man hier das Komma in ein Semikolon tauschen würde, könnte man die Datei für Excel anpassen
                    writer.write(String.format("%c;%d%s", pair.getKey(), (int) pair.getValue(), System.lineSeparator()));
                }
            }
        } catch (IOException e) {
            System.err.println("CSVOutput-----------------------:Sieht nicht gut aus John... Error writing to CSV: " + e.getMessage());
        }
    // die Key Values Pairs müssen noch irgendwie zugänglich gemacht werden !!!
    }
}