package LB.Enum;
/**
 * Dieses Enum stell ein Item für eine ComboBox zur Verfügung. Es stellt die Auswahl
 * für die Wahl der Spannungsart dar. Ein Index lässt die Auswahl besser verarbeiten
 * 0 = Gleichspannung
 * 1 = Wechselspannung
 * 2 = Dreiphasenwechselspannung
 * 
 * @author cris
 * @version 11.10.2016
 * @version 11.02.2018  - Vertragsmodell richtig umgesetzt
 *                      - Kommentare ergänzt
 *
 */
public enum Spannungsart
{
    Gleichspannung("Gleichspannung",0),
    Wechselspannung("Wechselspannung",1),
    Dreiphasenwechselspannung("Dreiphasenwechselspannung",2);
    // globale Variable für den Text
    private String _description;
    // globale Variable für den Index
    private int _index;

    /**
     * Konstruktor zum Erzeugen des Enum
     * 
     * @param description
     * @param index
     * 
     * @require description != null!
     * @require index zwischen 0 und 2
     */
    Spannungsart(String description, int index){
        assert description != null:"Vorbedingung verletzt: description !=null!";
        assert index >= 0 && index <= 2:"Vorbedingung verletzt: index zwsichen 0 und 2!";
        
        this._description = description; 
        this._index = index;
    }

    /**
     * Gibt den Text des Enum zurück
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
     * @String description != null!
     */
    public void setDescription(String description) {
        assert description != null:"Vorbedingung verletzt: description!=null!";
        
        this._description = description;
    }
    
    /**
     * Gibt den Index zurück
     * @return int index
     * 
     * @ensure int index zwischen 0 und 2
     */
    public int getIndex()
    {
        return _index;
    }
    
    /**
     * Setzt den Index für das Enum
     * @param int index
     * 
     * @require int index zwischen 0 und 2
     */
    public void setIndex(int index)
    {
        assert index >= 0 && index <=2:"Vorbedingung verletzt: index zwischen 0 und 2";
        
        this._index = index;
    }

    @Override
    public String toString() {
        return _description;
    }
}
