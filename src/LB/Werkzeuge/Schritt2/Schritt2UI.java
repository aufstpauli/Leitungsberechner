package LB.Werkzeuge.Schritt2;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import LB.Enum.Häufung;
import LB.Enum.Isolierung;
import LB.Enum.Material;
import LB.Enum.Temperatur;
import LB.Enum.Verlegeart;


public class Schritt2UI
{
    private final static int width = 780;
    private final static String TEXT_TITEL = "Schritt [2] - Auswahl der"
            + " Leitungseigenschaften";
    private final static String TEXT_LEITUNGSMATERIAL = "Material der Leitung";
    private final static String TEXT_ISOLIERUNG = "Isolierung der Leitung";
    private final static String TEXT_VERLEGEART = "Verlegeart der Leitung";
    private final static String TEXT_VERLEGEART_BUTTON = "aus Tabelle wählen";
    private final static String TEXT_HÄUFUNG = "Häufung von Leitungen";
    private final static String TEXT_TEMPERATUR = "Umgebungstemperatur";
    private static final Font SCHRIFTART_NORMAL = new Font("Serif", Font.BOLD,
            15);
    private static final Color TEXTFARBE_ROT = new Color(255, 50, 50);
    private JPanel _hauptPanel;
    private JComboBox<Material> _materialComboBox;
    private JComboBox<Verlegeart> _verlegeartComboBox;
    private JComboBox<Isolierung> _isolationComboBox;
    private JComboBox<Häufung> _häufungComboBox;
    private JComboBox<Temperatur> _temperaturComboBox;
    private JButton _TabelleVerlegeartButton;

    public Schritt2UI()
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
        _hauptPanel.setPreferredSize(new Dimension(width, 195));
        GridLayout gl = new GridLayout(6, 1);
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

        JLabel spaltenLabel = erstelleSpaltenLabel(TEXT_LEITUNGSMATERIAL);
        _materialComboBox = new JComboBox<Material>();
        // fülle die ComboBox mit dem Enum Material
        _materialComboBox.setModel(new DefaultComboBoxModel<Material>(Material.values()));
        _materialComboBox.setEnabled(false);
        return spaltenLabel;
    }
    
    private JLabel erstelleZweiteSpalte(Dimension dimension)
    {
        JLabel spaltenLabel = erstelleSpaltenLabel(TEXT_ISOLIERUNG);
        _isolationComboBox = new JComboBox<Isolierung>();
        // fülle die ComboBox mit dem Enum Isolierung
        _isolationComboBox.setModel(
                new DefaultComboBoxModel<Isolierung>(Isolierung.values()));
        _isolationComboBox.setSelectedIndex(1);
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
    private JLabel erstelleDritteSpalte(Dimension dimension)
    {
        assert dimension != null : "Vorbedingung verletzt: null";

        JLabel spaltenLabel = erstelleSpaltenLabel(TEXT_VERLEGEART);
        _verlegeartComboBox = new JComboBox<Verlegeart>();
        // fülle die ComboBox mit dem Enum Verlegeart
        _verlegeartComboBox.setModel(
                new DefaultComboBoxModel<Verlegeart>(Verlegeart.values()));
        _TabelleVerlegeartButton = new JButton(TEXT_VERLEGEART_BUTTON);
        _verlegeartComboBox.setSelectedIndex(3);
        return spaltenLabel;
    }
    
    private JLabel erstelleVierteSpalte(Dimension dimension)
    {
        assert dimension != null : "Vorbedingung verletzt: null";

        JLabel spaltenLabel = erstelleSpaltenLabel(TEXT_HÄUFUNG);
        _häufungComboBox = new JComboBox<Häufung>();
        // fülle die ComboBox mit dem Enum Häufung
        _häufungComboBox.setModel(new DefaultComboBoxModel<Häufung>(Häufung.values()));
        _TabelleVerlegeartButton = new JButton(TEXT_VERLEGEART_BUTTON);
        _häufungComboBox.setSelectedIndex(0);
        return spaltenLabel;
    }
    
    private JLabel erstelleFünfteSpalte(Dimension dimension)
    {
        assert dimension != null : "Vorbedingung verletzt: null";

        JLabel spaltenLabel = erstelleSpaltenLabel(TEXT_TEMPERATUR);
        _temperaturComboBox = new JComboBox<Temperatur>();
        // fülle die ComboBox mit dem Enum Temperatur
        _temperaturComboBox.setModel(
                new DefaultComboBoxModel<Temperatur>(Temperatur.values()));
        _temperaturComboBox.setSelectedIndex(4);
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
        JLabel materialWahlLabel = erstelleErsteSpalte(dimension);
        JLabel isolationsLabel = erstelleZweiteSpalte(dimension);
        JLabel verlegeart = erstelleDritteSpalte(dimension);
        JLabel häufung = erstelleVierteSpalte(dimension);
        JLabel temperatur = erstelleFünfteSpalte(dimension);
        // erstelle und fülle alle Spalten
        _hauptPanel.add(titel);
        _hauptPanel.add(fülleSpalte( materialWahlLabel, 
                                        _materialComboBox,
                                        null));
        _hauptPanel.add(fülleSpalte( isolationsLabel, 
                                        _isolationComboBox, 
                                        null));
        _hauptPanel.add(fülleSpalte( verlegeart,
                                        _verlegeartComboBox, 
                                        _TabelleVerlegeartButton));
        _hauptPanel.add(fülleSpalte( häufung, 
                                        _häufungComboBox,
                                        null));
        _hauptPanel.add(fülleSpalte( temperatur, 
                                        _temperaturComboBox, 
                                        null));
    }

    /**
     * Gibt das Panel für die Auswahl der Leitungseigenschafte zurück
     * @return JPanel
     * 
     * @ensrure JPanel != null
     */
    public JPanel getPanel()
    {
        return _hauptPanel;
    }
    
    public JButton getTabelleVerlegeartButton()
    {
        return _TabelleVerlegeartButton;
    }
    
    public JComboBox<Material> getMaterialComboBox()
    {
         return _materialComboBox;
    }
    
    public JComboBox<Isolierung> getIsolierungComboBox()
    {
        return _isolationComboBox;
    }
    
    public JComboBox<Verlegeart> getVerlegeartComboBox()
    {
        return _verlegeartComboBox;
    }
    
    public JComboBox<Häufung> getHäufungComboBox()
    {
        return _häufungComboBox;
    }
    
    public JComboBox<Temperatur> getTemperaturComboBox()
    {
        return _temperaturComboBox;
    }
}
