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
 * The Data Layer.
 */
public class Model 
{
    public String Berechne(String astr) {
    String str = astr;
    //Create anonymus Class with a temporary object instance.
    return Double.toString(new Object() {
        int pos = -1, ch;

        /*on the first Call it set the char pointer to the end of the calcstring 
        and then the other calls it count down to the begin of the string*/
        void nextChar() {
            ch = (++pos < str.length()) ? str.charAt(pos) : -1;
        }

        //This function has appetite
        //Nom Nom Nom
        boolean eat(int charToEat) {
            while (ch == ' ') nextChar();
            if (ch == charToEat) {
                nextChar();
                return true;
            }
            return false;
        }

        //Parse the Calculation and return the result
        double parse() {
            nextChar();
            double x = parseExpression();
            if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char)ch);
            return x;
        }

        // Grammar:
        // expression = term | expression `+` term | expression `-` term
        // term = factor | term `*` factor | term `/` factor
        // factor = `+` factor | `-` factor | `(` expression `)`
        //        | number | functionName factor | factor `^` factor

        //calculate the expressions with +and-
        double parseExpression() {
            //Before do that calculate *and/
            double x = parseTerm();
            for (;;) {
                if      (eat('+')) x += parseTerm(); // addition
                else if (eat('-')) x -= parseTerm(); // subtraction
                else return x;
            }
        }

        //calculate the expressions with *and/
        double parseTerm() {
            //Before do that calculate extra expression calc like cos,sin,tan....  
            double x = parseFactor();
            for (;;) {
                if      (eat('*')) x *= parseFactor(); // multiplication
                else if (eat('/')) x /= parseFactor(); // division
                else return x;
            }
        }

        //calculate the expressions with sin,cos,tan,sqrt,power,()....
        double parseFactor() {
            if (eat('+')) return parseFactor(); // unary plus
            if (eat('-')) return -parseFactor(); // unary minus

            double x;
            int startPos = this.pos;
            if (eat('(')) { // parentheses
                x = parseExpression();
                eat(')');
            } else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
                while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                x = Double.parseDouble(str.substring(startPos, this.pos));
            } else if (ch >= 'a' && ch <= 'z') { // functions
                while (ch >= 'a' && ch <= 'z') nextChar();
                String func = str.substring(startPos, this.pos);
                x = parseFactor();
                if (func.equals("sqrt")) x = Math.sqrt(x);
                else if (func.equals("sin")) x = Math.sin(Math.toRadians(x));
                else if (func.equals("cos")) x = Math.cos(Math.toRadians(x));
                else if (func.equals("tan")) x = Math.tan(Math.toRadians(x));
                else throw new RuntimeException("Unbekannte Funktion: " + func);
            } else {
                throw new RuntimeException("Unerwartet: " + (char)ch);
            }

            if (eat('^')) x = Math.pow(x, parseFactor()); // exponentiation

            return x;
        }
    }.parse()); //Call Parse to Calculate the string.
}
   
   //Nothing to see here.
   public void ClearAll()
   {
   //empty    
   }
}
