package LB.Startup;

import java.util.Properties;

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
                
                Properties prop = System.getProperties( );
                System.out.println(prop.getProperty("os.name")); //Windows XP
                System.out.println(prop.getProperty("os.arch")); //x86
                System.out.println(prop.getProperty("os.version")); //5.1
            }
        });
    }
}
