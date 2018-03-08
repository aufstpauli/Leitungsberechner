package LB.Werkzeuge.Schritt3;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import LB.Enum.Spannungsfall;
import LB.Werkzeuge.UIKompomente.JNumberTextFieldGleitkomma;

public class Schritt3Werkzeug
{
    Schritt3UI _ui;
    public Schritt3Werkzeug()
    {
        _ui = new Schritt3UI();
    }
    
    public JPanel getPanel()
    {
        return _ui.getPanel();
    }
    
    public JNumberTextFieldGleitkomma getLängeTextField()
    {
        return _ui.getLängTextField();
    }
    
    public JComboBox<Spannungsfall> getSpannungsfallComboBox()
    {
        return _ui.getSpannungsfallComnboBox();
    }
}
