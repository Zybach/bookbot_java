package javabookbotpipeline;

import static java.lang.Character.isAlphabetic;
import java.util.ArrayList;
import java.util.Collections;

public class BuchstabenDIC{     //implement Comparables um die anzahl der Buchstaben sortieren zu können
    private String gesamterText;

    private ArrayList<KeyValuePair> auflistungDerBuchstaben;




    /**
     * 
     * @param txt
    neues Array wird erstellt 
    und gleich über die Methode befüllt, im Constructor - achtung für mögliche Nullpointer, wenn noch zeit ist errorhandling!
     */
    public BuchstabenDIC(String... txt){
        this.gesamterText = txt[0];
        this.auflistungDerBuchstaben = new ArrayList<>();
        this.auflistungDerBuchstaben = arrayOfKeyPairs(txt);
    }


    public ArrayList<KeyValuePair> getAuflistungDerBuchstaben() {
        return auflistungDerBuchstaben;
    }


    public void setAuflistungDerBuchstaben(ArrayList<KeyValuePair> auflistungDerBuchstaben) {
        this.auflistungDerBuchstaben = auflistungDerBuchstaben;
    }


    /**
     * fügt der dem KeyValuePair Array je buchstabe der erstmalig vorkommt
     *den buchstaben hinzu, wenn noch kein keyvaluepair mit diesem buchstaben existiert
        und updatet dessen value um 1
     * @param txt
     */
    public ArrayList<KeyValuePair> arrayOfKeyPairs(String... txt){
        //für jeden buchstaben des LANGEN Strings..
        for(char gesuchterBuchstabe : txt[0].toCharArray()){
                boolean buchstabeGefunden = false;
                //..prüfe jedes mal ob der Buchstabe in einem key des KeyValuePairs vertreten ist
                for (KeyValuePair jePaar : auflistungDerBuchstaben) {
                    //..und falls eines der Paare den buchstaben bereits in sich trägt, dann
                    if (jePaar.getKey() == gesuchterBuchstabe){
                        //update nur den Value, also die Anzahl +1 und lasse den key, also buchstaben untouched
                        jePaar.setValue((jePaar.getValue() + 1));
                        
                        //sobald das richtige Pair gefunden wurde - updaten - und breaken, damit die schleißfe nicht unnötig noch weiter laufen muss
                        buchstabeGefunden = true;
                        break;
                    }
                }
                //falls der lauf durchlief und kein valuepair mit dem jeweiligen key gefunden wurde - buchstabe - füge diesen dem array hinzu
                if (!buchstabeGefunden){
                    auflistungDerBuchstaben.add(new KeyValuePair(gesuchterBuchstabe,1));
                }
        }
        return auflistungDerBuchstaben;
        
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();  // StringBuilder für append Funktionalität
        Collections.sort(auflistungDerBuchstaben);              //so die sortierung zu invertieren ist ineffizient, die compareTo methode umzudrehen wäre effizienter generell
        Collections.reverse(auflistungDerBuchstaben);           //aber für diesen limitierten datensatz sollte es genügen

        for (KeyValuePair pair : this.auflistungDerBuchstaben) { // zieht die KeyValePair Array Liste herein
            if (isAlphabetic(pair.getKey()) && pair.getKey() != 'è' && pair.getKey() != 'é' && pair.getKey() != 'à' && pair.getKey() != 'â' && pair.getKey() != 'ê' && pair.getKey() != 'æ' && pair.getKey() != 'ô'){                   //filtert zahlen und grammatikalische Zeichen heraus
                sb.append("Zeichen: ").append(pair.getKey()).append(" ----- Anzahl: ").append((int) pair.getValue()).append(System.lineSeparator());
            }
        }
        return sb.toString();
    }


    public String getGesamterText() {
        return gesamterText;
    }


    public void setGesamterText(String gesamterText) {
        this.gesamterText = gesamterText;
    }


    

}

    
    


