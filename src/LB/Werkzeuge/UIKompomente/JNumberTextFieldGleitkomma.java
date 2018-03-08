package LB.Werkzeuge.UIKompomente;

import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.Format;
import java.text.NumberFormat;
import javax.swing.JFormattedTextField;

/**
 * Dieses Textfeld laässt nur Zahlen und Komma eingaben zu. Die Nachkommastellen ist
 * für 3 Nachkommastellen vorgesehen und rundet bei mehr Nachkommastellen automatisch 
 * auf oder ab. Alle Vorangefürten nullen werden entfernt. 
 * 
 * @author cris
 * @version 07.08.2016
 *
 */
public class JNumberTextFieldGleitkomma extends JFormattedTextField
{

    private static final long serialVersionUID = 3303788103008909082L;
    private static final int TEXTFIELD_GRößE = 20;
    private static final int SIGNIFIKANTE_KOMMASTELLEN = 3;
    private static final Font SCHRIFTART_GROSS = new Font("Arial", Font.BOLD,
            15);

    /**
     * Konstruktor überschreibt das Dokument welches in der Methode neu erstellt
     * wird >> Das Dokument händelt die Eingabe und fängt bzw. bearbeitet das 
     * die eingegeben zeichen ab
     */
    public JNumberTextFieldGleitkomma()
    {
       super(setupFormat());
        setColumns(TEXTFIELD_GRößE);
        setFont(SCHRIFTART_GROSS);
        registriereKeyListener();
        
    }

    /**
     * Der Keylistener überprüft die Charzeichen, wenn eine Taste gedrückt wird. Es wird 
     * in diesem Fall geprüft, ob die Taste eine Zahl oder ein "," darstellt. alle anderen
     * Zeichen kommen nicht durch
     */
    private void registriereKeyListener()
    {
        addKeyListener(new KeyListener()
        {
            
            @Override
            public void keyTyped(KeyEvent e)
            {
                if( Character.isDigit(e.getKeyChar()) || (e.getKeyChar() == ',') )
                        {
                            
                        }
                else if( !Character.isDigit(e.getKeyChar()) || !(e.getKeyChar() == ',') )
                {
                    e.setKeyChar('\0');
                }
            }
            
            @Override
            public void keyReleased(KeyEvent e)
            {
                // bleibt leer muss Vorhanden sein wird aber nicht benötigt
            }
            
            @Override
            public void keyPressed(KeyEvent e)
            {
                // bleibt leer muss Vorhanden sein wird aber nicht benötigt
            }
        });
    }
  
    /**
     * Hier wird das Format festgelegt, welches gültig ist. Es dürfen nur Zaheln da stehen
     * und es wird festgelegt wieviele Nachkommastellen da sein dürfen. Der 1000er Punkt
     * wird deaktiviert
     * @return Format
     * 
     * @ ensure Format != null
     */
    private static Format setupFormat()
    {
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(SIGNIFIKANTE_KOMMASTELLEN);
        nf.setGroupingUsed(false);
        return nf;
    }
}
