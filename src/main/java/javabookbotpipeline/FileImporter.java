

package javabookbotpipeline;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;

public class FileImporter {

    public static String fileImporter(){

        //entweder den absoluten Pfad wählen wie, hier, oder relativ zum projektordner - beides works
        String relativePath = "gutenbergprojektbooks/frankenstein.txt"; // Relative to working directory
        //String relativePath = "gutenbergprojektbooks/Informationssicherheitsskript.txt"; // Relative to working directory
        String absolutePath = Paths.get(relativePath).toAbsolutePath().toString();
        StringBuilder builderText = new StringBuilder();

    

        try (BufferedReader reader = new BufferedReader(new FileReader(absolutePath))) {
            String txtline;
            //lässt den reader solange durchlaufen, bis zum schluss der datei
            while ((txtline = reader.readLine()) != null) {
                //statt den text zur console zu printen..
                //System.out.println(txtline);
                //dem leeren BuilderText Objekt zeilenweise den reinkommenden Text appenden
                builderText.append(txtline).append(System.lineSeparator());
            }
        } catch (IOException e) {
            System.err.println("Lesefehler beim Lesen der Datei: " + e.getMessage());
        }
        //das nun befüllte builderText Objekt mittels .toString konvertierung zu einem einzigen String konvertieren
        String konvertierterGesamterText = builderText.toString().toLowerCase();        //.toLower ist optional
        return konvertierterGesamterText;
        //System.out.println(konvertierterGesamterText);

        /* 
        // Schreiben der Datei zurück in .txt Datei
        try (FileWriter writer = new FileWriter("D:\\Zybacher\\Zybacher\\BFW\\Java\\javabookbotpipeline\\gutenbergprojektbooks\\konvertiert.txt")) {
            writer.write(konvertierterGesamterText);
            System.out.println("Datei gespeichert unter: " + "D:\\Zybacher\\Zybacher\\BFW\\Java\\javabookbotpipeline\\gutenbergprojektbooks\\konvertiert.txt");
        } catch (IOException e) {
            System.err.println("Sieht schlecht aus John: " + e.getMessage());
        }
        */
    }
}
