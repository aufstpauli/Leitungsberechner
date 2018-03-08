package LB.Werkzeuge.Schritt4;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

public class Schritt4UI
{
    private final static int width = 780;
    private final static String TEXT_TITEL = "Schritt [4] - Berechnung durchführen";
    private final static String TEXT_BERECHNUNG = "Führe Berechnung durch";
    private final static String TEXT_BERECHNUNG_BUTTON = "Querschnitt berechnen";
    private static final Font SCHRIFTART_NORMAL = new Font("Serif", Font.BOLD,
            15);
    private static final Color TEXTFARBE_ROT = new Color(255, 50, 50);
    private JPanel _hauptPanel;
    private JButton _berechneButton;
    
    public Schritt4UI()
    {
        erstelleHauptpanel();
        fülleHauptPanel();
    }
    
    /**
     * Erstellt das Hauptpanel undinitialisiert es
     */
    private void erstelleHauptpanel()
    {
        _hauptPanel = new JPanel();
        _hauptPanel.setPreferredSize(new Dimension(width, 70));
        GridLayout gl = new GridLayout(2, 1);
        _hauptPanel.setLayout(gl);
        _hauptPanel.setBorder(new EtchedBorder());
    }
    
    /**
     * Erstellt das Titellabel
     * @return JLabel
     * 
     * @ensure JLabel != null
     */
    private JLabel erstelleTitelLabel()
    {
        JLabel titel = new JLabel(TEXT_TITEL);
        titel.setFont(SCHRIFTART_NORMAL);
        titel.setForeground(TEXTFARBE_ROT);
        titel.setHorizontalAlignment(JLabel.CENTER);
        titel.setVerticalAlignment(JLabel.CENTER);
        return titel;
    }
    
    /**
     * erstellt die erste Spalte
     * @param dimension
     * @return JLabel
     * 
     * @require dimesion != null
     * 
     * @ensure JLabel != null
     */
    private JLabel erstelleErsteSpalte(Dimension dimension)
    {
        assert dimension != null : "Vorbedingung verletzt: null";

        JLabel spaltenLabel = erstelleSpaltenLabel(TEXT_BERECHNUNG);
        _berechneButton = new JButton(TEXT_BERECHNUNG_BUTTON);
        _berechneButton.setHorizontalAlignment(SwingConstants.CENTER);
        return spaltenLabel;
    }
    
    /**
     * Erstellt ein Label für die Spalten
     * @param str
     * @return JLabel
     * 
     * @require str != null
     * 
     * @ensure JLabek != null
     */
    private JLabel erstelleSpaltenLabel(String str)
    {
        assert str != null : "Vorbedingung verletzt: null";

        JLabel betriebsStromLabel = new JLabel(str);
        betriebsStromLabel.setHorizontalAlignment(JLabel.RIGHT);
        betriebsStromLabel.setVerticalAlignment(JLabel.CENTER);
        return betriebsStromLabel;
    }
    
    /**
     * Liefert ein Panel zurück, welches aus drei nebeinander gelegten Panels eine Spalte
     * darstellt. Es können 3 Unterschiedlcihe Komponente eingefügt werden. Die Komponenten
     * dürfen maximal eine Höhe von 25 und eine Breite von der (Breite/3 -8) sein.
     * Komponenten dürfen auch null sein.
     * @param links Linke komponente
     * @param mitte Mittlere Komponente
     * @param rechts Rechte Komponente
     * @return JPanel
     * 
     * @ensure JPanel != null
     */
    private JPanel fülleSpalte(Component links, Component mitte,
            Component rechts)
    {
        // erstelle Hauptpanel und stelle Laoyout ein
        JPanel panel = new JPanel();
        // erstelle die drei Panel für die drei Spalten
        JPanel panelLinks = erstelleSpaltabschnitt();
        JPanel panelMitte = erstelleSpaltabschnitt();
        JPanel panelRechts = erstelleSpaltabschnitt();

        // fülle die Spalten mit den Parametern
        if (links != null)
        {
            panelLinks.add(Box.createHorizontalGlue()); // sorgt für Rechtsbündigkeit
            panelLinks.add(links);
        }
        if (mitte != null)
        {
            panelMitte.add(mitte);
        }
        if (rechts != null)
        {
            panelRechts.add(rechts);
        }
        // fülle Hauptpanel
        panel.add(panelLinks);
        panel.add(panelMitte);
        panel.add(panelRechts);
        // gibt das Hauptpanel zurück
        return panel;
    }
    
    /**
     * Erstellt ein Panel und stellt Layout eingeschaften fest.
     * - Boxlayout
     * - stellt die Größe fest, die unveränderbar ist
     * @return
     */
    private JPanel erstelleSpaltabschnitt()
    {
        JPanel panelLinks = new JPanel();
        BoxLayout bl = new BoxLayout(panelLinks, BoxLayout.X_AXIS);
        panelLinks.setLayout(bl);
        panelLinks.setPreferredSize(new Dimension((int) width / 3 - 7, 25));
        return panelLinks;
    }
    
    /**
     * Füllt das Hauptpanel mit den Zeilen
     * 
     * @require titel != null
     * @require materialWahlLabel != null
     * @require verlegeartWahlLabel != null
     * 
     */
    private void fülleHauptPanel()
    {
        Dimension dimension = new Dimension(250, 22);
        JLabel titel = erstelleTitelLabel();
        JLabel berechne = erstelleErsteSpalte(dimension);
        // erstelle und fülle alle Spalten
        _hauptPanel.add(titel);
        _hauptPanel.add(fülleSpalte( berechne, 
                                     null,
                                     _berechneButton));
    }
    
    public JButton getBerechneButton()
    {
        return _berechneButton;
    }
    
    public JPanel getPanel()
    {
        return _hauptPanel;
    }
}
