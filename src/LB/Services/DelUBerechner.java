package LB.Services;

import LB.Fachwerte.Spannung;
import LB.Fachwerte.Strom;

/**
 * Diese Klasse berechnet den aktuellen Spannungsfall
 * 
 * @author cris
 * @version 14.12.2016
 * @version 03.03.2018 - Kommentare überarbeitet
 *
 */
public abstract class DelUBerechner
{
    /**
     * Die übergeben Parameter werden in die Formel eingegeben und somit wird der
     * aktuelle Spannungsfall berechnet und wiedergegeben.
     * 
     * @param double länge
     * @param Strom Ib
     * @param double cosPhi
     * @param double q
     * @return Spannung delU
     * 
     * @require länge >0!
     * @require Strom !=0!
     * @require 0>= cosPhi <=1!
     * @require d >0!
     * 
     * @ensure delU !=0!
     */
    public static Spannung getDeltaU(double länge, Strom Ib, double cosPhi, double q)
    {
        assert länge >0 : "vorbedingung verletzt: länge >0!";
        assert Ib != null : "Vorbedingung verletzt: ib!=null!";
        assert cosPhi >0 && cosPhi <=1 : "vorbedingung verletzt: cosPhi 0>= cosPhi <=1!";
        assert q >0 : "vorbedingung verletzt: q>0!";
        
        final int kappa = 56;
        int milliVolt = (int) ((2*länge*Ib.getMilliAmpere()*cosPhi)/(kappa*q));
        return Spannung.get(milliVolt);
    }
}
