package LB.Enum;

/**
 * Dieses Enum ist für die Auswahl der Isolierung  da und liefert der ComboBox die items
 * und gibt den Index bei der Auswertung für den Faktor f2
 * 
 * @author cris
 * @version 11.10.2016
 * @version11.02.2018 - Vertragsmodell genau umgesetzt
 *
 *
 *
 */
public enum Isolierung
{
    Gummi("Kautschuk (Gummi)",0),
    PVC("Polyvinylchlorid (PVC)",1),
    EPM("Ethylenpropylenkaut (EPM)",2);
    
    // globale Variable für den text
    private String description;
    // globale Variable für den index
    private int index;

    /**
     * Konstruktor für die Erstellung des Enum
     * @param description
     * @param index
     * 
     * @require String description != null!
     * @require int index >= 0 && <= 2
     * 
     */
    Isolierung(String description, int index){
        assert description != null: "Vorbedingung verletzt: description != null";
        assert index >= 0 && index <= 2:"Vorbedingung verletzt: index zwischen 0 und 2";
        
        this.description = description; 
        this.index = index;
    }

    /**
     * Gibt den Text des Enum zurück
     * @return Stringdescription
     * 
     * @ensure String description != null
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setzt den Text des Enum
     * @param String description
     * 
     * @require String description != null!
     */
    public void setDescription(String description) {
        assert description != null:"Vorbedingung verletzt! description != null!";
        
        this.description = description;
    }
    
    /**
     * Gibt den Index des Enum zurück
     * @return int index
     * 
     * @ensure int index !=null!
     */
    public int getIndex()
    {
        return index;
    }
    
    /**
     * setzt den index des Enum
     * @param int index
     * 
     * @require int index >= 0 && <= 2
     */
    public void setIndex(int index)
    {
        assert index >= 0 && index <= 2:"Vorbedingung verletzt: index zwischen 0 und 2";
        this.index = index;
    }

    @Override
    public String toString() {
        return description;
    }
};
