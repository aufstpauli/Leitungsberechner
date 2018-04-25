package LB.Services;

import LB.Enum.Material;
import LB.Enum.Verlegeart;
import LB.Fachwerte.Strom;

/**
 * Diese Klasse liefert verschiedene Methoden zum Ermitteln des Querschnitts.
 * @author cris
 * @version unbekannt
 * @version 12.04.2018  - getA funktionsfähig
 *                      - Kommentare hinzugefügt
 *                      - Vertrag   smodell hinzugeügt
 *                      - Methode nächstHöhererQuerschnitt hinzugefügt
 *
 */
public abstract class AErmittler
{
    /**
     * Diese Methode gibt den Mindesquerschnitt für Leitung zurück. Dafür
     * wird das Material, die Verlegeart, ob der verkettungsfaktor genutzt
     * wird und der maximal Strom der Leitung (Ir) als Parameter verwendet
     * 
     * @param Material material
     * @param Verlegeart verlegeart
     * @param boolean verkettungsfaktor
     * @param Strom ir
     * 
     * @return double q
     * 
     *@require Material material!=null!
     *@require Verlegeart verlegeart!=null!
     *@require Strom ir!=null!
     *
     *@ensure double q >= 1,5
     */
    public static double getA(Material material, Verlegeart verlegeart,
            boolean verkettungsfaktor, Strom ir)
    {
        assert material!=null:"Vorbedingung verletzt: material!=null!";
        assert verlegeart!=null:"Vorbedingung verletzt: verlegeart!=null!";
        assert ir!=null:"Vorbedingung verletzt: ir!=null!";
        
        double q = 1.5;
        int index = 0;

        if (material == Material.Kupfer)
        {
            index = ermittelIndex(verlegeart, verkettungsfaktor, ir);
            double[] d = getTabelleQ();
            q = d[index];
        }
        if (material == Material.Aluminuim)
        {
            //TODO Für Aluminuim muss noch erstellt werden
            q = 1.5;
        }
        return q;
    }

    /**
     * Diese Methode ermittelt den nächst Höheren Wert von dem Angegeben 
     * Querschnitt.
     * @param double q
     * @return double newQ
     * 
     * require double q >=1,5
     * 
     * @ensure q >= 2,5
     */
    public static double nächtHöhererQuerschnitt(double q)
    {
        assert q <= 1.5:"Vorbedingung verletzt: q > 1,5!";
        
        double newQ = 1.5;
        double[] listQ = getTabelleQ();

        for (int i = 11; i >=0; --i)
        {
            if( (q == listQ[i]) && (i<11) )
            {
                newQ = listQ[i+1];
            }
        }

        return newQ;
    }

    /**
     * Diese Methode liefert ein Array mit den Qerschnitten zurück
     */
    private static double[] getTabelleQ()
    {
        double[] d = {1.5, 2.5, 4.0, 6.0, 10.0, 16.0, 25.0, 35.0, 50.0, 70.0,
                95.0, 120.0};
        return d;
    }
    
    /**
     * Diese Methode ermittelt anhand der Strombelastbarkeit der Leitung den 
     * Index mit dem dann der Querschnitt ermittelt werden kann.
     * 
     * @param Verlegeart verlegeart
     * @param boolean drehstrom
     * @param intcmilliAmpere
     * @return
     */
    private static int ermittelIndex(Verlegeart verlegeart, boolean drehstrom,
            Strom ir)
    {
        assert verlegeart!=null:"Vorbedingung verletzt: verlegeart!=null!";
        assert ir!=null:"Vorbedingung verletzt: ir!=null!";
        
        int milliAmpere = ir.getMilliAmpere();
        int[][][] irTabelle = IrErmittler.getTabelle();
        int index = 0;
        int j = 0;

        // ermitteln der belasteten Leiter
        int leiterbelastung = 0;
        if (drehstrom)
        {
            leiterbelastung = 1;
        }
        for (int i = 11; i >= 0; --i)
        {
            j = irTabelle[verlegeart.getIndex()][leiterbelastung][i];
            if (milliAmpere <= j)
            {
                index = i;
            }
        }

        return index;
    }

}
