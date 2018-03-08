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
     * @param _f1
     * @param _f2
     * @return Iz
     * 
     * @require  Strom != null
     * @require f1>0
     * @require f2>0
     * 
     * @ensure Iz != null
     */
    public static Strom getIr(Strom Iz,double _f1,double _f2)
    {
        assert Iz != null : "Vorbedingung verletzt: null";
        assert _f1>0 : "vorbedingung verletzt";
        assert _f2>0 : "vorbedingung verletzt"; 
        
        int milliAmpere =0;
        milliAmpere = (int) Math.round( Iz.getMilliAmpere() / (_f1*_f2));
        return Strom.get(milliAmpere);
    }
}
