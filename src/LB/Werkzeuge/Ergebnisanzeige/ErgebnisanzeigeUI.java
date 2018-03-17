package LB.Werkzeuge.Ergebnisanzeige;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;

/**
 * Ein Exemplar dieser Klasse stellt die GUI zur Anzeige der Ergebnisse.
 * 
 * @author cris
 * @version unbekannt
 * @version 04.03.2018  - Kommentare hinzugefügt
 *
 */
public class ErgebnisanzeigeUI
{
    // private Variablen
    private final static int WIDTH = 780;
    private final static int HEIGHT = 155;
    private JPanel _hauptPanel;
    private JTextArea _ergebnisanzeige;
    
    /**
     * Konstruktor zum Inizialisieren des erzeugten Exemplares
     */
    public ErgebnisanzeigeUI()
    {
        erstelleHauptpanel();
        
        _ergebnisanzeige = new JTextArea();
        _ergebnisanzeige.setDisabledTextColor(Color.BLACK);
        _ergebnisanzeige.setEnabled(false);
        JScrollPane scrollpane = new JScrollPane(_ergebnisanzeige);
        
        
        _hauptPanel.add(scrollpane);
    }
    
    /**
     * Diese Methode gibt das Hauptpanel zurück
     * 
     * @return JPanel _hauptPanel
     * 
     * @ensure JPanel _hauptPanel!null!
     */
    public JPanel getPanel()
    {
        return _hauptPanel;
    }
    
    /**
     * Diese Methode liefert das TextArea zurück. Dort wird der Text eingefügt.
     * @return
     */
    public JTextArea getErgebnisTextArea()
    {
        return _ergebnisanzeige;
    }
    
    /**
     * Erstellt das Hauptpanel und initialisiert es
     */
    private void erstelleHauptpanel()
    {
        _hauptPanel = new JPanel();
        _hauptPanel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        GridLayout gl = new GridLayout(1, 1);
        _hauptPanel.setLayout(gl);
        _hauptPanel.setBorder(new EtchedBorder());
    }
}
