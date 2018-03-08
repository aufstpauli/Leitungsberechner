package LB.Werkzeuge.Schritt4;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Schritt4Werkzeug
{

    Schritt4UI _ui;

    public Schritt4Werkzeug()
    {
        _ui = new Schritt4UI();
    }

    public JPanel getPanel()
    {
        return _ui.getPanel();
    }
    
    public JButton getBerechneButton()
    {
        return _ui.getBerechneButton();
    }
}
