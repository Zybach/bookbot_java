package javabookbotpipeline;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;         // importiert das java.desktop modul, das NEBEN dem oop package liegen muss



public class Hilfsclass {

    private static final BufferedReader tastatur = new BufferedReader(new InputStreamReader(System.in)); // Single instance - die für die gesamte Hilfsclass Sitzung offen bleibt


    public static int getInt(String... txt){    //"varargs" mit variabler ParameterInputLänge, entweder nichts, oder wenn etwas im Parameter, ändern wir die logik mit sysoutput                         
    int gecastete_Eingabe = 0;                                  
    String Eingabe = "";
    boolean eingabeGueltig = false;

    if (txt.length > 0){             //wenn also der parameterblock nicht leer ist
        System.out.print(txt[0]); //wird der erste Index des String Arrays dass das varargs Array darstellt geladen
    }
    do{
        try{
            Eingabe = tastatur.readLine();
            if (Eingabe.isBlank()) {
                throw new IllegalArgumentException("Sie haben nichts eingegeben.");
            }else{
                    gecastete_Eingabe = Integer.parseInt(Eingabe);
                    eingabeGueltig = true; 
            }
        } catch (NumberFormatException ex) {        //zwar redundant im Str-Fall, aber ich lasse sie mal drin,d a dies als Basis für alle anderen methoden dient
            System.out.println("Ungültige Eingabe. Bitte geben Sie eine positive Ganzzahl ein!");
        } catch (IllegalArgumentException ex){
            System.out.println("Vermutlich war ihre Eingabe leer, bitte beheben Sie dies im naechsten Versuch. " + ex.getMessage());
        } catch (IOException ex){        //die eigentlich wichtige Exception für den BufferedReader
            System.out.println("Ein Lese- oder Ausgabefehler scheint aufgetreten zu sein : "+ ex.getMessage());
        }
    } while (!eingabeGueltig); 
    return gecastete_Eingabe;
    }





    public static String getStr(String... txt) {
    String Eingabe = "";
    boolean eingabeGueltig = false;
    
    if(txt.length > 0 ){
        System.out.print(txt[0]);
    }
    do{
        try{
            Eingabe = tastatur.readLine();
            if (Eingabe.isBlank()) {
                throw new IllegalArgumentException("Sie haben nichts eingegeben.");
            }else{     
                eingabeGueltig = true; 
            }
        } catch (NumberFormatException ex) {        //zwar redundant im Str-Fall, aber ich lasse sie mal drin,d a dies als Basis für alle anderen methoden dient
            System.out.println("Ungültige Eingabe. Bitte geben Sie eine positive Ganzzahl ein!");
        } catch (IllegalArgumentException ex){
            System.out.println("Vermutlich war ihre Eingabe leer, bitte beheben Sie dies im naechsten Versuch. " + ex.getMessage());
        } catch (IOException ex){        //die eigentlich wichtige Exception für den BufferedReader
            System.out.println("Ein Lese- oder Ausgabefehler scheint aufgetreten zu sein : "+ ex.getMessage());
        }
    } while (!eingabeGueltig); 
    return Eingabe;
    }

    public static double getDouble(String... txt){    //"varargs" mit variabler ParameterInputLänge, entweder nichts, oder wenn etwas im Parameter, ändern wir die logik mit sysoutput
        double gecastete_Eingabe = 0;                                  
        String Eingabe = "";                       
        boolean eingabeGueltig = false;

        if (txt.length > 0){             //wenn also der parameterblock nicht leer ist
            System.out.print(txt[0]); //wird der erste Index des String Arrays dass das varargs Array darstellt geladen
        }
        do{
            try{
                Eingabe = tastatur.readLine();
                if (Eingabe.isBlank()) {
                    throw new IllegalArgumentException("Sie haben nichts eingegeben.");
                }else{
                        gecastete_Eingabe = Double.parseDouble(Eingabe);
                        eingabeGueltig = true; 
                }
            } catch (NumberFormatException ex) {        //zwar redundant im Str-Fall, aber ich lasse sie mal drin,d a dies als Basis für alle anderen methoden dient
                System.out.println("Ungültige Eingabe. Bitte geben Sie eine positive Ganzzahl ein!");
            } catch (IllegalArgumentException ex){
                System.out.println("Vermutlich war ihre Eingabe leer, bitte beheben Sie dies im naechsten Versuch. " + ex.getMessage());
            } catch (IOException ex){        //die eigentlich wichtige Exception für den BufferedReader
                System.out.println("Ein Lese- oder Ausgabefehler scheint aufgetreten zu sein : "+ ex.getMessage());
            }
    } while (!eingabeGueltig); 
    return gecastete_Eingabe;
    }



    /*public static int getInt() throws Exception{                         
        int gecastete_Eingabe = 0;                                  
        String Eingabe = "";
        boolean eingabeGueltig = false;

        BufferedReader tastatur = new BufferedReader(new InputStreamReader(System.in));
        do{
            try{
                Eingabe = tastatur.readLine();
                if (Eingabe.isEmpty()) {
                    System.out.println("Sie haben nichts eingegeben. Bitte geben Sie eine positive Ganzzahl ein!");
                }else{
                    gecastete_Eingabe = Integer.parseInt(Eingabe);
                    eingabeGueltig = true; 
                }
            }catch (NumberFormatException ex) {
                System.out.println("Ungültige Eingabe. Bitte geben Sie eine positive Ganzzahl ein!");
            }
        }while (!eingabeGueltig); 
        return gecastete_Eingabe;
    }*/



    public static double getDoubleGUI() throws Exception{                         
        double gecastete_Eingabe = 0;                                  
        String Eingabe = "";
        boolean eingabeGueltig = false;

        do{
            try{
                Eingabe = JOptionPane.showInputDialog("Bitte machen Sie eine Eingabe.");
                if (Eingabe.isEmpty()) {
                    JOptionPane.showInputDialog("Sie haben nichts eingegeben. Bitte geben Sie eine positive Ganzzahl ein!");
                }else{
                    gecastete_Eingabe = Double.parseDouble(Eingabe);
                    eingabeGueltig = true; 
                }
            }catch (NumberFormatException ex) {
                JOptionPane.showInputDialog("Ungültige Eingabe. Bitte geben Sie eine positive Ganzzahl ein!");
            }
        }while (!eingabeGueltig); 
        return gecastete_Eingabe;
    }


    public static int getIntGUI() throws Exception{                         
        int gecastete_Eingabe = 0;                                  
        String Eingabe = "";
        boolean eingabeGueltig = false;

        do{
            try{
                Eingabe = JOptionPane.showInputDialog("Bitte machen Sie eine Eingabe.");
                if (Eingabe.isEmpty()) {
                    JOptionPane.showInputDialog("Sie haben nichts eingegeben. Bitte geben Sie eine positive Ganzzahl ein!");
                }else{
                    gecastete_Eingabe = Integer.parseInt(Eingabe);
                    eingabeGueltig = true; 
                }
            }catch (NumberFormatException ex) {
                JOptionPane.showInputDialog("Ungültige Eingabe. Bitte geben Sie eine positive Ganzzahl ein!");
            }
        }while (!eingabeGueltig); 
        return gecastete_Eingabe;
    }

    /*public static double getDouble() throws Exception{                         
        double gecastete_Eingabe = 0;                                  
        String Eingabe = "";
        boolean eingabeGueltig = false;    public static double getDouble(){                         
        double gecastete_Eingabe = 0;                                  
        String Eingabe = "";
        boolean eingabeGueltig = false;

        do{
        try(BufferedReader tastatur = new BufferedReader(new InputStreamReader(System.in))){        //Try-With-Rescources im try() Parameter, ruft den StreamReader im Try Parameter auf!
            Eingabe = tastatur.readLine();                                                          //Ohne Try-With-Rescources hätten wir im finally block den Reader closen müssen, dieser ist aber AutoCloseable durch den try()
            if (Eingabe.isBlank()) {
                throw new IllegalArgumentException("Sie haben nichts eingegeben.");
            }else{
                    gecastete_Eingabe = Double.parseDouble(Eingabe);
                    eingabeGueltig = true; 
            }
        } catch (NumberFormatException ex) {        //zwar redundant im Str-Fall, aber ich lasse sie mal drin,d a dies als Basis für alle anderen methoden dient
            System.out.println("Ungültige Eingabe. Bitte geben Sie eine positive Ganzzahl ein!");
        } catch (IllegalArgumentException ex){
            System.out.println("Vermutlich war ihre Eingabe leer, bitte beheben Sie dies im naechsten Versuch. " + ex.getMessage());
        } catch (IOException ex){        //die eigentlich wichtige Exception für den BufferedReader
            System.out.println("Ein Lese- oder Ausgabefehler scheint aufgetreten zu sein : "+ ex.getMessage());
        }
    } while (!eingabeGueltig); 
    return gecastete_Eingabe;
    }

        BufferedReader tastatur = new BufferedReader(new InputStreamReader(System.in));
        do{
            try{
                Eingabe = tastatur.readLine();
                if (Eingabe.isEmpty()) {
                    System.out.println("Sie haben nichts eingegeben. Bitte geben Sie eine positive Ganzzahl ein!");
                }else{
                    gecastete_Eingabe = Double.parseDouble(Eingabe);
                    eingabeGueltig = true; 
                }
            }catch (NumberFormatException ex) {
                System.out.println("Ungültige Eingabe. Bitte geben Sie eine positive Ganzzahl ein!");
            }
        }while (!eingabeGueltig); 
        return gecastete_Eingabe;
    }*/







    /*public static String getStr() throws Exception{
        String Eingabe = "";
        boolean eingabeGueltig = false;
        
        BufferedReader tastatur = new BufferedReader(new InputStreamReader(System.in));
        do{
            try{
                Eingabe = tastatur.readLine();
                if (Eingabe.isBlank()) {
                    System.out.println("Sie haben nichts eingegeben.");
                }else{     
                    eingabeGueltig = true; 
                }
                }catch (NumberFormatException ex) {
                System.out.println("Ungültige Eingabe. Bitte geben Sie eine positive Ganzzahl ein!");
            }
        } while (!eingabeGueltig); 
        return Eingabe;
    }*/



    /**
     * 
     * Alte Version von Code die try-with-Recscources arbeitet - aber da sie System.in mit dem Rescources Block schließt, leider nicht nutzbar
     * 
     */
    /*public static int getInt(String... txt){    //"varargs" mit variabler ParameterInputLänge, entweder nichts, oder wenn etwas im Parameter, ändern wir die logik mit sysoutput                         
    int gecastete_Eingabe = 0;                                  
    String Eingabe = "";
    boolean eingabeGueltig = false;

    if (txt.length > 0){             //wenn also der parameterblock nicht leer ist
        System.out.print(txt[0]); //wird der erste Index des String Arrays dass das varargs Array darstellt geladen
    }
    do{
        try(BufferedReader tastatur = new BufferedReader(new InputStreamReader(System.in))){        //Try-With-Rescources im try() Parameter, ruft den StreamReader im Try Parameter auf!
            Eingabe = tastatur.readLine();                                                          //Ohne Try-With-Rescources hätten wir im finally block den Reader closen müssen, dieser ist aber AutoCloseable durch den try()
            if (Eingabe.isBlank()) {
                throw new IllegalArgumentException("Sie haben nichts eingegeben.");
            }else{
                    gecastete_Eingabe = Integer.parseInt(Eingabe);
                    eingabeGueltig = true; 
            }
        } catch (NumberFormatException ex) {        //zwar redundant im Str-Fall, aber ich lasse sie mal drin,d a dies als Basis für alle anderen methoden dient
            System.out.println("Ungültige Eingabe. Bitte geben Sie eine positive Ganzzahl ein!");
        } catch (IllegalArgumentException ex){
            System.out.println("Vermutlich war ihre Eingabe leer, bitte beheben Sie dies im naechsten Versuch. " + ex.getMessage());
        } catch (IOException ex){        //die eigentlich wichtige Exception für den BufferedReader
            System.out.println("Ein Lese- oder Ausgabefehler scheint aufgetreten zu sein : "+ ex.getMessage());
        }
    } while (!eingabeGueltig); 
    return gecastete_Eingabe;
    }*/



    public static String getStrGUI() throws Exception{
        String Eingabe = "";
        boolean eingabeGueltig = false;

        do{
            try{
                Eingabe = JOptionPane.showInputDialog("Bitte machen Sie eine Eingabe.");
                if (Eingabe.isBlank()) {
                    JOptionPane.showInputDialog("Sie haben nichts eingegeben.");
                }else{     
                    eingabeGueltig = true; 
                }
                }catch (NumberFormatException ex) {
                JOptionPane.showInputDialog("Ungültige Eingabe. Bitte geben Sie eine positive Ganzzahl ein!");
            }
        } while (!eingabeGueltig); 
        return Eingabe;
    }

    /**
    gibt ein beliebiges swing Dialogfeld aus mit frei wählbarem Text im parameter
        
    } */
    public static void showOutPutDialog(String string){
        JOptionPane.showMessageDialog(null, string);
    }

    
        /**
     * Löscht die Konsole
     */
    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush(); //Ausgabe sofort an die Konsole schicken
    }



    /*
BufferedReader tastatur outside of your public methods, specifically as a private static final member of your Hilfsclass, is the recommended approach to address the IOException you encountered. Let's break down why:

private: This restricts access to the tastatur variable from outside the Hilfsclass. This is good practice for encapsulation—keeping internal implementation details hidden from other classes.

static: The static keyword makes the tastatur variable belong to the class itself, not to individual instances of the class. This is crucial because you want only one BufferedReader for System.in shared by all the input methods. If it weren't static each method would create and then close it's own BufferedReader instance.

final: The final keyword ensures that the tastatur variable is initialized only once and cannot be reassigned. This guarantees that you don't accidentally create multiple BufferedReader instances, solving the root of your IOException problem.

By combining these modifiers, you create a single, shared BufferedReader that is initialized when the Hilfsclass is loaded and remains available to all its input methods (getInt, getDouble, getStr) without being repeatedly closed and reopened.

Having the BufferedReader as a private static final member provides correct and clean management of System.in within your helper class, preventing stream closure issues and the associated exceptions.




    } */




}
