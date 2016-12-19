package Model;

import java.util.*;

/**
 * @author Jan M. Groß, Hendrik Neumannm.
 */
public class Model {

    public String Berechne(String astr) {
        String str = astr;
        //Erstelle Klasse mit einem temporaerem Objekt
        return Double.toString(new Object() {
            int position = -1, zeichen;

            /*Beim ersten Aufruf wird der Pointer auf das Ende 
            des zu berechnenden Strings gesetzt und runtergezaehlt*/
            void naechstes_zeichen() {
                zeichen = (++position < str.length()) ? str.charAt(position) : -1;
            }

            // Vergleiche das erwartete Zeichen mit dem aus dem String an der gegebenen Position
            boolean vergleichen(int vergleich_zeichen) {
                while (zeichen == ' ') {
                    naechstes_zeichen();
                }
                if (zeichen == vergleich_zeichen) {
                    naechstes_zeichen();
                    return true;
                }
                return false;
            }

            //Parse den Rechenstring und loese komplexe Berechnungen zuerst
            double parse() {
                naechstes_zeichen();
                double ergebnis = parse_ausdruck();
                if (position < str.length()) {
                    throw new RuntimeException("Unerwartetes: " + (char) zeichen);
                }
                return ergebnis;
            }

            //Berechne Plus und MInus
            double parse_ausdruck() {
                
                double ergebnis = parse_term();
                for (;;) {
                    if (vergleichen('+')) {
                        ergebnis += parse_term(); // Addition
                    } else if (vergleichen('-')) {
                        ergebnis -= parse_term(); // Substraktion
                    } else {
                        return ergebnis;
                    }
                }
            }

            //Berechne Mal und Geteilt
            double parse_term() {

                double ergebnis = parse_faktor();
                for (;;) {
                    if (vergleichen('*')) {
                        ergebnis *= parse_faktor(); // Multiplikation
                    } else if (vergleichen('/')) {
                        ergebnis /= parse_faktor(); // Division
                    } else {
                        return ergebnis;
                    }
                }
            }

            //Berechne Winkelfunktionen
            double parse_faktor() {
                if (vergleichen('+')) {
                    return parse_faktor(); // einstelliges Plus
                }
                if (vergleichen('-')) {
                    return -parse_faktor(); // einstelliges Minus
                }
                double ergebnis;
                int anfangs_position = this.position;
                if (vergleichen('(')) { // Klammern
                    ergebnis = parse_ausdruck();
                    vergleichen(')');
                } else if ((zeichen >= '0' && zeichen <= '9') || zeichen == '.') {
                    while ((zeichen >= '0' && zeichen <= '9') || zeichen == '.') {
                        naechstes_zeichen();
                    }
                    ergebnis = Double.parseDouble(str.substring(anfangs_position, this.position));
                } else if (zeichen >= 'a' && zeichen <= 'z') { // Buchstaben bedeutetet Winkelfunktion
                    while (zeichen >= 'a' && zeichen <= 'z') {
                        naechstes_zeichen();
                    }
                    String func = str.substring(anfangs_position, this.position);
                    ergebnis = parse_faktor();
                    if (func.equals("sin")) {
                        ergebnis = Math.sin(Math.toRadians(ergebnis)); // wandle ergebnis er ist Gradzahl um 
                    } else if (func.equals("cos")) {
                        ergebnis = Math.cos(Math.toRadians(ergebnis));
                    } else if (func.equals("tan")) {
                        ergebnis = Math.tan(Math.toRadians(ergebnis));
                    } else {
                        throw new RuntimeException("Unbekannte Funktion: " + func);
                    }
                } else {
                    throw new RuntimeException("Unerwartetes: " + (char) zeichen);
                }

                return ergebnis;
            }
        }.parse()); //Rufe den Parser auf um den Rechenstring zu berechnen
    }

}
