package LB.Services;

import LB.Fachwerte.Strom;

/**
 * Diese Klasse liefert die Möglichkeit die Strombelastbarkeit der Leitung in dem der 
 * bemessungsstrom der Sicherung gleich gestellt wird.
 * 
 * @author cris
 * @version 12.12.2016
 * @version 13.12.2016
 *
 */
public abstract class IzBerechner
{
    /**
     * Diese Methode setzt den Bemessungsstrom gleich der Strombelastbarkeit der Leitung
     * @param In 
     * @return In
     * 
     * @require In != null
     * 
     * @ensure Iz != null
     */
    public static Strom getIz(Strom In)
    {
        return In;
    }
}
