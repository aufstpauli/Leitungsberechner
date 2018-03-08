package LB.Services;

import LB.Enum.Isolierung;
import LB.Enum.Temperatur;

/**
 * Diese Klasse ist für die statische Ermittlung des Faktors F1. Sie richtet sich nach der Tabelle
 * von der DIN VDE 0298-4
 * 
 * @author cris
 * 
 * @version 10.10.2016
 *
 */
public abstract class FaktorF1Ermittler
{
    /**
     * !!! Der Faktor wird als Integer geliefert und nicht als double, daher 
     * muss das Ergebnis nach Nutzung durch 100 dividiert werden !!!
     * 
     * @param isolierung
     * @param temperatur
     * @return
     */
    public static int getFaktor(Isolierung isolierung, Temperatur temperatur)
    {
        // Variable für den Wert für die Rückgabe
        int f2;
        // Variable für die Tabelle
        int[][] tabelle = getTabelle();
        
        // Ermittelt den Wert des Faktos anhand der Parameter
        f2 = tabelle[isolierung.getIndex()][temperatur.getIndex()];
                
        return f2;
    }

    /**
     * Hilfsmethode zum erstellen der Tabelle des Faktors für abweichende Temperatur
     * nach DIN VDE 0298-4
     * @return int tabelle
     * 
     * @ensure int tabelle !=null
     */
    private static int[][] getTabelle()
    {
        int tabelle[][] = 
            {
                    // Gummi
                    {
                        129,122,115,108,100,91,82,71,58
                    },
                    
                    // PVC
                    {
                        122,117,112,106,100,94,87,79,71,50
                    },
                    
                    // EPM
                    {
                        118,114,110,105,100,95,89,84,77,63
                    }
            };
        return tabelle;
    }
}
