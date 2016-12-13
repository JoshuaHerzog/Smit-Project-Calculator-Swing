/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * 
 * @author Jan M. Groß, Joshua Herzog, Hendrik Neumannm
 */
public class Model 
{
    public double Berechne(String astr)
    {
       double ergebnis;
       String zwischen_string_zahlen = "";
       String zwischen_string_rechenzeichen = "";
       int counter_rechenzeichen = 0;
       ergebnis = 2.2;
        // Durchlaufe den String Zeichen fuer Zeichen
        for (int i = 0; i < astr.length(); i++){
            char zeichen = astr.charAt(i);
            //verarbeite Zeichen
            if (zeichen == ',' || zeichen >= '0' && zeichen <= '9'){
                zwischen_string_zahlen += zeichen;
            }else{
                zwischen_string_rechenzeichen += zeichen;
                counter_rechenzeichen++;
            }
            
        }

        return ergebnis;
    }
   
   public void ClearAll()
   {
       
   }
}
