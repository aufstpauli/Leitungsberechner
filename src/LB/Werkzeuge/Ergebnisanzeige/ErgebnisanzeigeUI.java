package LB.Werkzeuge.Ergebnisanzeige;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;

public class ErgebnisanzeigeUI
{
    private final static int width = 780;
    private JPanel _hauptPanel;
    private JTextArea _ergebnisanzeige;
    
    
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
     * Erstellt das Hauptpanel undinitialisiert es
     */
    private void erstelleHauptpanel()
    {
        _hauptPanel = new JPanel();
        _hauptPanel.setPreferredSize(new Dimension(width, 180));
        GridLayout gl = new GridLayout(1, 1);
        _hauptPanel.setLayout(gl);
        _hauptPanel.setBorder(new EtchedBorder());
    }
    
    public JPanel getPanel()
    {
        return _hauptPanel;
    }
    
    public JTextArea getErgebnisTextArea()
    {
        return _ergebnisanzeige;
    }
}
