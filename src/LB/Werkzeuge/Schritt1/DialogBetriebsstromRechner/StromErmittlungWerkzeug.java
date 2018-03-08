package LB.Werkzeuge.Schritt1.DialogBetriebsstromRechner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import LB.Fachwerte.Spannung;
import LB.Fachwerte.Strom;
import LB.Services.StromBerechner;
import LB.Werkzeuge.Schritt1.beobachter.BeobachtbarSchritt1;
import LB.Werkzeuge.UIKompomente.JNumberTextFieldAnzeige;
import LB.Werkzeuge.UIKompomente.JNumberTextFieldCosPhi;

/**
 * Diese Klasse ist für die Interaktion für die Ermittlung des Betriebsstromes zuständig
 * Es wird von der Klasse BeobachtbarSubwerkzeug geerbt, damit eine Beobachtung möglich
 * ist und Veränderungen mitgeteilt werden können.
 * Es wird die UI erstekllt und alle Listener registriert, die für eiene Interaktion
 * nötig sind. Mit dem Stromberechner wird der resultierende Strom ermittelt und
 * gespeichert und kann dann abgerufen werden
 * 
 * @author cris
 * @version 07.08.2016
 *
 */
public class StromErmittlungWerkzeug extends BeobachtbarSchritt1
{
    private StromErmittlungUI _ui;
    private Strom _ib;
    private Spannung _ub;
    private double _cosPhi;
    private boolean _verkettungsfaktor = false;
    

    /**
     * Konstruktor - erzeuge die UI-Komponenten und die Logikverknüpfung. registriert die
     * Listener und initialisiert den Strom auf 0
     */
    public StromErmittlungWerkzeug()
    {
        _cosPhi = 1.0;
        _ui = new StromErmittlungUI(Double.toString(_cosPhi));
        registriereActionListener();
    }

    /**
     * Registriert den Eingabebutton Es wird das Textfield Eingabe ausgelesen und dann 
     * alle "," in ein "." umgewandelt, damit eine Double erzeugt werden kann. Dieses wird
     * dann als Stromwert übergeben. Wenn das nicht klappt wird ein fenster geöffnet mit
     * der Vorgegeben Fehlermeldung
     */
    private void registriereActionListener()
    {
        /**
         * Registriert den Berechnebutton. Es werden die Felder ausgelesen und in die
         * Integer und Double umgewandelt. Mit dem Stromberechner wird der Strom erzeugt
         * Wenn die Eingabe Fehlerhaft ist, wird eine Fehlermeldung mit dem fehlertext 
         * ausgegeben
         */
        _ui.getBerechneButton()
            .addActionListener(new ActionListener()
            {

                @Override
                public void actionPerformed(ActionEvent e)
                {
                    ermittelIB();
                }

                private void ermittelIB()
                {
                    // lokale Variablen
                    int p;
                    double cosPhi;
                    // Fehlerüberwachung
                    try
                    {
                        // Liest und wandelt die Textfelder in Integer aus
                        p = Integer.parseInt(_ui.getLeistungWert().getText());
                        // Liest und wandelt die Textfelder in String und anschließend 
                        // in Double um
                        String str = parseCosPhi();
                        cosPhi = Double.parseDouble(str);
                        // ermittelt ib
                        _ib = StromBerechner.getStrom(p, _ub, cosPhi, _verkettungsfaktor);
                        _ui.getErgebnisTextField().setText( "Ib = "+_ib.getStringFormatiert());
                        _ui.getÜbernehmenButton().setEnabled(true);
                    }
                    // bei Fehlerfall
                    catch (NumberFormatException nme)
                    {
                        JOptionPane.showMessageDialog(null,
                                "Fehler beim Komventieren");
                    }
                }
            });

        /**
         * Aktionlissetner für den Abbrechbutton -> Dialog wird einfach geschlossen ohne
         * das etwas anderes geamcht wird
         */
        _ui.getAbbrechenButton()
            .addActionListener(new ActionListener()
            {

                @Override
                public void actionPerformed(ActionEvent e)
                {
                    _ui.getDialog().dispose();
                }
            });

        /**
         * Aktionlistener für den Übernahmebutton -> 
         * - ib der Errechnet wurde wird 
         * an das Leitungswerkzeug übergeben
         * - Das Dialog wird beendet
         */
        _ui.getÜbernehmenButton()
            .addActionListener(new ActionListener()
            {

                @Override
                public void actionPerformed(ActionEvent e)
                {
                    _ui.getDialog().dispose();
                    informiereÜberÄnderung();
                }

            });

    }

    /**
     * Wandelt im CosPhi alle Komma in ein Punkt um
     * @return String
     * 
     * @ensure String != null
     */
    private String parseCosPhi()
    {
        String str = _ui.getCosPhiTextField().getText();
        str = str.replace(",", ".");
        return str;
    }
    
    public void setVerkettungsfaktor(boolean verkettungsfaktor)
    {
        _verkettungsfaktor = verkettungsfaktor;
    }
    
    public void setUB(Spannung u)
    {
        _ub = u;
    }

    /**
     * gibt das Panel zurück
     * @return JPanel
     * 
     * @ensure JPanel != null
     */
    public JDialog getDialog()
    {
        return _ui.getDialog();
    }

    /**
     * Gibt den Betriebsstrom zurück
     * 
     * @return Strom
     * 
     * @ensure Strom != null
     */
    public Strom getIb()
    {
        return _ib;
    }

    public JNumberTextFieldCosPhi getCosPhi()
    {
        return _ui.getCosPhiTextField();
    }
    
    public JNumberTextFieldAnzeige getSpannungTextField()
    {
        return _ui.getSpannungTextField();
    }
}
