package LB.Werkzeuge.Schritt2.DialogTabelleVerlegeart;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

import LB.Werkzeuge.Schritt2.Beobachter.BeobachtbarSchritt2;

/**
 * Diese KLasse stellt eine Interaktion mit dem User her, um die Verlegeart aus einer
 * Tabelle wählen zu können. Es werden die einzelnen Bezeichnung genauer erklärt.
 * Dies ermöglicht eine leichtere Auswahl
 * @author cris
 * @version 01.09.2016
 *
 */
public class TabelleVerlegeartWerkzeug extends BeobachtbarSchritt2
{
    private TabelleVerlegeartUI _ui;

    public TabelleVerlegeartWerkzeug()
    {
        _ui = new TabelleVerlegeartUI();
        registriereListener();
    }

    /**
     * registriert die Listener für die Buttons
     */
    private void registriereListener()
    {
        _ui.getAbbrechenButton().addActionListener(new ActionListener()
            {

                @Override
                public void actionPerformed(ActionEvent e)
                {
                    _ui.getDialog().dispose();
                }
            });
        _ui.getÜbernehmenButton().addActionListener(new ActionListener()
            {

                @Override
                public void actionPerformed(ActionEvent e)
                {
                    informiereÜberÄnderung();
                    _ui.getDialog().dispose();
                }
            });
    }

    /**
     * Ermittelt anhand der Radioboxen den Index für die ComboBox
     * @return index
     * 
     * @ensure index != null
     */
    public int getSelectetIndex()
    {
        int index = 0;
        if (_ui.getA1Radiobutton()
            .isSelected())
            index = 0;
        else if (_ui.getA2Radiobutton()
            .isSelected())
            index = 1;
        else if (_ui.getB1Radiobutton()
            .isSelected())
            index = 2;
        else if (_ui.getB2Radiobutton()
            .isSelected())
            index = 3;
        else if (_ui.getCRadiobutton()
            .isSelected())
            index = 4;
        else if (_ui.getERadiobutton()
            .isSelected())
            index = 5;
        else if (_ui.getFRadiobutton()
            .isSelected())
            index = 6;
        else if (_ui.getGRadiobutton()
            .isSelected()) index = 7;
        return index;
    }

    public JDialog getDialog()
    {
        return _ui.getDialog();
    }

}
