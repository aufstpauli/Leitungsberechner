package LB.Fachwerte;

/**
 * In einem Stromexemplar kann ein Stromwert gespeichert werden und in unterschiedlicher 
 * Form wieder ausgelesen werden.
 * Es ist möglich den Wert komplett in MilliAmpere oder in Ampere auszugeben lassen.
 * Ebenso ist es möglich den Wert Formitiert als String ausgeben zu lassen
 * 
 * @author cris
 * @Version 07.08.2016
 * @version 03.03.2018 - Vertragsmodell richtig umgesetzt, Kommentare überarbeitet
 *
 */
public final class Strom
{
    /**
     * speichert den Strom dauerhaft im Feld
     */
    private final int _milliAmpere;
    
    /**
     * Erzeugt ein neues Objekt dieser Klasse
     * @param milliAmpere
     * @return Strom
     * 
     * ensure Strom != null
     */
    public static Strom get(int milliAmpere)
    {
        return new Strom(milliAmpere);
       
    }
    
    /**
     * Initialisiert den Stromwert
     * @param milliAmpere
     * 
     */
    Strom(int milliAmpere)
    {
        _milliAmpere = milliAmpere;
    }
    
    /**
     * Vergleicht ob beide den gleichen Wert haben
     * @param Strom strom
     * @return boolean
     */
    public boolean istGleich(Strom strom)
    {
        assert strom !=null:"Vorbedingung verletzt: strom!=null!";
        
        return this.equals(strom);
    }
    
    /**
     * Vergleicht ob dessen Strom größer als dieser ist
     * @param Strom strom
     * @return boolean
     */
    public boolean istGrößer(Strom strom)
    {
        assert strom !=null:"Vorbedingung verletzt: strom!=null!";
        
        return this._milliAmpere > strom._milliAmpere;
    }
    
    /**
     * Vergleicht ob dessen Strom kleiner als dieser ist
     * @param Strom strom
     * @return boolean
     */
    public boolean istKleiner(Strom strom)
    {
        assert strom !=null:"Vorbedingung verletzt: strom!=null!";
        
        return this._milliAmpere < strom._milliAmpere;
    }
    
    /**
     * Addiert diesn Strom mit dem Übergeben Strom und liefert einen neuen Strom
     * zurück
     * @param Strom strom
     * @return Strom strom 
     * 
     * @require Strom strom !=null!
     * 
     * @ensure Strom strom !=null!
     */
    public Strom addiereMit(Strom strom)
    {
        assert strom !=null:"Vorbedingung verletzt: strom!=null!";
        
        return new Strom(_milliAmpere + strom._milliAmpere);
    }
    
    /**
     * Subtrahiert den übegeben Strom mit diesen und liefert einen neuen Strom zurück
     * @param Strom strom
     * @return Strom strom 
     * 
     * @require Strom strom !=null!
     * 
     * @ensure Strom strom !=null!
     */
    public Strom subtrahiereMit(Strom strom)
    {
        assert strom !=null:"Vorbedingung verletzt: strom!=null!";
        
        return new Strom(_milliAmpere-strom._milliAmpere);
    }
    
    /**
     * Multiplizeiert den Strom mit dem Übergeben Faktor
     * @param int fak
     * @return Strom strom 
     * 
     * @ensure Strom strom !=null!
     */
    public Strom miltipliziereMit(int fak)
    {
        return new Strom(_milliAmpere * fak);
    }
    
    /**
     * Dividiert den Strom mit dem übergeben Divisor
     * @param int di Strom
     * @return Strom strom
     * 
     * @require div =! 0;
     * 
     * @ensure Strom strom !=null!
     */
    public Strom dividiereMit(int div)
    {
        assert div != 0:"Vertragsbedingung verletzt dif !=0";
        
        return new Strom(Math.round(_milliAmpere/div));
    }
    
    
    
    /**
     * gibt den Strom als String zurück im Vormat xx,xx
     * 
     * @return String str
     * 
     * @ensure String str !=null!
     */
    public String toString()
    {
        int ampere = _milliAmpere / 1000;
        int milliAmpere = _milliAmpere % 1000;
        String strAmpere = Integer.toString(ampere);
        String strMilliAmpere = Integer.toString(milliAmpere);
        if(milliAmpere < 100)
        {
            strMilliAmpere = "0" + strMilliAmpere;
        }
        
        if(milliAmpere < 10)
        {
            strMilliAmpere = "0" + strMilliAmpere;
        }
        
        return strAmpere + "," + strMilliAmpere;
    }
    
    /**
     * gibt den String im Format xx,xx A zurück
     * @return String str
     * 
     * @ensure String str !=null!
     */
    public String getStringFormatiert()
    
    {
        return toString() + " A";
    }
    
    /**
     * gibt den Strom als mA zurück
     * @return int Strom
     * 
     */
    public int getMilliAmpere()
    {
        return _milliAmpere;
    }
    
    /**
     * Überschreibt die equals-Methode. Objekte gelten als Gleich, wenn der 
     * Millistrom gleich ist
     */
    @Override
    public boolean equals(Object obj)
    {
        // Typabfrage
        if(obj instanceof Strom)
        {
            // Typzusicherung
            Strom that = (Strom) obj;
            return this._milliAmpere == that._milliAmpere;
        }
        return false;
    }
    
    /**
     * Erzeugt einen Hashcode
     */
    @Override
    public int hashCode()
    {
        return _milliAmpere * 41;
    }

}
