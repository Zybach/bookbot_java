package javabookbotpipeline;



public class WoerterZaehlen{
    private String gesamterText;
    private double anzahlWoerter;
    private double anzahlZeichen;

    //lösung über constructor damit die anzhal der wörter im toString ausgegeben werden kann
    public WoerterZaehlen(String... txt){
        this.gesamterText = txt[0];
        this.anzahlWoerter = woerterZaehlen(txt);
        this.anzahlZeichen = zeichenZaehlen(txt);
    }






    //ich mache mir hier zunutze, dass varargs, also String... immer ein Array returned
    //zählt leider auch die Whitespaces, wenn dies unerwünscht sein würde, müsste man noch Anpassungen vornehmen
    private double zeichenZaehlen(String... txt){
        double anzahZeichen = 0;
        //dieses array kann ich also an stelle 0 rufen, und auf .length prüfen, ergibt die wort anzahl
        if (txt != null && !txt[0].isEmpty()){      //check gegen null und gegen Empty
            anzahlZeichen = txt[0].length();        //gibt nur die Anzahl der Buchstabenzurück
        }
        return anzahlZeichen;
    }

    @Override
    public String toString() {
        return String.format("Der von Ihnen gewaehlte Text ist %.0f Woerter lang unt enthaelt %.0f Zeichen.", this.anzahlWoerter, this.anzahlZeichen );
    }

    private double woerterZaehlen(String[] txt) {
        double anzahlWoerter = 0;
        if (txt != null && !txt[0].isEmpty()){      //check gegen null und gegen Empty
            anzahlWoerter = txt[0].split("\\s+").length;      //\\s+ = ein oder mehere Whitespaces

        }

        return anzahlWoerter;
    }


    

}