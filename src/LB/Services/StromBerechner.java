package LB.Services;

import LB.Fachwerte.Spannung;
import LB.Fachwerte.Strom;

/**
 * Diese Abstrackte Klasse gibt ein Strom zurück und berechnet oder ermttelt anhand
 * der Parameter den richtigen Stromwert
 * 
 * @author cris
 * @version 07.08.2016
 *
 */
public abstract class StromBerechner
{    
    /**
     * 
     * @param P Leistungswert
     * @param U Spannungswert
     * @param cosPhi
     * @param verkettungsfaktor
     * @return Strom
     * 
     * 
     * @ensure Strom != null
     */
    public static Strom getStrom(int P, Spannung U, double cosPhi, boolean verkettungsfaktor)
    {
        // Verkettungsfaktor bestimmen
        double wurzelDrei = Math.sqrt(3);
        
        if(verkettungsfaktor == true)   // Wenn Verkettungsfaktos ...  mit Verkettungsfaktor rechnen
        {
            return Strom.get( (int) (1000 * ((P / (U.getSpannungInVolt() * cosPhi * wurzelDrei)))) );
        }
        else                // sonst ohne Verkettungsfaktor rechnen
        {
            return Strom.get( (int) ( 1000* (P / (U.getSpannungInVolt() * cosPhi))) );
        }
    }
}
