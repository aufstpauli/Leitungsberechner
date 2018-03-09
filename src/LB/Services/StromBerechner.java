package LB.Services;

import LB.Fachwerte.Spannung;
import LB.Fachwerte.Strom;

/**
 * Diese abstrakte Klasse stellt eine Methode zur Verfügung die anhand von Leistung,
 * Spannung, CosPhi und der Aussage ob der Verkettungsfaktor (Drehstrom=true) den
 * Strom ausgibt.
 * 
 * @author cris
 * @version 07.08.2016
 * @version 04.03.2018  - Kommentare überarbeitet
 *                      - Vertragsmodell umgesetzt
 *
 */
public abstract class StromBerechner
{    
    /**
     * Berechnet den Strom aus Leistung, Spannung, Strom, CosPhi und Verkettungsfaktor
     * 
     * @param int P
     * @param Spannung U
     * @param double cosPhi
     * @param booloean verkettungsfaktor
     * 
     * @return Strom strom
     * 
     * 
     * @require Spannung U !=null!
     * @require double cosPhi >0 && <1
     * 
     * @ensure Strom != null
     */
    public static Strom getStrom(int P, Spannung U, double cosPhi, boolean verkettungsfaktor)
    {
        assert U !=null:"Vorbedingung verletzt: U!nulL!";
        assert cosPhi>1 && cosPhi <0:"Vorbedingung verletzt: cosPhi nicht zwischen 0 und 1";
        
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
