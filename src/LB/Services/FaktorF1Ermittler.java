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
 * @version 08.03.2018  - F1 von Integer zu Double umgewandelt
 *                      - Kommentare überarbeitet
 *
 */
public abstract class FaktorF1Ermittler
{
    /**
     * Mit der Isolierung und der Temperatur wird der Faktor F2 ermittelt und 
     * als double zurück gegeben.
     * 
     * @param Isolierung isolierung
     * @param Temperatur temperatur
     * @return double f2
     * 
     * @require Isolierung isolierung != null!
     * @require Temperatur temperatur != null!
     * 
     * @ensure double > 0
     */
    public static double getFaktor(Isolierung isolierung, Temperatur temperatur)
    {
        assert isolierung != null:"Vorbedingung verletzt: isolierung!=null!";
        assert temperatur !=null:"Vorbedingung verletzt: temperatur!=nulL!";
        
        // Variable für den Wert für die Rückgabe
        double f2;
        // Variable für die Tabelle
        double[][] tabelle = getTabelle();
        
        // Ermittelt den Wert des Faktos anhand der Parameter
        f2 = tabelle[isolierung.getIndex()][temperatur.getIndex()];
                
        return f2;
    }

    /**
     * Hilfsmethode zum erstellen der Tabelle des Faktors für abweichende Temperatur
     * nach DIN VDE 0298-4
     * @return double tabelle
     * 
     */
    private static double[][] getTabelle()
    {
        double tabelle[][] = 
            {
                    // Gummi
                    {
                        1.29, 1.22, 1.15, 1.08, 1.00, 0.91, 82, 0.71, 0.58
                    },
                    
                    // PVC
                    {
                        1.22, 1.17, 1.12, 1.06, 1.00, 0.94, 0.87, 0.79, 0.71, 0.50
                    },
                    
                    // EPM
                    {
                        1.18, 1.14, 1.10, 1.05, 1.00, 0.95, 0.89, 0.84, 0.77, 0.63
                    }
            };
        return tabelle;
    }
}
