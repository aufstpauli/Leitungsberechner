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
    public static int getFaktor(Häufung häufung)
    {
        assert häufung != null : "Vorbedingung verletzt: null";
        // erstelle die Tabelle
        int[] tabelle = getTabelle();
        // werte Tabelle aus
        int index = häufung.getIndex();
        return tabelle[index];
    }

    private static int[] getTabelle()
    {
        int i[] = {100,80,70,65,60,57,54,52,50,48,45,43,41,39,38};
        return i;
    }
}
