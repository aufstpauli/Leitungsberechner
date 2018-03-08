package LB.Werkzeuge.Schritt2;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import LB.Enum.Häufung;
import LB.Enum.Isolierung;
import LB.Enum.Material;
import LB.Enum.Temperatur;
import LB.Enum.Verlegeart;
import LB.Werkzeuge.Schritt2.Beobachter.BeobachterSchritt2;
import LB.Werkzeuge.Schritt2.DialogTabelleVerlegeart.TabelleVerlegeartWerkzeug;

public class Schritt2Werkzeug implements BeobachterSchritt2
{
    private Schritt2UI _ui;
    private TabelleVerlegeartWerkzeug _verlegeartErmittler;
    
    /**
     * Konstruktor zum Initialisieren
     */
    public Schritt2Werkzeug()
    {
        _ui = new Schritt2UI();
        _verlegeartErmittler = new TabelleVerlegeartWerkzeug();
        registriereListener();
        rigistriereActionListener();
        
    }

    /**
     * Registriert die ActionListener der Buttons
     */
    private void rigistriereActionListener()
    {
        _ui.getTabelleVerlegeartButton().addActionListener(new ActionListener()
        {
            
            @Override
            public void actionPerformed(ActionEvent e)
            {
                _verlegeartErmittler.getDialog().pack();
                int windowWidth = _verlegeartErmittler.getDialog().getWidth();
                int windowHeight = _verlegeartErmittler.getDialog().getHeight();
                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); 
                _verlegeartErmittler.getDialog().setBounds(    
                        (screenSize.width-windowWidth)/2, 
                        (screenSize.height-windowHeight)/2, 
                         windowWidth, windowHeight);
                _verlegeartErmittler.getDialog().setVisible(true);
            }
        });
    }

    /**
     * Registriert den Beobachter bei den zu Beobachten Objekt
     */
    private void registriereListener()
    {
        _verlegeartErmittler.registriereBeobachter(this);
    }
    
    public JPanel getPanel()
    {
        return _ui.getPanel();
    }
    
    public JComboBox<Material> getMaterialComboBox()
    {
        return _ui.getMaterialComboBox();
    }
    
    public JComboBox<Isolierung> getIsolierungComboBox()
    {
        return _ui.getIsolierungComboBox();
    }
    
    public JComboBox<Verlegeart> getVerlegeartCpmboBox()
    {
        return _ui.getVerlegeartComboBox();
    }
    
    public JComboBox<Häufung> getHäufungComboBox()
    {
        return _ui.getHäufungComboBox();
    }
    
    public JComboBox<Temperatur> getTemperaturComboBox()
    {
        return _ui.getTemperaturComboBox();
    }

    @Override
    public void reagiereAufÄnderung()
    {
        _ui.getVerlegeartComboBox().setSelectedIndex(
                _verlegeartErmittler.getSelectetIndex());
    }
}
