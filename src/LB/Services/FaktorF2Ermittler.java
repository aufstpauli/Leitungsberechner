package LB.Services;

import LB.Enum.Häufung;

/**
 * 
 * @author cris
 * 
 * @version 11.10.2016
 * 
 * Diese Klasse liefert  eine Methodeden Faktor für die Häufung. Als Parameter wird die 
 * Häufung benötigt. 
 *
 */
public abstract class FaktorF2Ermittler
{
    /**
     * Liefert den Faktor für die Häufung zurück
     * 
     * !!! Der Faktor wird als Integer geliefert und nicht als double, daher 
     * muss das Ergebnis nach Nutzung durch 100 dividiert werden !!!
     * 
     * @param häufung
     * @return int f2
     * 
     * @require häufung != null
     * @ensure int f2 != null
     */
    public static double getFaktor(Häufung häufung)
    {
        assert häufung != null : "Vorbedingung verletzt: null";
        // erstelle die Tabelle
        double[] tabelle = getTabelle();
        // werte Tabelle aus
        int index = häufung.getIndex();
        return tabelle[index];
    }

    private static double[] getTabelle()
    {
        double i[] = {1.00, 0.80, 0.70, 0.65, 0.60, 0.57, 0.54, 0.52, 0.50, 
                        0.48, 0.45, 0.43, 0.41, 0.39, 0.38};
        return i;
    }
}
