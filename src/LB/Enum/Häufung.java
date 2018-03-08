package LB.Enum;

/**
 * Das Enum ist für eine ComboBox um die Häufung von Leitungen anzugeben 
 * und zeigt dessen String als Item an.
 * Die Zahlen werden als index zur Auswertung für den faktor f2 genutzt
 * 
 * @author cris
 * @version11.10.2016
 * @version11.02.2018 - Vertragsmodell genau umgesetzt
 *
 */
public enum Häufung
{
    EINS    ("01 Leitung",0),
    ZWEI    ("02 Leitungen",1),
    Drei    ("03 Leitungen",2),
    VIER    ("04 Leitungen",3),
    FÜNF    ("05 Leitungen",4),
    SECHS   ("06 Leitungen",5),
    SIEBEN  ("07 Leitungen",6),
    ACHT    ("08 Leitungen",7),
    NEUN    ("09 Leitungen",8),
    ZEHN    ("10 Leitungen",9),
    ZWÖLF   ("12 Leitungen",10),
    VIERZEHN("14 Leitungen",11),
    SECHZEHN("16 Leitungen",12),
    ACHTZEHN("18 Leitungen",13),
    ZWANZIG ("20 Leitungen",14);
    
    // exemplar Variable für den Text
    private String _description;
    // exemplar Variable für den Index
    private int _index;

    /**
     * konstruktor für das Erstellen des Enum
     * 
     * @param description
     * @param index
     * 
     * @require String description != NULL!
     * @require int index >= 0 && <= 14
     */
    Häufung(String description, int index){
        assert description != null : "Vorbedingung verletzt: null";
        assert index <=0 && index <= 14 : "Vorbedingung verletzt: nicht im Wertebreich";
        this._description = description; 
        this._index = index;
    }

    /**
     * gibt den Text für den Ausgewählten Enum zurück
     * @return String _description
     * 
     * @ensure String _description != NULL!
     */
    public String getDescription() {
        return _description;
    }

    /**
     * Ändert den Text des Enum an dieser Stelle
     * @param description
     * 
     * @require description != null
     */
    public void setDescription(String description) {
        assert description != null : "Vorbedingung verletzt: null";
        
        this._description = description;
    }
    
    /**
     * Gibt den Index als Int zurück
     * @return index
     * 
     * @ensure int _intex != NULL!
     */
    public int getIndex()
    {
        return _index;
    }
    
    /**
     * Kann den Index ändern
     * @param value
     */
    public void setindex(int value)
    {
        assert value <=0 && value <= 14 : "Vorbedingung verletzt: nicht im Wertebreich";
        this._index = value;
    }

    @Override
    public String toString() {
        return _description;
    }

}
