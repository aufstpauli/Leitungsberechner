package LB.Services;

import LB.Enum.Material;
import LB.Enum.Verlegeart;
import LB.Fachwerte.Strom;
/**
 * Diese Klasse stellt Methoden zur Strombelastbarkeit der Leitung zur Verfügung
 * 
 * @author cris
 * 
 * @version 10.10.2016
 * @version 04.03.2018  - Kommentare Überarbeitet
 */

public abstract class IrErmittler
{
    /**
     * Diese Methode ermittelt aus den Parametern die Strombelastbarkeit der Leitung
     * genutzt werden die Daten und aus der Tabelle DIN VDE 0298-4
     * 
     * @param material material
     * @param verlegeart verlegeart
     * @param boolean istDrehstrom
     * @param Strom iB
     * @return Strom Ir
     * 
     * @require material != null
     * @require verlegeart != null
     * @require iB != null
     * 
     * @ensure Strom Ir != null
     */
    public static Strom getIR(  Material material, Verlegeart verlegeart, 
                                boolean drehstrom, Strom iB)
    {
        // Vertragsmodell
        assert material != null : "Vorbedingung verletzt: material!=null!";
        assert verlegeart != null : "Vorbedingung verletzt: verlegeart!=null!";
        assert iB != null : "Vorbedingung verletzt: iB!=null";
        
        
        // lädt die Tabelle zum ermitteln der Strombelastbarkeit
        int[][][] irTabelle = getTabelle();
        // Variable für die Milliampere für den Strom der Strombelastbarkeit
        int iR = 0; 
        // Variable für die belasteten Leitern 0=2 belastete Leiter 1=3 belastete Leiter
        int leiterbelastung = 0;
        
        // ermitteln der belasteten Leiter
        if(drehstrom)
        {
            leiterbelastung = 1;
        }

        // ermitteln von Ir für bei Kupferleitern
        if (material == Material.Kupfer)
        {
            // Variable als zwischenspeicher
            int j;
            
            /**
             *  läuft die Tabelle mit den voreingstellten Parameter durch und sichert den Zustand
             *  in dem  Ib <= Ir ist
             */
            for(int i = 11; i >= 0; --i)
            {
                // speichere Ir zwischen
                j = irTabelle[verlegeart.getIndex()][leiterbelastung][i];
                // wenn Ir >= Ib dann abspeichern als Ir
                if(iB.getMilliAmpere()<=j)
                {
                    iR = j;
                }
            }
        }
        return Strom.get(iR);
    }

    /**
     *  Diese Methode liefert eine Dreidimensionale Tabelle der Ströme in milleAmpare zurück.
     *  
     *  - Der erste Index steht für die Verlegeart
     *  - Der zweite Index steht für die belastet Leitungen
     *  - Der dritte Index steht für den Strom in mA
     *  
     * @return i [][][] 
     * 
     * @ensure int i 
     */
    public static int[][][] getTabelle()
    {
        // Dreidimensionales Array für die Tabelle zur Ermittlung der Strombelastbarkeit
        
        int mA [][][] = 
            {
                 // A1
                    { 
                        // Zwei belastete Leitungen
                        {
                                15500, 19500, 26000, 34000, 46000, 61000, 80000,
                                99000, 119000, 151000, 182000, 210000
                        },
                        // Drei belastete Leitungen
                        {
                                13500, 18000, 24000, 31000, 42000, 56000, 73000,
                                89000, 108000, 136000, 164000, 188000
                        }
                    },
                    
                    // A2
                    {
                        // Zwei belastete Leitungen
                        {
                                15500, 18500, 25000, 32000, 43000, 57000, 75000,
                                92000, 110000, 132000, 167000, 192000
                        },
                        // Drei belastete Leitungen
                        {
                                13000, 17500, 23000, 29000, 39000, 52000, 68000,
                                83000, 99000, 125000, 150000, 172000
                        }
                    },
                    
                    // B1
                    {
                        // Zwei belastete Leitungen
                        {
                                17500, 24000, 32000, 41000, 57000, 76000, 101000,
                                125000, 151000, 192000, 232000, 269000
                        },
                        // Drei belastete Leitungen
                        {
                                15500, 21000, 28000, 36000, 50000, 68000, 89000,
                                110000, 134000, 171000, 207000, 239000
                        }
                    },
                    
                    // B2
                    {
                        // Zwei belastete Leitungen
                        {
                                16500, 23000, 30000, 38000, 52000, 69000, 90000,
                                111000, 133000, 168000, 201000, 232000
                        },
                        // Drei belastete Leitungen
                        {
                                15000, 20000, 27000, 34000, 46000, 62000, 80000,
                                99000, 118000, 149000, 179000, 206000
                        }
                    },
                    
                    // C
                    {
                        // Zwei belastete Leitungen
                        {
                                19500, 27000, 36000, 46000, 63000, 85000, 112000,
                                138000, 168000, 213000, 258000,299000
                        },
                        // Drei belastete Leitungen
                        {
                                15000, 20000, 27000, 34000, 46000, 62000, 80000,
                                99000, 118000, 149000, 179000, 2060000
                                //TODO letzen Wert checken
                        }
                    },
                    
                    // E
                    {
                        // Zwei belastete Leitungen
                        {
                                22000, 30000, 40000, 51000, 70000, 94000, 119000,
                                148000, 180000, 232000, 282000,328000
                        },
                        // Drei belastete Leitungen
                        {
                                18500, 25000, 34000, 43000, 60000, 80000, 101000,
                                126000, 153000, 196000, 238000, 276000
                        }
                    },
                    
                    // F
                    {
                        // Zwei belastete Leitungen
                        {
                                0, 0, 0, 0, 0, 0, 131000,
                                162000, 196000, 251000, 304000,352000
                        },
                        // Drei belastete Leitungen
                        {
                                0, 0, 0, 0, 0, 0, 110000,
                                137000, 167000, 216000, 264000, 308000
                        }
                    },
                    
                    // G
                    {
                        // Zwei belastete Leitungen
                        {
                                0, 0, 0, 0, 0, 0, 146000,
                                181000, 219000, 281000, 341000,396000
                        },
                        // Drei belastete Leitungen
                        {
                                0, 0, 0, 0, 0, 0, 130000,
                                162000, 197000, 254000, 311000, 362000
                        }
                    }
            };
        return mA;
    }
}
