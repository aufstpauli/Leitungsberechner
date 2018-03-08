package LB.Werkzeuge.Schritt1.beobachter;

import java.util.HashSet;
import java.util.Set;

/**
 * Mit hilfe dieser Klasse ist es möglich, dass Klassen beoabachtet werden können und
 * somit Änderung an andere KLassen mitgeteilt werden können. Soll eine Klasse
 * beobachter werden, muss sie von dieser Abstrakten Klasse erben.
 * 
 * @author cris
 * @version 07.08.2016
 *
 */
public abstract class BeobachtbarSchritt1
{
    /**
     * Liste für alle Exemplare die die Subwerkzeuge beobachten wollen
     */
    private Set<BeobachterSchritt1> _alleBeobachter;
    
    /**
     * Konstruktor erstellt die Beobachterliste
     */
    public BeobachtbarSchritt1()
    {
        _alleBeobachter = new HashSet<BeobachterSchritt1>();
    }
    
    /**
     * Alle klassen die beocbachen wollen müssen sich hier erst anmelden.
     * @param beobachter
     * 
     * @require beobachter != null
     */
    public void registriereBeobachter(BeobachterSchritt1 beobachter)
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
    public void entferneBeobachter(BeobachterSchritt1 beoabchter)
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
        for (BeobachterSchritt1 beobachter : _alleBeobachter)
        {
            beobachter.reagiereAufÄnderung();
        }
    }
}
