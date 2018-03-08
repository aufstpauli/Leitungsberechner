package LB.Enum;

/**
 * Dieses Enum stellt einen Item für eine ComboBox und gibt den Index zur Ermittlung des Faktors f1
 * zurück.
 * 
 * @author cris
 * @version Datum unbekannnt
 * @version 13.02.2018 - Vertragsmodell richtig umgesetzt und Kommentare überarbeitet
 */
public enum Temperatur
{
    Zehn("10 C°",0),
    Fünfzehn("15 C°",1),
    Zwanzig("20 C°",2),
    Fünfundzwanzig("25 C°",3),
    Dreizig("30 C°",4),
    Fünfunddreizig("35 C°",5),
    Vierzig("40 C°",6),
    Fünfundvierzig("45 C°",7),
    Fünfzig("50 C°",8),
    Fünfundfünfzig("55 C°",9),
    Sechszig("60 C°",10);
    // globale Variable für den Text
    private String _description;
    // globale Variable für den Index
    private int _index;

    /**
     * Konstruktor zum Erstellen des Enum
     * @param description
     * @param value
     * 
     * @require description !=null!
     * @require value 0 zwischen 10
     */
    Temperatur(String description, int value){
        assert description!=null:"Vorbedingung verletzt: description!=null!";
        assert value >= 0 && value <=10:"Vorbedingung verletzt: value zwischen 0 und 10";
        
        this._description = description; 
        this._index = value;
    }

    /**
     * Gibt den Text des Enum zurück
     * @return String description
     * 
     * @ensure String description != null
     */
    public String getDescription() {
        return _description;
    }

    /**
     * Setzt den text des Enum
     * @param String description
     * 
     * @require String description !=null!
     */
    public void setDescription(String description) {
        assert description!=null:"Vorbedingung verletzt: description!=null!";
        
        this._description = description;
    }
    
    /**
     * Gibt den Index zurück
     * @return int index
     * 
     * @ensure int index zwischen 0 und 10
     */
    public int getIndex()
    {
        return _index;
    }
    
    /**
     * Ändert den Index des Enum
     * @param int value
     * 
     * @require int value zwischen 0 und 10
     */
    public void setValue(int value)
    {
        assert value >=0 && value <=10:"Vorbedingung verletzt: value zwischne 0 und 10";
        
        this._index = value;
    }

    @Override
    public String toString() {
        return _description;
    }
}
