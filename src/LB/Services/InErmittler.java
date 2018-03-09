package LB.Services;

import LB.Enum.Sicherung;
import LB.Fachwerte.Strom;

/**
 * Ein Exemplar dieser Klasse stellt den Leistungsschutzschalter dar. Anhand des Betriebsstromes
 * ib wird automatisch ermittelt wie Groß die Strombelastbarkeit der Leitung
 * ist. Iz >= Ib es wird immer der nächst größere Stromwert ausgesucht Dies geschieht gemäß
 * der Regeln der DIn VDE Bestimmungen.
 * .
 * @author cris.
 * @version 08.08.2016
 * @version 09.04.2018 - Kommentare Überarbeitet
 */
public abstract class InErmittler
{

    /**
     * Die Methode ermittelt den Nennstrom der Sicherung anhand des Betriebsstromes und 
     * Art der Sicherung.
     * 
     * @param Strom betriebsStrom
     * @param Sicherung sicherung
     * @return Strom IN
     * 
     * @require Strom betriebsStrom !=null!
     * @require Sicherung sicherung !=null!
     * 
     * @ensure IN !=null!
     */
    public static Strom getSicherungNennstrom(Strom betriebsStrom, Sicherung sicherung)
    {
        assert betriebsStrom != null : "Vorbedingung verletzt: betriebsStrom !=null";
        assert sicherung != null : "Vorbedingung verletzt: sicherung !=null";
        
        return ermittelIN(betriebsStrom,sicherung);
    }


    /**
     * Hilfsmethode zum ermitteln des Stromes
     */
    private static Strom ermittelIN(Strom ib, Sicherung sicherung)
    {
        Strom iN = Strom.get(0);
        if(sicherung == Sicherung.Leitungsschutzschalter)
        {
            iN = werteLeitungsschalterAus(ib, iN);
        }
        else if(sicherung == Sicherung.Schmelzsicherung)
        {
            iN = werteSchraubsicherungAus(ib, iN);
        }
        return iN;
    }

    // Hilfsmethode zum Auswerten der Schraubsicherung
    private static Strom werteSchraubsicherungAus(Strom ib, Strom iN)
    {
        int iB = ib.getMilliAmpere();
        switch(iB)
        {
        case 2000:
        }
        if (iB < 2000)
        {
            iN = Strom.get(2000);
        }
        else if (iB > 2000 && iB <= 4000)
        {
            iN = Strom.get(4000);
        }
        else if (iB > 4000 && iB <= 6000)
        {
            iN = Strom.get(6000);
        }
        else if (iB > 4000 && iB <= 10000)
        {
            iN = Strom.get(10000);
        }
        else if (iB > 10000 && iB <= 13000)
        {
            iN = Strom.get(13000);
        }
        else if (iB > 13000 && iB <= 16000)
        {
            iN = Strom.get(16000);
        }
        else if (iB > 16000 && iB <= 20000)
        {
            iN = Strom.get(20000);
        }
        else if (iB > 20000 && iB <= 25000)
        {
            iN = Strom.get(25000);
        }
        else if (iB > 25000 && iB <= 32000)
        {
            iN = Strom.get(32000);
        }
        else if (iB > 32000 && iB <= 40000)
        {
            iN = Strom.get(40000);
        }
        else if (iB > 32000 && iB <= 50000)
        {
            iN = Strom.get(50000);
        }
        else if (iB > 32000 && iB <= 63000)
        {
            iN = Strom.get(63000);
        }
        else if (iB > 63000 && iB <= 80000)
        {
            iN = Strom.get(80000);
        }
        else if (iB > 80000 && iB <= 100000)
        {
            iN = Strom.get(100000);
        }
        else if (iB > 100000 && iB <= 125000)
        {
            iN = Strom.get(125000);
        }
        else if (iB > 125000 && iB <= 160000)
        {
            iN = Strom.get(160000);
        }
        else if (iB > 160000 && iB <= 200000)
        {
            iN = Strom.get(200000);
        }
        return iN;
    }

    // Hilfsmethode zum Auswerten der Leitungsschalter
    private static Strom werteLeitungsschalterAus(Strom ib, Strom iN)
    {
        int iB = ib.getMilliAmpere();
        switch(iB)
        {
        case 2000:
        }
        if (iB < 2000)
        {
            iN = Strom.get(2000);
        }
        else if (iB > 2000 && iB <= 4000)
        {
            iN = Strom.get(4000);
        }
        else if (iB > 4000 && iB <= 10000)
        {
            iN = Strom.get(10000);
        }
        else if (iB > 10000 && iB <= 13000)
        {
            iN = Strom.get(13000);
        }
        else if (iB > 13000 && iB <= 16000)
        {
            iN = Strom.get(16000);
        }
        else if (iB > 16000 && iB <= 20000)
        {
            iN = Strom.get(20000);
        }
        else if (iB > 20000 && iB <= 25000)
        {
            iN = Strom.get(25000);
        }
        else if (iB > 25000 && iB <= 32000)
        {
            iN = Strom.get(32000);
        }
        else if (iB > 32000 && iB <= 40000)
        {
            iN = Strom.get(40000);
        }
        else if (iB > 32000 && iB <= 50000)
        {
            iN = Strom.get(50000);
        }
        else if (iB > 32000 && iB <= 63000)
        {
            iN = Strom.get(63000);
        }
        else if (iB > 63000 && iB <= 80000)
        {
            iN = Strom.get(80000);
        }
        else if (iB > 80000 && iB <= 100000)
        {
            iN = Strom.get(100000);
        }
        else if (iB > 100000 && iB <= 125000)
        {
            iN = Strom.get(125000);
        }
        return iN;
    }
}
