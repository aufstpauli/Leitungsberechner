package LB.Enum;

/**
 * Dieses Enum stellt ein Item für eine ComboBox und lässt damit die Auswertung der Sicherung zu
 * 
 * @author cris
 * @version 11.10.2016
 * @version 11.02.2018 - Vertragsmodell richtig umgesetzt
 *
 */
public enum Sicherung
{
    Leitungsschutzschalter("Leitungsschutzschalter"),
    Schmelzsicherung("Schmelzsicherung");
    
    // globale variable
    private String _description;

    /**
     * Konstruktor zum Erzeugen des Enum
     * @param String description
     * 
     * @require String description != null!
     */
    Sicherung(String description){
        assert description != null:"Vorbedingung verletzt: description != null";
        
        this._description = description; 
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
     * @require String description != null!
     */
    public void setDescription(String description) {
        assert description != null:"Vorbedingung verletzt: description !=null!";
        this._description = description;
    }

    @Override
    public String toString() {
        return _description;
    }
}
