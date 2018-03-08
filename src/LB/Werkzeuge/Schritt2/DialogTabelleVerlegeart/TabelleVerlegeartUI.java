package LB.Werkzeuge.Schritt2.DialogTabelleVerlegeart;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class TabelleVerlegeartUI
{
    // Konstanten
    private static final String TEXT_TITEL = "Tabelle Verlegeart";
    private static final String A1 = "[A1] wärmegedämmten Wänden im "
            + "Elektroistallationsrohr/kanal - Einadrig";
    private static final String A2 = "[A2] wärmegedämmten Wänden im "
            + "Elektroistallationsrohr/kanal oder direkt verlegt - Mehradrig";
    private static final String B1 = "[B1] Elektroinstallationsrohren /"
            + "geschlossenen Kanälen auf oder in Wänden - Einadrig";
    private static final String B2 = "[B2] Elektroinstallationsrohren/ "
            + "geschlossenen Kanälen auf oder in Wänden - Mehradrig";
    private static final String C = "  [C] Direkt in oder auf Wänden/Decken oder in "
            + "ungelochten Kabelrinnen - Mehr/Einzeladrig";
    private static final String E = "  [E]  Luft, an Tragseilen sowie auf "
            + "Kabelleitern - Mehradrige Kabel/Mantelleitungen";
    private static final String F = "  [F]  Luft, an Tragseilen sowie auf "
            + "Kabelleitern Einadrige Leitungen - mit Berührung";
    private static final String G = "  [G]  Luft, an Tragseilen sowie auf "
            + "Kabelleitern Einadrige Leitungen - ohne Berührung";
    // UI Komponenten
    private JDialog _dialog;
    private JButton _übernehmenButton;
    private JButton _abbrechenButton;
    private JRadioButton _a1;
    private JRadioButton _a2;
    private JRadioButton _b1;
    private JRadioButton _b2;
    private JRadioButton _c;
    private JRadioButton _e;
    private JRadioButton _f;
    private JRadioButton _g;
    
    /**
     * Konstruktor zum Initialisieren
     */
    public TabelleVerlegeartUI()
    {
        hauptPanelInit();
    }

    private void hauptPanelInit()
    {
        _dialog  = new JDialog();
        _dialog.setPreferredSize(new Dimension(720, 200));
        _dialog.setLayout(new BorderLayout());
        _dialog.setTitle(TEXT_TITEL);
        _dialog.setModal(true);
        _dialog.setResizable(false);
        
        JPanel buttonPanel = new JPanel(new FlowLayout());
        _übernehmenButton = new JButton("Übernehmen");
        _abbrechenButton = new JButton("Abbrechen");
        buttonPanel.add(_übernehmenButton);
        buttonPanel.add(_abbrechenButton);
        
        _a1 = new JRadioButton(A1);
        _a2 = new JRadioButton(A2);
        _b1 = new JRadioButton(B1);
        _b2 = new JRadioButton(B2);
        _c  = new JRadioButton(C);
        _e  = new JRadioButton(E);
        _f  = new JRadioButton(F);
        _g  = new JRadioButton(G);
        _b2.setSelected(true);   // selectiert weil am häufigsten vorkommt
        
        ButtonGroup gruppe = new ButtonGroup();
        gruppe.add(_a1);
        gruppe.add(_a2);
        gruppe.add(_b1);
        gruppe.add(_b2);
        gruppe.add(_c);
        gruppe.add(_e);
        gruppe.add(_f);
        gruppe.add(_g);
        
        JPanel radioPanel = new JPanel(new GridLayout(0, 1));
        JLabel label = new JLabel("Verlegung in ...");
        radioPanel.add(label);
        radioPanel.add(_a1);
        radioPanel.add(_a2);
        radioPanel.add(_b1);
        radioPanel.add(_b2);
        radioPanel.add(_c);
        radioPanel.add(_e);
        radioPanel.add(_f);
        radioPanel.add(_g);
        
        _dialog.add(radioPanel, BorderLayout.CENTER);
        _dialog.add(buttonPanel,BorderLayout.SOUTH);
    }
    
    
    public JDialog getDialog()
    {
        return _dialog;
    }
    
    public JRadioButton getA1Radiobutton()
    {
        return _a1;
    }
    
    public JRadioButton getA2Radiobutton()
    {
        return _a2;
    }
    
    public JRadioButton getB1Radiobutton()
    {
        return _b1;
    }
    
    public JRadioButton getB2Radiobutton()
    {
        return _b2;
    }
    
    public JRadioButton getCRadiobutton()
    {
        return _c;
    }
    
    public JRadioButton getERadiobutton()
    {
        return _e;
    }
    
    public JRadioButton getFRadiobutton()
    {
        return _f;
    }
    
    public JRadioButton getGRadiobutton()
    {
        return _g;
    }
    
    public JButton getÜbernehmenButton()
    {
        return _übernehmenButton;
    }
    
    public JButton getAbbrechenButton()
    {
        return _abbrechenButton;
    }
}
