package LB.Werkzeuge.Ergebnisanzeige;

import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * 
 * @author cris
 *
 */
public class ErgebnisanzeigeWerkzeug
{
    ErgebnisanzeigeUI _ui;

    public ErgebnisanzeigeWerkzeug()
    {
        _ui = new ErgebnisanzeigeUI();
    }

    public JPanel getPanel()
    {
        return _ui.getPanel();
    }
    
    public JTextArea getErgebnisTextArea()
    {
        return _ui.getErgebnisTextArea();
    }
}
