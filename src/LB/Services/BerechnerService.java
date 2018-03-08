package LB.Services;

import LB.Enum.Häufung;
import LB.Enum.Isolierung;
import LB.Enum.Material;
import LB.Enum.Sicherung;
import LB.Enum.Temperatur;
import LB.Enum.Verlegeart;
import LB.Fachwerte.Strom;

public class BerechnerService
{
    /**
     * Eermittelt anhand des Betriebsstromes und der Art der Sicherung den 
     * Nennstrom und gibt diesen als Strom zurück 
     * @param Strom ib
     * @param Sicherung sicherung
     * @return Strom in
     * 
     * @require Strom ib != Null
     * @require Sicherung sicherung != Null
     * 
     * @ensure Strom in != Null
     */
    public Strom getIn(Strom ib, Sicherung sicherung)
    {
        assert ib != null : "Vorbedingung verletzt: null";
        assert sicherung != null : "Vorbedingung verletzt: null";

        Strom in = InErmittler.getSicherungNennstrom(ib, sicherung);
        return in;
    }

    /**
     * 
     * @param in
     * @return
     */
    public Strom getIz(Strom in)
    {
        Strom iz = IzBerechner.getIz(in);
        return iz;
    }

    public int getF1(Isolierung isolierung, Temperatur temperatur)
    {
        int f1 = FaktorF1Ermittler.getFaktor(isolierung, temperatur);
        return f1;
    }

    public int getF2(Häufung häufung)
    {
        int f2 = FaktorF2Ermittler.getFaktor(häufung);
        return f2;
    }

    public Strom getIr(Strom iz, int f1, int f2)
    {
        Strom ir = IrBerechner.getIr(iz, f1, f2);
        return ir;
    }

    public double getA(Material material, Verlegeart verlegeart,
            boolean verkettungsfaktor, Strom ir)
    {
        double q = AErmittler.getA(material, verlegeart, verkettungsfaktor, ir);
        return q;
    }
}
