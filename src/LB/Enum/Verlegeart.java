package LB.Enum;

/**
 * Dieses Enum stellt ein Item für eine ComboBox und gibt den Index zur Ermittlung des Ir zurück
 * Es werden die Verlegearten aufgelistet, die dann ausgewählt werden können.
 * 
 * @author cris
 * @version 11.10.2016
 * @version 14.02.2018 - Vertragsmodell richtig umgesetzt und Kommentare überarbeitet
 *
 */
public enum Verlegeart
{
    A1("A1",0),
    A2("A2",1),
    B1("B1",2),
    B2("B2",3),
    C("C",4),
    E("E",5),
    F("F",6),
    G("G",7);
    // globale Variable für den Text
    private String _description;
    // globale Variable für den Index
    private int _index;

    /**
     * Konstruktor zum Erstellen des Enum
     * @param String description
     * @param int index
     * 
     * @require String description !=null!
     * @require int index zwischen 0 und 7
     */
    Verlegeart(String description, int index){
        assert description !=null:"Vorbedingung verletzt: description!=null!";
        assert index >= 0 && index <= 3:"Vorbedingung verletzt: index zwischen 0 und 3";
        
        this._description = description; 
        this._index = index;
    }

    /**
     * Gibt den Text des Enum zurück
     * @return String description
     * 
     * @ensure String _description !=null!
     */
    public String getDescription() {
        return _description;
    }

    /**
     * Setzt den Text des Enum
     * @param String description
     * 
     * @require description!=null!
     */
    public void setDescription(String description) {
        assert description!=null:"Vorbedingung verletzt: description!=null!";
        
        this._description = description;
    }
    
    /**
     * Gibt den Index des Enum zurück
     * @return int index
     * 
     * @ensure int index zwischen 0 und 7
     */
    public int getIndex()
    {
        return _index;
    }
    
    /**
     * Setzt den Index des Enum
     * @param int value
     * 
     * @require int value zwischen 0 und 7
     */
    public void setValue(int value)
    {
        assert value >= 0 && value <=7:"Vorbedingung verletzt: value zwischen 0 und 7";
        this._index = value;
    }

    @Override
    public String toString() {
        return _description;
    }
}
