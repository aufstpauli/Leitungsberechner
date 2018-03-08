package LB.Fachwerte;

/**
 * Mit einem Objekt dieser Klasse kann ein Abbild der elektrischen SPannung dargestellt
 * werden. Spannungen können verglichen, addiert, subtrahiert, multipliziert, dividiert
 * und abgefragt werden.
 * @author cris
 * @version 15.05.2016
 * @version 25.02.2018 - Vertragsmodell richtig umgesetzt, Kommentare überarbeitet
 *
 */
public final class Spannung
{
    /**
     * Exemplarvariable für den Millivolt
     */
    private final int _milliVolt;

    /**
     * Erzeugt ein Objekt von Spannung
     * @param int spannung
     * @return Spannung spannung
     * 
     * @require int spannung >=0!
     * 
     * @ensure Spannung spannung!=null!
     */
    public static Spannung get(int spannung)
    {
        assert spannung >=0:"Vorbedingung verletzt: spannung >=0!";
        
        return new Spannung(spannung);
    }

    /**
     * Initialisiert den Spannungswert
     * @param int spannung
     * 
     * @require int spannung >=0!
     */
    private Spannung(int spannung)
    {
        assert spannung >=0:"Vorbedingung verletzt: spannung >=0!";
       
        _milliVolt = spannung;
    }
    
    /**
     * Vergleicht ob die übergeben Spannung gleich dieser ist
     * @param Spannung spannung
     * @return boolean
     * 
     * @require Spannung spannung !=null!
     */
    public boolean istGleich(Spannung spannung)
    {
        assert spannung !=null:"Vorbedingung verletzt: Spannung!=null!";
        
        return this.equals(spannung);
    }
    
    /**
     * Vergleich ob die Übergebne Spannung größer als diese ist
     * @param spannung Spannung
     * @return boolean
     * 
     * @require spannung Spannung!=null!
     */
    public boolean istKleinerAls(Spannung spannung)
    {
        assert spannung !=null:"Vorbedingung verletzt: Spannung!=null!";
        
        return _milliVolt > spannung._milliVolt;
    }
    
    /**
     * Vergleicht ob die Übergebene Spannung kleiner dieser ist
     * @param Spannung spannung
     * @return boolean
     * 
     * @require Spannung spannung !=null!
     */
    public boolean istGrößerAls(Spannung spannung)
    {
        assert spannung!=null:"Vorbedingung verletzt: spannung!=null!";
        
        return _milliVolt < spannung._milliVolt;
    }
    
    /**
     * Addiert die übergebne Spannung mit dieser
     * @param Spannung spannung
     * @return Spanung spannung
     * 
     * @require Spannung spannung !=null!
     * 
     * @ensure Spannung spannung !=null!
     */
    public Spannung addiereMit(Spannung spannung)
    {
        assert spannung!=null:"Vorbedingung verletzt: spannung !=null!";
        
        return new Spannung(_milliVolt + spannung._milliVolt);
    }
    
    /**
     * Subtrahiere die übergebne Spannung mit dieser
     * @param Spannung spannung
     * @return Spanung spannung
     * 
     * @require Spannung spannung !=null!
     * 
     * @ensure Spannung spannung !=null!
     */
    public Spannung subtrahiereMit(Spannung spannung)
    {
        assert spannung!=null:"Vorbedingung verletzt: spannung !=null!";
        
        return new Spannung(_milliVolt - spannung._milliVolt);
    }
    
    /**
     * multipliziert die Spannung mit dem Faktor
     * @param int fak
     * @return Spanung spannung
     * 
     * @ensure Spannung !=null!
     */
    public Spannung multiplizierMit(double fak)
    {
        return new Spannung((int) Math.round(_milliVolt * fak));
    }
    
    /**
     * Dividiert die Spannung mit dem Divisor
     * @param int div
     * @return Spanung spannung
     * 
     * @ensure Spannung spannung !=null!
     */
    public Spannung dividiereMit(int div)
    {
        return new Spannung( Math.round(_milliVolt / div));
    }
    
    /**
     * gibt den Strom als String im Format xx,xx zurück
     */
    public String toString()
    {
        int ampere = _milliVolt / 1000;
        int milliVolt = _milliVolt % 1000;
        String strVolt = Integer.toString(ampere);
        String strMilliVolt = Integer.toString(milliVolt);
        if(milliVolt < 100)
        {
            strMilliVolt = "0" + strMilliVolt;
        }
        
        if(milliVolt < 10)
        {
            strMilliVolt = "0" + strMilliVolt;
        }
        
        return strVolt + "," + strMilliVolt;
    }
    
    /**
     * gibt die volt als Integer zurück
     * @return int milliVolt
     * 
     * @ensure milliVolt >= 0
     */
    public int toInt()
    {
        return _milliVolt;
    }
    
    /**
     * gibt die Spannug Formatiert zurück im Format xx,xx V
     * @return String Volt
     * 
     * @ensure String Volt !=null!
     */
    public String getStringFormatiert()
    {
        return _milliVolt / 1000 + "," + _milliVolt % 1000 + " V"; 
    }
    
    /**
     * Gibt die Spannung in Volt aus
     * @return double Volt
     * 
     * @ensure Volt >=null!
     */
    public double getSpannungInVolt()
    {
        return _milliVolt / 1000;
    }
    
    /**
     * Überschreibt die equals-Methode damit nur der Zusatend als gleich angeshen
     * wird
     */
    @Override
    public boolean equals(Object obj)
    {
        // Typabfrage
        if(obj instanceof Spannung)
        {
            // Typzusicherung
            Spannung that = (Spannung) obj;
            return _milliVolt == that._milliVolt;
        }
        return false;
    }
    
    /**
     * Erzeugt einen neuen HashCode
     */
    @Override
    public int hashCode()
    {
        return _milliVolt * 41;
    }   
}
