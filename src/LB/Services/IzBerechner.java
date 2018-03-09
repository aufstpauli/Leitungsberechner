package LB.Services;

import LB.Fachwerte.Strom;

/**
 *  Diese Klasse setzt die Strombelastbarkeit gleich der des Nennstroms.
 * 
 * @author cris
 * @version 12.12.2016
 * @version 04.03.2018  - Kommentare überarbeitet
 *                      - Vertragsmodell eingeführt
 *
 */
public abstract class IzBerechner
{

    /**
     * Diese Methode setzt den Bemessungsstrom gleich der Strombelastbarkeit der Leitung
     * 
     * @param Strom In
     * @return Strom Iz     
     * 
     * @require Strom In!=null!
     * 
     * @ensure Strom Iz!=null!
     */
    public static Strom getIz(Strom In)
    {
        assert In != null:"Vorbedingung verletzt: In!=null!";
        
        return In;
    }
}
