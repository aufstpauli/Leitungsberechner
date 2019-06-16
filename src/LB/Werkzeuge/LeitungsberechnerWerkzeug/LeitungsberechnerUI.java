package LB.Werkzeuge.LeitungsberechnerWerkzeug;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * Diese Klasse gestaltet das Loyout des Hauptfensters. Es wird ein Heuptpanel erstellt in
 * dem alle Subpanels nacheinander eingefügt werden. Die Subpanales werden als Parameter
 * übergeben
 * 
 * @author cris
 * @version 07.08.2016
 * @version 17.04.2018 - Fenstergröße optimiert
 */
public class LeitungsberechnerUI
{
    private static final String TITEL = "Leitungsberechner   V1.02";
    private final int WIDTH = 810;
    private final int HEIGHT = 750;
    
    private JFrame _hauptFenster;
    private JPanel _hauptPanel;
    private JPanel _schließerPanel;
    private JButton _schließen;
    private JPanel _schritt1;
    private JPanel _schritt2;
    private JPanel _schritt3;
    private JPanel _schritt4;
    private JPanel _ergebnisanzeige;
    

    
    /**
     * Konstruktor hier werden die Subpanel als Paramter übergeben und anschließend alle
     * Panel intialisiert und nacheinander in den Hauptpanael eingefügt und anschließend
     * in das fenster integriert
     * @param stromPanel stromPanel != null
     * @param _f1UI 
     * 
     * @require 
     */
    public LeitungsberechnerUI( JPanel schritt1, 
                                JPanel schritt2, 
                                JPanel schritt3,
                                JPanel schritt4,
                                JPanel ergebnisanzeige)
    {
        _schritt1 = schritt1;
        _schritt2 = schritt2;
        _schritt3 = schritt3;
        _schritt4 = schritt4;
        _ergebnisanzeige = ergebnisanzeige;
        
        hauptfensterFrameInit();        
        hauptPanelInit();
        schließPanelInit();
        fülleHauptfenster();       
    }

    /**
     * Initialisiert das Hauptpanel und stellt das Layout und den Anordnung ein. 
     * Mit Hilfe des 
     */
    private void hauptPanelInit()
    {
        _hauptPanel = new JPanel(new FlowLayout());
        JPanel hilfspanel = new JPanel();
        hilfspanel.setLayout(new BoxLayout(hilfspanel,BoxLayout.Y_AXIS));
        _hauptPanel.setAlignmentX(Component.CENTER_ALIGNMENT);        
        fülleHilfsPanel(hilfspanel);        
        _hauptPanel.add(hilfspanel);
    }

    /**
     * Füllt das Hilspanel, welches in das Hauptpanel gesteckt wird. Damit wird es
     * in das Hauptpanel erscheinen und die Größe wird nie verändert
     * @param hilfspanel
     */
    private void fülleHilfsPanel(JPanel hilfspanel)
    {
        hilfspanel.add(_schritt1);
        hilfspanel.add(_schritt2);
        hilfspanel.add(_schritt3);
        hilfspanel.add(_schritt4);
        hilfspanel.add(_ergebnisanzeige);
        
    }

    /**
     * füllt das Hauptfenster mit dem Hauptpanel und dem Panel zum Schließen
     */
    private void fülleHauptfenster()
    {
        JScrollPane scrollpane = new JScrollPane(_hauptPanel);
        _hauptFenster.add(scrollpane);
        _hauptFenster.add(_schließerPanel,BorderLayout.SOUTH);
    }

    /**
     * Initialisiert das Panel zum Schließen des Programmes
     */
    private void schließPanelInit()
    {
        _schließen = new JButton("schließen");
        _schließerPanel = new JPanel();
        _schließerPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        _schließerPanel.add(_schließen);
    }

    /**
     * Initialsisiert das Hauptfenster mit dem Titel und dem Layout und dem schließ
     * befehl
     */
    private void hauptfensterFrameInit()
    {
        _hauptFenster = new JFrame(TITEL);
        _hauptFenster.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        _hauptFenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        _hauptFenster.getContentPane().setLayout(new BorderLayout());
        _hauptFenster.setLocationRelativeTo(null);
    }
    
    /**
     * Zeigt das Fenster an.
     */
    public void zeigeFenster()
    {
   //     _hauptFenster.pack();
        int windowWidth = _hauptFenster.getWidth();
        int windowHeight = _hauptFenster.getHeight();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); 
        _hauptFenster.setBounds(    (screenSize.width-windowWidth)/2, 
                                    (screenSize.height-windowHeight)/2, 
                                    windowWidth, windowHeight);
        _hauptFenster.setVisible(true);
    }

    /**
     * Schließt das Fenster.
     */
    public void schliesseFenster()
    {
        _hauptFenster.dispose();
    }
    
    public JButton getSchließerButton()
    {
        return _schließen;
    }
}
