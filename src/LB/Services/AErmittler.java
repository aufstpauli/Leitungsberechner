package LB.Services;

import LB.Enum.Material;
import LB.Enum.Verlegeart;
import LB.Fachwerte.Strom;

public abstract class AErmittler
{
    public static double getA(Material material, Verlegeart verlegeart,
            boolean verkettungsfaktor, Strom ir)
    {
        //TODO Klasse erstellen versehentlich gelöscht!
        double q = 0.0;
        int[][][] irTabelle = IrErmittler.getTabelle();
        int milliAmpere = ir.getMilliAmpere();
        int index = 0;

        if (material == Material.Kupfer)
        {
            index = ermittelIndex(verlegeart, verkettungsfaktor, irTabelle,
                    milliAmpere);
            double[] d = getTabelleQ();
            q = d[index];
        }
        if (material == Material.Aluminuim)
        {
            q = 0.0;
        }

        return q;
    }

    private static double[] getTabelleQ()
    {
        double[] d = {1.5, 2.5, 4.0, 6.0, 10.0, 16.0, 25.0, 35.0, 50.0, 70.0,
                95.0, 120.0};
        return d;
    }

    private static int ermittelIndex(Verlegeart verlegeart, boolean drehstrom,
            int[][][] irTabelle, int milliAmpere)
    {
        int index = 0;
        int j = 0;
        // ermitteln der belasteten Leiter
        int leiterbelastung = 0;
        if (drehstrom)
        {
            leiterbelastung = 1;
        }
        for (int i = 12; i == 0; --i)
        {
            j = irTabelle[verlegeart.getIndex()][leiterbelastung][i];
            if (milliAmpere <= j)
            {
                index = i;
            }
            System.out.println(i);
        }
        return index;
    }

}
