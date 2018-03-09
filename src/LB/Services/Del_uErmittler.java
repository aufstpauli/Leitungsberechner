package LB.Services;

import LB.Enum.Spannungsfall;
import LB.Fachwerte.Spannung;

/**
 * Diese Klasse stellt eine Methode zur Verfügung mit der den maximalen Spannungsfall
 * der Leitung ausgiebt. Dafür wird die aktuelle Spannung und der Prozentualer Wert 
 * der maximalen Spannung benötigt.
 * 
 * @author cris
 * @version 14.12.2016
 * @version 03.03.2018 - Kommentare überarbeitet
 *
 */
public abstract class Del_uErmittler
{
    /**
     * Diese Methode berechnet anhand des maximalen Prozentualen Spannungsfalls
     * Den maximalen Betrag an Spannungsfall.
     * @param Spannung Ub
     * @param Spannungsfall del_u
     * @return Spannung del_uMax
     * 
     * @require Spannung Ub !=null
     * @require Spannungsfall del_u !=null
     * 
     * @ensure Spannung del_uMax != null
     */
    public static Spannung getDel_uMin(Spannung Ub,Spannungsfall del_u)
    {
        assert Ub != null : "Vorbedingung verletzt: Ub!=null";
        assert del_u != null : "Vorbedingung verletzt:del_u null";
        
        double[] delta_uTable = {0.5,1.5,3.0,5.0};
        double delta_u = delta_uTable[del_u.getIndex()];
        Spannung del_uMax = Ub.multiplizierMit(delta_u/100);
       
        return del_uMax;     
    }
}
