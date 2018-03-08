package LB.Werkzeuge.UIKompomente;

import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

/**
 * Dieses Textfeld ist so Formatiert, dass das Komma bereits darsteht. Es ist eine 
 * Eingabe nur so möglich , dass das vorgegebene Format eingehalten werden muss. Somit
 * können nur Zaheln eingebenen werden. Es reicht wenn alle Zahlen ancheinander eingegeben
 * werden. Der Wertebereicht ist zwischen 0,00 und 1,0. Bei über 1,00 wird automatisch 
 * auf 1,00 gesetzt. Unter 0,00 ist eine Eingabe nicht möglich sollte dies jedoch vorkomemn,
 * wird unter 0,00 automatisch auf 0,00 gesetzt.
 * 
 * @author cris
 * @version 07.08.2016
 *
 */
public class JNumberTextFieldCosPhi extends JFormattedTextField
{

    private static final long serialVersionUID = -9120863035252351956L;
    /**
     * Die Größe des Textfeldes
     */
    private static final int TEXTFIELD_GRößE = 10;
    /**
     * Schriftart, Dickgeschrieben und Schriftgröße des Textfeldes
     */
    private static final Font SCHRIFTART_GROSS = new Font("Arial", Font.BOLD,
            15);

    /**
     * Konstruktor Es werden zunächst das layout erstellt und der Formetter
     * initialisiert. Der Focuslistener wird registriert, damit getestet wird, 
     * dass der Wert immer zwischen 0 und 1 bleibt
     */
    public JNumberTextFieldCosPhi()
    {
        initLayout();
        initFormetter();
        registriereFocusListener();
    }

    /**
     * kümmert sich um die Schriftgröße und der Größe des Textfeldes
     */
    private void initLayout()
    {
        this.setFont(SCHRIFTART_GROSS);
        this.setColumns(TEXTFIELD_GRößE);
    }

    /**
     * 
     */
    private void registriereFocusListener()
    {
        this.addFocusListener(new FocusListener()
        {

            @Override
            public void focusLost(FocusEvent e)
            {
                double db = 0;
                /**
                 *  Wandelt das Komma zu einem Punkt um, damit es in double umgewandelt
                 *  werden kann
                 */
                String str = getText().replace(",", ".");
                /**
                 * Umwandlung des Textes in double mit Sicherheitsabfang
                 */
                try
                {
                    db = Double.parseDouble(str);
                }
                /**
                 * Fehler beim Umwandeln wird automatisch auf 1,00 gesetzt
                 */
                catch (NumberFormatException e1)
                {
                    setText("1,00");
                }

                /**
                 * Sollte ein negativer Wert eingegeben werden wird der auf 0 gesetzt
                 */
                if (db < 0)
                {
                    setText("0,00");
                }
                /**
                 * sollte ein Wet größer 1 eingegeben wird automatisch auf 1 gesetzt
                 */
                else if (db > 1)
                {
                    setText("1,00");
                }
            }

            /**
             * muss vorhanden sein wird aber nicht gebraucht und bleibt daher leer
             */
            @Override
            public void focusGained(FocusEvent e)
            {
            }
        });
    }

    /**
     * Setzt das Format und stellt das Textfield auf 1,00 ein
     */
    private void initFormetter()
    {
        MaskFormatter mf = null;
        try
        {
            mf = new MaskFormatter("#,##");
            this.setFormatter(mf);
        }
        catch (ParseException e)
        {
        }

        DefaultFormatterFactory diff = new DefaultFormatterFactory(mf);
        this.setFormatterFactory(diff);
        this.setText("1,00");
    }

}
