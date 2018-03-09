package LB.Services;

import LB.Enum.Häufung;

/**
 * 
 * @author cris
 * 
 * @version 11.10.2016
 * @version 08.03.2018  - F2 von Integer zu Double umgewandelt
 *                      - Kommentare überarbeitet 
 * 
 * Diese Klasse liefert  eine Methodeden Faktor für die Häufung. Als Parameter wird die 
 * Häufung benötigt. 
 *
 */
public abstract class FaktorF2Ermittler
{
    /**
     * Mit der Anzahl der Häufung ändert sich der Faktor zur Leitungsberechnung. Diese Methode
     * gibt je nach gewählter Häufung den richtigen F2 Faktor zurück
     * 
     * @param Häufung häufung
     * @return double f2
     * 
     * @require Häufung häufung != null
     * 
     * @ensure double f2 != null
     */
    public static double getFaktor(Häufung häufung)
    {
        assert häufung != null : "Vorbedingung verletzt: häufung !=null";
        
        // erstelle die Tabelle
        double[] tabelle = getTabelle();
        // werte Tabelle aus
        int index = häufung.getIndex();
        return tabelle[index];
    }

    /**
     * Gibt die Tabelle in Reihenfolge als double zurück
     */
    private static double[] getTabelle()
    {
        double i[] = {1.00, 0.80, 0.70, 0.65, 0.60, 0.57, 0.54, 0.52, 0.50, 
                        0.48, 0.45, 0.43, 0.41, 0.39, 0.38};
        return i;
    }
}
