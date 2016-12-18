/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.*;
/**
 *
 * 
 * @author Jan M. Groß, Joshua Herzog, Hendrik Neumannm
 */
public class Model 
{
    private double winkelberechnung(String input){
        char funktion = input.charAt(0);
        input = input.substring(2, input.length()-1);
        double parsed_input = Berechne(input);
        
        System.out.println("Winkel input ist -> " + parsed_input + "<");
        // double winkel = Math.sin(parsed_input);
       double winkel = 0.0;
        switch(funktion){
            case 's':
                winkel = Math.sin(Math.toRadians(parsed_input));
                break;
            case 'c':
                winkel = Math.cos(Math.toRadians(parsed_input));
                break;
            case 't':
                winkel = Math.tan(Math.toRadians(parsed_input));
                break;
            default:
                winkel = 42.0;
        }
       
        return winkel;
    } 
    public double Berechne(String astr)
    {
       //Input vorbereiten
       //Operatoren mit mehreren zeichen dur einzelne zeichen ersetzten
       String rechnung = "0+"+astr.replace("sin", "s").replace("cos","c").replace("tan","t") + "#";
       double ergebnis = 0.0;

        // Durchlaufe den String Zeichen fuer Zeichen
        String number_buffer = "";
        String operator_buffer = "";
        String special_operator = "";
        Double zwischenergebnis = 0.0;
        Double teil_1 = 0.0; 
            try {
                for (int i = 0; i < rechnung.length(); i++){
                    char zeichen = rechnung.charAt(i);
                    //System.out.println(zeichen);
                    if(zeichen >= '0' && zeichen <= '9')
                    {
                        number_buffer += zeichen;
                    }
                    else
                    {

                        if (operator_buffer == "" && (zeichen != 's'&& zeichen != 'c'&& zeichen != 't')){
                         teil_1 = Double.parseDouble(number_buffer);
                         number_buffer = "";
                         operator_buffer += zeichen;
                        }
                        else
                        {
                            System.out.println("DAS STEHT IN ZEICHEN ->" + zeichen);
                            if(zeichen == 's' || zeichen == 'c' || zeichen == 't'){
                               String input = rechnung.substring(i,rechnung.indexOf(")")+1);

                               //String sub_input = input.substring( 2, input.indexOf(")") );
                               double winkel = winkelberechnung(input);
                               System.out.println("Winkel ist -> " + winkel + " <");
                               number_buffer = Double.toString(winkel);
                               rechnung = rechnung.substring(0,i) + winkel + rechnung.substring(rechnung.indexOf(")")+1,rechnung.length());
                               System.out.println("Rechnungs string ist -> " + rechnung);
                            }
                            switch(operator_buffer)
                            {
                                case "+": zwischenergebnis = teil_1 + Double.parseDouble(number_buffer);
                                    System.out.println("Rechne" + teil_1 + "+" + number_buffer);
                                    break;
                                case "-": zwischenergebnis = teil_1 - Double.parseDouble(number_buffer);
                                    System.out.println("Rechne" + teil_1 + "-" + number_buffer);
                                    break;
                                case "*": zwischenergebnis = teil_1 * Double.parseDouble(number_buffer);
                                    System.out.println("Rechne" + teil_1 + "*" + number_buffer);
                                    break;
                                case "/": zwischenergebnis = teil_1 / Double.parseDouble(number_buffer);
                                    System.out.println("Rechne" + teil_1 + "/" + number_buffer);
                                    break;
                                default:
                                    System.out.println("Default case -> " + operator_buffer);
                                    break;
                           }
                           teil_1 = zwischenergebnis;
                           number_buffer = "";
                           operator_buffer = ""+zeichen;  
                        }
                    }
                }
                if(ergebnis == 0.0){
                    ergebnis = teil_1;
                }
                System.out.println("ERGEBNIS: " + ergebnis);
        }
        catch(NumberFormatException e)
        {
            System.out.println("Ungültige rechnung");
        } 
        return ergebnis;

    }
   
   public void ClearAll()
   {
       
   }
}
