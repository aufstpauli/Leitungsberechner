package LB.Werkzeuge.UIKompomente;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;

public class JNumberTextFieldAnzeige extends JTextField
{
    /**
     * 
     */
    private static final long serialVersionUID = -979509786883150536L;
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
    private static final int DIGIT_ANZAHL = 15;

    /**
     * Konstruktor überschreibt das Dokument welches in der Methode neu erstellt
     * wird >> Das Dokument händelt die Eingabe und fängt bzw. bearbeitet 
     * die eingegeben zeichen
     */
    public JNumberTextFieldAnzeige()
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
                super.insertString(offs, str, a);
            }
        };
        return doc;
    }
}
