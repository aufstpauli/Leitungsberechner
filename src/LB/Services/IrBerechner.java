package LB.Services;

import LB.Fachwerte.Strom;

/**
 * Diese Klasse berechnet anhand der Temperaturfaktoren f1 und f2 die Strombelastbarkeit
 * der Leitung
 * 
 * @author cris
 * @version 13.12.2016
 *
 */
public abstract class IrBerechner
{
    /**
     * Diese Methode Berechnet anhand der Temperaturfaktoren f1 und f2 die Strombelastbarkeit
     * der Leitung und gibt den Strom Iz zurück
     * @param Iz
     * @param f1
     * @param f2
     * @return Iz
     * 
     * @require  Strom != null
     * @require f1>0
     * @require f2>0
     * 
     * @ensure Iz != null
     */
    public static Strom getIr(Strom Iz,int f1,int f2)
    {
        assert Iz != null : "Vorbedingung verletzt: null";
        assert f1>0 : "vorbedingung verletzt";
        assert f2>0 : "vorbedingung verletzt"; 
        
        int milliAmpere =0;
        milliAmpere = (int) Math.round( (Iz.getMilliAmpere() *10000) / (f1*f2));
        return Strom.get(milliAmpere);
    }
}
