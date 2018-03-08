package LB.Werkzeuge.Schritt1.DialogBetriebsstromRechner;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import LB.Werkzeuge.UIKompomente.JNumberTextFieldNumber;
import LB.Werkzeuge.UIKompomente.JNumberTextFieldAnzeige;
import LB.Werkzeuge.UIKompomente.JNumberTextFieldCosPhi;
import LB.Werkzeuge.UIKompomente.JNumberTextFieldGleitkomma;

/**
 * Diese Klasse stellt die Benutzerschnittstelle für die Leistung zur Verfügung Es werden
 * alle Komponenten und erstellt und jeweils in Container gepackt. Die Container werden
 * dann je nach Layout angeordnet. 
 * 
 * @author cris
 * @version 19.07.2016
 *
 */
public class StromErmittlungUI
{
    // Konstanten
    private static final String TEXT_TITEL = "Betriebsstrom (Ib)";
    private static final String TEXT_SPANNUNG = "Spannung (V)";
    private static final String TEXT_Leistung = "Leistung (W)";
    private static final String TEXT_COSPHI = "cos Phi";
    private static final String TEXT_BUTTON_BERECHNE = "Berechnen";
    private String _cosPhi;
    
    //UI  Kompenenten
    private JDialog _dialog;
    private JNumberTextFieldAnzeige _spannungTextField;
    private JNumberTextFieldNumber _leistungTextField;
    private JNumberTextFieldCosPhi _cosPhiTextField;
    private JNumberTextFieldAnzeige _ergebnisTextField;
    private JNumberTextFieldGleitkomma _eingabeTextField;
    private JButton _eingabeButton;
    private JButton _berchneStromButton;
    private JButton _übernehmen;
    private JButton _abbrechen;

    /**
     * Konstruktor zum initialisieren
     */
    public StromErmittlungUI(String cosPhi)
    {
        _cosPhi = cosPhi;
        dialogInit();
    }
    
    /**
     * Hier werden das HauptPanel erstellt und initialisiert 
     */
    private void dialogInit()
    {   
        erstelleDialog();
        JPanel buttonPanel = new JPanel(new FlowLayout());
        erzeugeButtons();
        füllePanel(buttonPanel);
        fülleDialog(buttonPanel);
    }

    /**
     * Füllt das BDialog mit dem Panel
     * @param buttonPanel
     */
    private void fülleDialog(JPanel buttonPanel)
    {
        _dialog.add(erstelleBerechnungsPanel(),BorderLayout.CENTER);
        _dialog.add(buttonPanel,BorderLayout.SOUTH);
    }

    /**
     * Füllt das Panel mit den Komponenten
     * @param panel
     */
    private void füllePanel(JPanel panel)
    {
        panel.add(_übernehmen);
        panel.add(_abbrechen);
    }

    /**
     * erstellt die Abbrech und Übernehmbutton
     */
    private void erzeugeButtons()
    {
        _übernehmen = new JButton("Übernehmen");
        _übernehmen.setEnabled(false);
        _abbrechen = new JButton("Abbrechen");
    }

    /**
     * Erstellt und initislisiert das Dialog
     */
    private void erstelleDialog()
    {
        _dialog  = new JDialog();
        _dialog.setLayout(new BorderLayout());
        _dialog.setTitle(TEXT_TITEL);
        _dialog.setModal(true);
        _dialog.setResizable(false);
    }
    
    /**
     * Hier wird das Panel zum Berechnen des Stromes erstellt und zurück gegeben
     * @return JPanel berechnungsPanel
     * 
     * @ensure JPanel != null
     */
    private JPanel erstelleBerechnungsPanel()
    {
        JPanel berechnungsPanel;
        berechnungsPanel = new JPanel();
        berechnungsPanel.setLayout(new GridLayout(4, 1));
        berechnungsPanel.add(erstelleLeistungPanel());
        berechnungsPanel.add(erstelleSpannungPanel());
        berechnungsPanel.add(erstelleCosPhiPanel());
        berechnungsPanel.add(erteslleErgebnisPanel());
        return berechnungsPanel;
    }

    /**
     * Hier wird das Panel erstellt welches das Label und TextField für die Berechnung
     * zur Verfügung stellt
     * @return JButton rechnenPanel
     * 
     * @ensure JPanel != null
     */
    private JPanel erteslleErgebnisPanel()
    {
        JPanel rechnenPanel;
        rechnenPanel = new JPanel();
        rechnenPanel.setLayout(new GridLayout(1, 2));
        _berchneStromButton = new JButton(TEXT_BUTTON_BERECHNE);
        _ergebnisTextField = new JNumberTextFieldAnzeige();
        _ergebnisTextField.setBorder(new EmptyBorder(0, 5, 0, 0));  // Für den Abstand
        _ergebnisTextField.setEditable(false);
        rechnenPanel.add(_berchneStromButton);
        rechnenPanel.add(_ergebnisTextField);
        return rechnenPanel;
    }

    /**
     * Hier werden wird das Panel für den Strom erstellt und zurück gegeben
     * @return JPanel stromPanel
     * 
     * @JPanel JPanel != null
     */
    private JPanel erstelleLeistungPanel()
    {
        JPanel leistungPanel;
        JLabel leistungLabel = LabelSetup(TEXT_Leistung);
        leistungPanel = erstellePanalGridLayout();
        _leistungTextField = new JNumberTextFieldNumber();
        leistungPanel.add(leistungLabel);
        leistungPanel.add(_leistungTextField);
        return leistungPanel;
    }

    /**
     * Hier wird das Panel für die Spannung erstellt und zurück gegeben
     * @return JPanel spannungPanel
     * 
     * @ensure JPanel != null
     */
    private JPanel erstelleSpannungPanel()
    {
        JLabel spannungLabel;
        JPanel spannungPanel;
        spannungPanel = erstellePanalGridLayout();
        spannungLabel = new JLabel(TEXT_SPANNUNG);
        _spannungTextField = new JNumberTextFieldAnzeige();
        _spannungTextField.setEnabled(false);
        spannungPanel.add(spannungLabel);
        spannungPanel.add(_spannungTextField);
        return spannungPanel;
    }

    /**
     * Hier wird das Panel für CosPhi erstellt und zurück gegeben
     * @return JPanel CosPhi
     * 
     * @ensure JPanel != null
     */
    private JPanel erstelleCosPhiPanel()
    {
        JLabel cosPhiLabel;
        JPanel _cosPhiPanel;
        _cosPhiPanel = erstellePanalGridLayout();
        _cosPhiTextField = new JNumberTextFieldCosPhi();
        _cosPhiTextField.setEnabled(false);
        _cosPhiTextField.setText(_cosPhi);
        cosPhiLabel = new JLabel(TEXT_COSPHI);
        _cosPhiPanel.add(cosPhiLabel);
        _cosPhiPanel.add(_cosPhiTextField);
        return _cosPhiPanel;
    }
    
    /**
     * Bestimmt das Layout des Labels
     * @param str
     * @return JLabel
     * 
     * @require str != null
     * @ensure JPanel != null
     */
    private JLabel LabelSetup(String str)
    {
        assert str != null : "Vorbedingung verletzt: null";
        JLabel label = new JLabel();
        label.setText(str);
        return label;
    }
    
    /**
     * erstellt ein Panel mit einem GridLayout
     * @return JPanel
     * 
     * @ensure JPanel != null
     */
    private JPanel erstellePanalGridLayout()
    {
        JPanel leistungPanel = new JPanel();
        leistungPanel.setLayout(new GridLayout(1, 2));
        return leistungPanel;
    }

    public void setCosPhi(String cosPhi)
    {
        _cosPhi = cosPhi;
    }
    
    /**
     * Gibt das Hauptpanel zurück
     * @return JPanel
     * 
     * @ensure JPanel != null
     */
    public JDialog getDialog()
    {
        return _dialog;
    }

    /**
     * Gibt das Textfeld für die Leistung zurück
     * @return JTextField
     * 
     * @ensure JPJTextFieldanel != null
     */
    public JTextField getLeistungWert()
    {
        return _leistungTextField;
    }

    /**
     * Gibt das Textfeld für die Spannung zurück
     * 
     * @return JTextField
     * 
     * @require JTextField != null
     */
    public JNumberTextFieldAnzeige getSpannungTextField()
    {
        return _spannungTextField;
    }

    /**
     * Gibt das Textfeld für das Ergebnis zurück
     * @return JTextField
     * 
     * @require JTextField != null
     */
    public JNumberTextFieldAnzeige getErgebnisTextField()
    {
        return _ergebnisTextField;
    }
    
    /**
     * Gibt ein umgeschriebenes Textfeld für die Eingabe von Zahlen zurück
     * 
     * @return JNumberTextFieldGleitkomma
     * 
     * @require JNumberTextFieldGleitkomma != null
     */
    public JNumberTextFieldGleitkomma getEingabeTextField()
    {
        return _eingabeTextField;
    }
    
    /**
     * Gibt das Textfeld für den CosPhi zurück
     * @return JTextField
     * 
     * @ensure JTextField != null
     */
    public JNumberTextFieldCosPhi getCosPhiTextField()
    {
        return _cosPhiTextField;
    }
    
    /**
     * Gibt ein Button für die Eingabe zurück
     * @return JButton
     * 
     * @require JButton != null
     */
    public JButton getEingabeButton()
    {
        return _eingabeButton;
    }
    
    /**
     * Gibt den Button für die Berechnung zurück
     * @return JButton
     * 
     * @ensure JButton != null
     */
    public JButton getBerechneButton()
    {
        return _berchneStromButton;
    }
    
    /**
     * Gibt den Button für das Übernehmen zurück
     * @return JButton
     * 
     * @ensure JButton != null
     */
    public JButton getÜbernehmenButton()
    {
        return _übernehmen;
    }
    
    /**
     * Gibt den Button für das Abbrechen zurück
     * 
     * @return JButton
     * 
     * @ensure JButton != null
     */
    public JButton getAbbrechenButton()
    {
        return _abbrechen;
    }
    
}
