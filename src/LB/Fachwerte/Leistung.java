package LB.Fachwerte;

/**
 * Mit einem Objekt dieser Klasse kann ein Abbild der elektrischen Leistung dargestellt
 * werden. Leistungen können verglichen, addiert, subtrahiert, multipliziert, dividiert
 * und abgefragt werden.
 * 
 * @author cris
 * @version - unbekannt
 * @version 14.02.2018 - Vertragsmodell richtig umgesetzt und Kommentare überarbeitet
 */
public final class Leistung
{
    /**
     * Exemplarvariable zum Speichern des Leistungswertes
     */
    private final int _milliWatt;
    
    /**
     * Initialisiert das feld mit dem Leistungswert
     * @param int milliWatt
     * 
     * @require int milliWatt > 0!
     */
    private Leistung(int milliWatt)
    {
        assert milliWatt >=0:"Vorbedingung verletzt: milliWatt>=0!";
        
        _milliWatt = milliWatt;
    }

    /**
     * erstellt ein Objekt dieser Klasse
     * @param int leistung
     * @return Leistung leistung
     * 
     * @require int leistung >=0
     * @ensure Leistung leistung !=null!
     */
    public static Leistung get(int leistung)
    {
        assert leistung >=0:"Vorbedingung verletzt: leistung >= 0";
        
        return new Leistung(leistung); 
    }
    
    /**
     * Vergleicht ob die Leistung gleich dieser ist
     * @param Leistung leistung
     * @return boolean
     * 
     * @require Leistung leistung!=null!
     */
    public boolean istGleich(Leistung leistung)
    {
        assert leistung !=null:"Vorbedingung verletzt: leistung!=null!";
        
        return _milliWatt == leistung._milliWatt;
    }
    
    /**
     * Verglicht ob die Leistung größer dieser ist
     * @param leistung Leistung
     * @return boolean
     * 
     * @require Leistung leistung != null
     */
    public boolean istGrößer(Leistung leistung)
    {
        assert leistung !=null:"Vorbedingung verletzt: leistung!=null!";
        
        return _milliWatt > leistung._milliWatt;
    }
    
    /**
     * Vergleicht ob die Leistung kleiner dieser ist
     * @param Leistung leistung
     * @return boolean
     * 
     * @require leistung Leistung !=null!
     */
    public boolean istKleiner(Leistung leistung)
    {
        assert leistung !=null:"Vorbedingung verletzt: leistung!=null!";
        
        return _milliWatt < leistung._milliWatt;
    }
    
    /**
     * Addiert die Leistung mir der übergebenen Leistung
     * @param Leistung leistung
     * @return Leistung leistung
     * 
     * @require Leistung leistung !=nulL!
     * 
     * @ensure Leistung leistung !=null!
     */
    public Leistung addiereMit (Leistung leistung)
    {
        assert leistung !=null:"Vorbedingung verletzt: leistung!=null!";
        
        return new Leistung(_milliWatt + leistung._milliWatt);
    }
    
    /**
     * Subtrahiert die Lesitung mit der übergebenen Leistung
     * @param Leistung leistung
     * @return Leistung leistung
     * 
     * @require Leistung leistung!=null!
     * 
     * @ensure Leistung leistung!=null!
     */
    public Leistung subtrahiereMit (Leistung leistung)
    {
        assert leistung !=null:"Vorbedingung verletzt: leistung!=null!";
        
        return new Leistung(_milliWatt - leistung._milliWatt);
    }
    
    /**
     * Multipliziere die Lesitung mit dem übergebenen Faktor
     * @param int fak
     * @return Leistung leistung
     * 
     * @ensure Leistung leistung!=null!
     */
    public Leistung multipliziereMit (int fak)
    {
        return new Leistung(_milliWatt * fak);
    }
    
    /**
     * Dividiert die Lesitung mit dem übergebenen Faktor
     * @param int div
     * @return Leistung leistung
     * 
     * @ensure Leistung leistung !=null!
     */
    public Leistung dividiereMit (int div)
    {
        return new Leistung(Math.round(_milliWatt / div));
    }
    
    /**
     * Gibt die Leistung als String im Format xx,xx zurück (W,mW)
     * @return String Watt
     * 
     * @ensure String Watt !=null!
     */
    public String toString()
    {
        return(_milliWatt / 100 + "," + _milliWatt % 100 );
    }
    
    /**
     * Gibt die Leistung als String im Format xx,xx W zurück (W,mW)
     *@return String Watt
     * 
     * @ensure String Watt !=null!
     */
    public String getStringFormatiert()
    {
        return(_milliWatt / 100 + "," + _milliWatt % 100 + " W");
    }
    
    /**
     * Überschreibt die Override-Methode
     */
    @Override
    public boolean equals(Object obj)
    {
        // Typabgfrage
        if(obj instanceof Leistung)
        {
            // Typzusicherung
            Leistung that = (Leistung) obj;
            return _milliWatt == that._milliWatt;
        }
        return false;
    }
    
    @Override
    public int hashCode()
    {
        return _milliWatt * 41;
    }
}
