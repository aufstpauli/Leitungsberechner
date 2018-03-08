package LB.Werkzeuge.Schritt1;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import LB.Enum.Sicherung;
import LB.Enum.Spannungsart;
import LB.Werkzeuge.UIKompomente.JNumberTextFieldCosPhi;
import LB.Werkzeuge.UIKompomente.JNumberTextFieldGleitkomma;
import LB.Werkzeuge.UIKompomente.JNumberTextFieldNumber;

public class Schritt1UI
{
    // Konstanten für die Texte
    private final static int width = 780;
    private final static String TEXT_TITEL = "Schritt [1] - Betriebsart / Betriebsstrom";
    private final static String TEXT_SPANNUNGWAHL = "Betriebsspannung";
    private final static String TEXT_COS_PHI = "Cos Phi der Verbraucher [0< n <1]";
    private final static String TEXT_BETRIEBSSTROM = "Betriebsstrom (Ib)";
    private final static String _TEXT_STROMBERECHNEN = "Berechnungshilfe";
    private final static String _TEXT_SICHERUNG = "Sicherungsart";
    private static final Font SCHRIFTART_NORMAL = new Font("Serif", Font.BOLD,
            15);
    private static final Color TEXTFARBE_ROT = new Color(255, 50, 50);
    // Komponenten
    private JPanel _hauptPanel;
    private JComboBox<Spannungsart> _spannungsartComboBox;
    private JNumberTextFieldGleitkomma _betriebsStromTextField;
    private JNumberTextFieldCosPhi  _cosPhiTextField;
    private JNumberTextFieldNumber _spannungTextField;
    private JButton _stromBerechnenButton;
    private JComboBox<Sicherung> _sicherungComboBox;

    /**
     * Konstruktor zum initialisieren
     */
    public Schritt1UI()
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
        _hauptPanel.setPreferredSize(new Dimension(width, 155));
        GridLayout gl = new GridLayout(5, 1);  // anzahl der Spalten
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
     * Erstellt und initialisiert die erste Spalte
     * @param dimension
     * @return JLabel
     * 
     * @require dimension != null
     * 
     * @ensure JLabel != null
     */
    private JLabel erstelleErsteSpalte(Dimension dimension)
    {
        assert dimension != null : "Vorbedingung verletzt: null";
        
        JLabel spaltenLabel = erstelleSpaltenLabel(TEXT_SPANNUNGWAHL);
        _spannungTextField = new JNumberTextFieldNumber();
        _spannungsartComboBox = new JComboBox<Spannungsart>();
        _spannungsartComboBox.setModel(
                new DefaultComboBoxModel<Spannungsart>(Spannungsart.values()));
        _spannungsartComboBox.setSelectedIndex(1);
        return spaltenLabel;
    }
    
    /**
     * Erstellt und initialisiert die Zweite Spalte
     * @param dimension
     * @return JLabek
     * 
     * @require dimension != null
     * 
     * @ensure JLabel != null
     */
    private JLabel erstelleZweiteSpalte(Dimension dimension)
    {
        assert dimension != null : "Vorbedingung verletzt: null";
        
        JLabel spaltenLabel = erstelleSpaltenLabel(TEXT_COS_PHI);
        _cosPhiTextField = new JNumberTextFieldCosPhi();
        _cosPhiTextField.setPreferredSize(dimension);
        _stromBerechnenButton = new JButton(_TEXT_STROMBERECHNEN);
        return spaltenLabel;
    }
    
    private JLabel erstelleDritteSpalte(Dimension dimension)
    {
        assert dimension != null : "Vorbedingung verletzt: null";
        
        JLabel spaltenLabel = erstelleSpaltenLabel(TEXT_BETRIEBSSTROM);
        _betriebsStromTextField = new JNumberTextFieldGleitkomma();
        _betriebsStromTextField.setPreferredSize(dimension);
        _stromBerechnenButton = new JButton(_TEXT_STROMBERECHNEN);
        return spaltenLabel;
    }
    
    private JLabel erstelleVierteSpalte(Dimension dimension)
    {
        assert dimension != null : "Vorbedingung verletzt: null";
        
        JLabel spaltenLabel = erstelleSpaltenLabel(_TEXT_SICHERUNG);
        _sicherungComboBox = new JComboBox<Sicherung>();
        _sicherungComboBox.setModel((ComboBoxModel<Sicherung>) 
                new DefaultComboBoxModel<Sicherung>(Sicherung.values()));
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
     * Füllt das Hauptpanel mit den Zeilen
     * @param titel
     * @param spannungWahlLabel
     * @param betriebsStromLabel
     * 
     * @require titel != null
     * @require spannungWahlLabel != null
     * @require betriebsStromLabel != null
     */
    private void fülleHauptPanel()
    {
        Dimension dimension = new Dimension(250, 22);
        JLabel titel = erstelleTitelLabel();
        JLabel spannungWahlLabel = erstelleErsteSpalte(dimension);
        JLabel cosPhiLabel = erstelleZweiteSpalte(dimension);
        JLabel betriebsStromLabel = erstelleDritteSpalte(dimension); 
        JLabel sicherungLabel = erstelleVierteSpalte(dimension);
        _hauptPanel.add(titel);
        _hauptPanel.add(erstelleSpalte( spannungWahlLabel,
                                        _spannungTextField, 
                                        _spannungsartComboBox));
        _hauptPanel.add(erstelleSpalte( cosPhiLabel, 
                                        _cosPhiTextField, 
                                        null));
        _hauptPanel.add(erstelleSpalte( betriebsStromLabel,
                                        _betriebsStromTextField,
                                        _stromBerechnenButton));
        _hauptPanel.add(erstelleSpalte( sicherungLabel, 
                                        _sicherungComboBox, 
                                        null));
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
    private JPanel erstelleSpalte(Component links, Component mitte, Component rechts)
    {
        // erstelle Hauptpanel und stelle Laoyout ein
        JPanel panel = new JPanel();
        // erstelle die drei Panel für die drei Spalten
        JPanel panelLinks = erstelleSpaltabschnitt();
        JPanel panelMitte = erstelleSpaltabschnitt();
        JPanel panelRechts= erstelleSpaltabschnitt();
        
        // fülle die Spalten mit den Parametern
        if(links != null)
        {
            panelLinks.add(Box.createHorizontalGlue()); // sorgt für Rechtsbündigkeit
            panelLinks.add(links);
        }
        if(mitte != null)
        {
            panelMitte.add(mitte);
        }
        if(rechts != null)
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
        panelLinks.setPreferredSize(new Dimension((int)width/3 - 7, 25));
        return panelLinks;
    }
    
    
    public JPanel getPanel()
    {
        return _hauptPanel;
    }
    
    public JButton getIbBerechnenButton()
    {
        return _stromBerechnenButton;
    }

    public JComboBox<Spannungsart> getSpannungsartComboBox()
    {
        return _spannungsartComboBox;
    }
    
    public JNumberTextFieldGleitkomma getBetriebsstromTextField()
    {
        return _betriebsStromTextField;
    }
    
    public JNumberTextFieldCosPhi getCosPhiTextField()
    {
        return _cosPhiTextField;
    }
    
    public JComboBox<Sicherung> getSicherungComboBox()
    {
        return _sicherungComboBox;
    }
    
    public JNumberTextFieldNumber getSpannungTextField()
    {
        return _spannungTextField;
    }
}
