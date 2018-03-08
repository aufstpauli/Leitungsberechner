package LB.Werkzeuge.UIKompomente;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;

/**
 * In diesem Textfeld ist die Eingabe nur von zahlen möglich. Es ist nicht möglich eine 0
 * als erste zahl zu schreiben. Erst wenn die erste Zahl zwischen 1-9 steht, sind 0
 * zugelassen
 * 
 * @author cris
 * @version 07.08.2016
 *
 */
public class JNumberTextFieldNumber extends JTextField
{
    private static final long serialVersionUID = -435668919171155835L;
    /**
     * Für die Schriftart Dickgeschriebenes und Schriftgröße
     */
    private static final Font SCHRIFTART_GROSS = new Font("Arial", Font.BOLD,
            15);
    /**
     * Für die Größe des Textfeldes
     */
    private static final int TEXTFIELD_GRößE = 10;
    /**
     * die Maximale Anzahl an Zeichen innerhalb des Textfeldes
     */
    private static final int DIGIT_ANZAHL = 8;

    /**
     * Konstruktor überschreibt das Dokument welches in der Methode neu erstellt
     * wird >> Das Dokument händelt die Eingabe und fängt bzw. bearbeitet 
     * die eingegeben zeichen
     */
    public JNumberTextFieldNumber()
    {
        super();
        setDocument(erstelleNummernDokument(DIGIT_ANZAHL));
        setFont(SCHRIFTART_GROSS);
        setColumns(TEXTFIELD_GRößE);      
    }

    /**
     * Prüft ob die übergebene länge nicht überschritten ist und lässt nur Zahlen durch
     * es wird erlaubt mit dem "Backslash" Zahlen zu löschen. Außerdem wird nur die
     * ersten Ziffer [1-9] zugelassen, danach [0-9]
     * @param maxLength
     * @return Document
     * 
     * @ensure Document != null
     */
    private Document erstelleNummernDokument(final int maxLength)
    {

        Document doc = new PlainDocument()
        {

            private static final long serialVersionUID = -3322783674566638856L;

            @Override
            public void insertString(int offs, String str, AttributeSet a)
                    throws BadLocationException
            {
                // Begrenzt die Anzahl
                if (getLength() + str.length() > maxLength) return;
                // ist das erste Zeichen 0 nur 1-9 zugelassen
                if (offs == 0)
                {
                    if (!str.matches("^[\\[1-9]*$")) return;                    
                }
                // ab Zeichen 1 wird 0-9 zugelassen
                else if(offs > 0)
                {
                    if (!str.matches("^[\\[0-9]*$")) return; 
                }
                super.insertString(offs, str, a);
            }
        };
        return doc;
    }
}
