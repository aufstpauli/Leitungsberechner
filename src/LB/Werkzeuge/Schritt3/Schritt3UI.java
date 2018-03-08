package LB.Werkzeuge.Schritt3;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import LB.Enum.Spannungsfall;
import LB.Werkzeuge.UIKompomente.JNumberTextFieldGleitkomma;

public class Schritt3UI
{
    private final static int width = 780;
    private final static String TEXT_TITEL = "Schritt [3] - Spannungsfall ermitteln";
    private final static String TEXT_DELTA_U = "Prozentualer Spannungsfall";
    private final static String TEXT_LÄNGE = "Länge der Leitung";
    private static final Font SCHRIFTART_NORMAL = new Font("Serif", Font.BOLD,
            15);
    private static final Color TEXTFARBE_ROT = new Color(255, 50, 50);
    private JPanel _hauptPanel;
    private JComboBox<Spannungsfall> _deltaUComboBox;
    private JNumberTextFieldGleitkomma _längeTextField;
    
    public Schritt3UI()
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
        _hauptPanel.setPreferredSize(new Dimension(width, 95));
        GridLayout gl = new GridLayout(3, 1);
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

        JLabel spaltenLabel = erstelleSpaltenLabel(TEXT_DELTA_U);
        _deltaUComboBox = new JComboBox<Spannungsfall>();
        _deltaUComboBox.setModel(
                new DefaultComboBoxModel<Spannungsfall>(Spannungsfall.values()));
        _deltaUComboBox.setSelectedIndex(2);
        return spaltenLabel;
    }
    
    /**
     * erstellt die zweite Spalte
     * @param dimension
     * @return JLabel
     * 
     * @require dimesion != null
     * 
     * @ensure JLabel != null
     */
    private JLabel erstelleZweiteSpalte(Dimension dimension)
    {
        assert dimension != null : "Vorbedingung verletzt: null";

        JLabel spaltenLabel = erstelleSpaltenLabel(TEXT_LÄNGE);
        _längeTextField = new JNumberTextFieldGleitkomma();
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
        JLabel deltaU = erstelleErsteSpalte(dimension);
        JLabel länge = erstelleZweiteSpalte(dimension);
        // erstelle und fülle alle Spalten
        _hauptPanel.add(titel);
        _hauptPanel.add(fülleSpalte( deltaU, 
                                     _deltaUComboBox,
                                     null));
        _hauptPanel.add(fülleSpalte( länge, 
                                     _längeTextField, 
                                     null));
    }
    
    public JNumberTextFieldGleitkomma getLängTextField()
    {
        return _längeTextField;
    }
    
    public JComboBox<Spannungsfall> getSpannungsfallComnboBox()
    {
        return _deltaUComboBox;
    }
    
    public JPanel getPanel()
    {
        return _hauptPanel;
    }

}
