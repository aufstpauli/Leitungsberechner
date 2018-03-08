package LB.Werkzeuge.Schritt2.Beobachter;

import java.util.HashSet;
import java.util.Set;

public abstract class BeobachtbarSchritt2
{
    /**
     * Liste für alle Exemplare die die Subwerkzeuge beobachten wollen
     */
    private Set<BeobachterSchritt2> _alleBeobachter;
    
    /**
     * Konstruktor erstellt die Beobachterliste
     */
    public BeobachtbarSchritt2()
    {
        _alleBeobachter = new HashSet<BeobachterSchritt2>();
    }
    
    /**
     * Alle klassen die beocbachen wollen müssen sich hier erst anmelden.
     * @param beobachter
     * 
     * @require beobachter != null
     */
    public void registriereBeobachter(BeobachterSchritt2 beobachter)
    {
        assert beobachter != null : "Vorbedingung verletzt: null";
        _alleBeobachter.add(beobachter);
    }
    
    /**
     * Soll ein Beobachter gelöscht werden so kann dieser aus der liste gelöscht werden
     * @param beoabchter
     * 
     * @require beobachter != null
     */
    public void entferneBeobachter(BeobachterSchritt2 beoabchter)
    {
        assert beoabchter != null : "Vorbedingung verletzt: null";
        _alleBeobachter.remove(beoabchter);
    }
    
    /**
     * Wenn eine Änderung durch eine Interaktion statgefunden hat, sorgt diese Methode
     * dafür, dass dem Beobachter dies mitgeteilt wird
     */
    protected void informiereÜberÄnderung()
    {
        for (BeobachterSchritt2 beobachter : _alleBeobachter)
        {
            beobachter.reagiereAufÄnderung();
        }
    }
}
