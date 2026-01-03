package javabookbotpipeline;


/**
 *
 * @author MatthesR
 */
public class Javabookbotpipeline {

    public static void main(String[] args) {

        //wenn möglich und Zeit vorhanden: UserInput Dateipfand angabe implementieren - im FileImporter

        //FileImporter holt die File
        String konvertierterGesamterText = FileImporter.fileImporter();
        //WoerterZeahlen zum zählen der Wörter
        WoerterZaehlen WoerterZaehlen = new WoerterZaehlen(konvertierterGesamterText);
        //Ausgabe der WoerterZeahlen Klasse, die ihrerseits einen toSTring Methode besitzt für passende Ausgabe
        System.out.println(WoerterZaehlen);

        //initzialisierung des Buchstaben Dictionarys mit dem Parameter des durch FileImpoter erzeugten Textes
        BuchstabenDIC BuchstabenDIC = new BuchstabenDIC(konvertierterGesamterText);
        //initzialisierung meines eignen KeyValuePairs - über Maps wäre es sicherlich weniger aufwendig gewesen
        //nun nicht mehr nötig, da im DIC constructor inizialisiert wird
        //BuchstabenDIC.arrayOfKeyPairs(konvertierterGesamterText); //auch redundant, wird im DIC constructor nun gerufen
        //ArrayList<KeyValuePair> pairs = BuchstabenDIC.arrayOfKeyPairs(konvertierterGesamterText); //die line war krass redundant - bleibt hier, falls fehler auftauchen
        //Output printout der Dictionary Klasse über  überschriebene toString Methode
        System.out.println(BuchstabenDIC); //report

        //CSVOutput soll als Parameter den variablen Dateinamen und das jeweilige zu durchsuchende DIC bekommen
        CSVOutput csvOutput = new CSVOutput("buchstaben_haeufigkeit", BuchstabenDIC);      //constructor mit dateinamen
        //die .toCSV methode erwartet keine Argumente, da der Constructor bereits alle informationen privat bekommen haben sollte
        csvOutput.toCSV(); // speichert am ProjektRoot, also neben src foler, etc - mögliche Verbesserung, wenn Zeit gegeben
        csvOutput.toSSV(); // speichert noch eine für Excel optimierte CSV version, spepariert durch Semikolon
        // Stand der Arbeit nach 5 1/2 Zeitstunden - Projekt Konvertierung von Python nach Java: komplett, CSV Implementierung: komplett
        JSON_XLM_Converter converter = new JSON_XLM_Converter("buchstaben_haeufigkeit.csv", "buchstaben_haeufigkeit");
        converter.convertToJSON();

        converter.convertToXLM();


        
        


    }




}

