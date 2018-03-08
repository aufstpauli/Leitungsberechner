package LB.Enum;

/**
 * Dieses Enum stellt ein Item für eine ComboBox und gibt das Index zur Berechnung des
 * Spannungsfall zurück
 * 
 * @author cris
 * @version 11.10.2016
 * @version - 13.02.2016 Vertragsmodell richtig umgesetzt und Kommentare überarbeitet
 *
 */
public enum Spannungsfall
{
    NullFünf("0,5%",0),
    EinzFünf("1,5%",1),
    Drei("3%",2),
    Fünf("5%",3);
    // globale variable für den text
    private String _description;
    // globale Variable für den Index
    private int _index;

    /**
     * Konstruktor zur Erzeugung des Enum
     * @param String description
     * @param int index
     * 
     * @require String description !=null!
     * @requre int index zwischen 0 und 3
     */
    Spannungsfall(String description, int index){
        assert description != null:"Vorbedingung verletzt: description!=null!";
        assert index >=0 && index <=3:"Vorbedinung verletzt: index zwsichen 0 und 3";
        
        this._description = description; 
        this._index = index;
    }

    /**
     * gibt den Text des Enum zurück
     * @return String description
     * 
     * @ensure String description != null!
     */
    public String getDescription() {
        return _description;
    }

    /**
     * Setzt den text des Enum
     * @param String description
     * 
     * @require String description != null!
     */ 
    public void setDescription(String description) {
        assert description !=null:"Vorbedingung verletzt: description!=null!";
        
        this._description = description;
    }
    
    /**
     * Gibt den Index des Enum zurück
     * @return int index
     * 
     * @ensure index zwischen 0 und 3
     */
    public int getIndex()
    {
        return _index;
    }
    
    /**
     * Setzt den index des Enum
     * @param value
     * 
     * @require int value zwischen 0 und 3
     * 
     */
    public void setIndex(int value)
    {
        assert value >= 0 && value <=3:"Vorbedinung verletzt: value zwischen 0 und 3";
        
        this._index = value;
    }

    @Override
    public String toString() {
        return _description;
    }
}
