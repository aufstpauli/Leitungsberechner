package LB.Enum;

/**
 * Dieses Enum stellt ein Item für eine ComboBox und gibt den Index zur Ermittlung des Ir zurück
 * Es werden die Materialien für ein Kabel angegeben.
 * 
 * @author cris
 * @version 11.10.2016
 * @version 11.02.2018 - Vertragsmodell richtig umgesetzt
 *
 */
public enum Material
{
    Kupfer("Kupfer(CU)",0),
    Aluminuim("Aluminium (Al)",1);
    
    // globale Variable für den Text
    private String description;
    // globale Variable für den index
    private int index;

    /**
     * Konstruktor zum Erzeugen des Enum
     * @param String description
     * @param int index
     * 
     * @require String description != null!
     * @require int index zwischen 0 und 1
     */
    Material(String description, int index){
        assert description != null:"Vorbedingung verletzt: description !=null!";
        assert index <= 1 && index >= 0:"Vorbedingung verletzt index zwischen 0 und 1";
        
        this.description = description; 
        this.index = index;
    }

    /**
     * Gibt den Text des Enum zurück
     * @return String description
     * 
     * @ensure description != null!
     */
    public String getDescription() {
        return description;
    }

    /**
     * Ändert den Text des Enum
     * @param String description
     * 
     * @require String description != null!
     */
    public void setDescription(String description) {
        assert description != null:"Vorbedingung verletzt: description !=null!";
        
        this.description = description;
    }
    
    /**
     * Gibt den index des Enum zurück
     * @return int index
     * 
     * @ensure index != null
     */
    public int getIndex()
    {
        return index;
    }
    
    /**
     * Setzt den Index des Enum
     * @param int value
     * 
     * @require int value zwischen 0 und 1
     */
    public void setIndex(int value)
    {
        assert index >= 0 && index <= 1:"Vorbedingung verletzt: Index zwischen 0 und 1";
        this.index = value;
    }

    @Override
    public String toString() {
        return description;
    }
}
