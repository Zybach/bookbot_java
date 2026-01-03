package javabookbotpipeline;


/**
@author MatthesR
 */
public class KeyValuePair implements Comparable<KeyValuePair>{
    private char key;
    private double value;
    
    public KeyValuePair(char key, double value){
        this.key = key;
        this.value = value;


    }


    /**
     * @return
     */
    public char getKey() {
        return key;
    }

    /**
     * @param
     */
    public void setKey(char key) {
        this.key = key;
    }

    /**
     * @return 
     */
    public double getValue() {
        return value;
    }

    /**
     * @param value 
     */
    public void setValue(double value) {
        this.value = value;
    }

    public String toString(){
        return String.format("Das Zeichen (char): %c -------- Häufigkeit: %f",this.key,this.value);     //%c für char nicht %s---%f für double, nicht %d
    }


    @Override
    public int compareTo(KeyValuePair o) {
        return Double.compare(this.getValue(), o.getValue());
    }

}
