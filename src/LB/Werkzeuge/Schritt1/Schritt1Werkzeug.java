package LB.Werkzeuge.Schritt1;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import LB.Enum.Sicherung;
import LB.Enum.Spannungsart;
import LB.Fachwerte.Spannung;
import LB.Werkzeuge.Schritt1.DialogBetriebsstromRechner.StromErmittlungWerkzeug;
import LB.Werkzeuge.Schritt1.beobachter.BeobachterSchritt1;
import LB.Werkzeuge.UIKompomente.JNumberTextFieldCosPhi;
import LB.Werkzeuge.UIKompomente.JNumberTextFieldGleitkomma;
import LB.Werkzeuge.UIKompomente.JNumberTextFieldNumber;

/**
 * Diese Klasse stellt die Schnittstelle für die Interaktion dar. Es wird das Layout für
 * den ersten Schritt erstellt
 * 1. Schritt:
 * - Spannungsart
 * - Cos Phi
 * - Betriebsstrom
 * 
 * Diese drei Komponenten können abgefragt werden mit den jeweiligen Befehlen mit get:
 * - getSpannungsartComboBox()
 * - getCosPhiComboBox()
 * - getBetriebsstromTextField
 * @author cris
 *
 */
public class Schritt1Werkzeug implements BeobachterSchritt1
{
    private Schritt1UI _ui;
    private StromErmittlungWerkzeug _ibErmittler;
    
    public Schritt1Werkzeug()
    {
        _ui = new Schritt1UI();
        _ibErmittler = new StromErmittlungWerkzeug();    
        registriereBeobachter();
        registriereActionListener();
    }


    /**
     * registriere ibBerechenbutton
     */
    private void registriereActionListener()
    {
        _ui.getIbBerechnenButton().addActionListener(new ActionListener()
        {
            
            @Override
            public void actionPerformed(ActionEvent e)
            {
                
                zeigeDialog();
            }
        });
        
        _ui.getSpannungsartComboBox().addActionListener(new ActionListener()
        {
            
            @Override
            public void actionPerformed(ActionEvent e)
            {
                reagiereAufSpannungsComboBox();
            }
        });
    }
    
    /**
     * Prüft den Status der Combobox und stellt darauf hin die Einstellungen
     * und Parameter für die anderen Kompomente ein
     */
    private void reagiereAufSpannungsComboBox()
    {
        // liest die ComboBox aus
        Spannungsart spannungsart = (Spannungsart) _ui.getSpannungsartComboBox()
                .getSelectedItem();
        switch(spannungsart)
        {
            case Gleichspannung: // erste Stelle (Gleichspannung)
                _ui.getCosPhiTextField().setEditable(false);
                _ibErmittler.setVerkettungsfaktor(false);
                _ui.getCosPhiTextField().setText("1,00");
                break;
            case Wechselspannung: // zweite Stelle (Wechselspannung)
                _ui.getCosPhiTextField().setEditable(true);
                _ibErmittler.setVerkettungsfaktor(false);
                break;
            case Dreiphasenwechselspannung: // dritte Stelle (Dreileitespannung)
                _ui.getCosPhiTextField().setEditable(true);
                _ibErmittler.setVerkettungsfaktor(true);
                break;
        }
    }
    
    /**
     * Übergibt die benötigten Informationen und erstellt das Dialod und zeigt es an
     */
    private void zeigeDialog()
    {
        try 
        {
            int milliVolt = Integer.parseInt(_ui.getSpannungTextField().getText())*1000;
            Spannung u = Spannung.get(milliVolt);
            _ibErmittler.setUB(u);
            _ibErmittler.getSpannungTextField().setText(_ui.getSpannungTextField().getText());
            _ibErmittler.getCosPhi().setText(_ui.getCosPhiTextField().getText());
            _ibErmittler.getDialog().pack();
            int windowWidth = _ibErmittler.getDialog().getWidth();
            int windowHeight = _ibErmittler.getDialog().getHeight();
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); 
            _ibErmittler.getDialog().setBounds(    
                    (screenSize.width-windowWidth)/2, 
                    (screenSize.height-windowHeight)/2, 
                    windowWidth, windowHeight);
            _ibErmittler.getDialog().setVisible(true);         
        }
        catch(NumberFormatException e1)
        {
            JOptionPane.showMessageDialog(null,
                    "Um eine Berechnung durchführen zu können, wird die "
                    + "Betriebsspannung benötigt");
        }
    }
    
    /**
     * registriert sich als Beobachter, damit der betriebsstrom zurückgegeben werden kann
     */
    private void registriereBeobachter()
    {
        _ibErmittler.registriereBeobachter(this);
    }
    
    /**
     * gibt das Panel zurück
     * @return JPanel
     * 
     * @ensure JPanel != null
     */
    public JPanel getPanel()
    {
        return _ui.getPanel();
    }
    
    public JComboBox<Spannungsart> getSpannungsart()
    {
        return _ui.getSpannungsartComboBox();
    }
    
    public JNumberTextFieldCosPhi getCosPhiTextField()
    {
        return _ui.getCosPhiTextField();
    }
    
    public JNumberTextFieldGleitkomma getBetriebsstromTextField()
    {
        return _ui.getBetriebsstromTextField();
    }
    
    public JComboBox<Sicherung> getSicherungComboBox()
    {
        return _ui.getSicherungComboBox();
    }
    
    public JNumberTextFieldNumber getSpannungTextField()
    {
        return _ui.getSpannungTextField();
    }

    @Override
    public void reagiereAufÄnderung()
    {
        _ui.getBetriebsstromTextField().setText(_ibErmittler.getIb().toString());
    }
    
}
