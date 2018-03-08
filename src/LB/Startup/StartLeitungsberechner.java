package LB.Startup;

import javax.swing.SwingUtilities;

import LB.Werkzeuge.LeitungsberechnerWerkzeug.LeitungsberechnerWerkzeug;

/**
 * Hier wird das Programm gestartet und das Hauptwerkzeug erstellt.
 * 
 * @author cris
 * @version 07.08.2016
 *
 */
public class StartLeitungsberechner
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new LeitungsberechnerWerkzeug();
            }
        });
    }
}
