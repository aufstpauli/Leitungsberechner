package LB.Werkzeuge.LeitungsberechnerWerkzeug;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import LB.Enum.Häufung;
import LB.Enum.Isolierung;
import LB.Enum.Material;
import LB.Enum.Sicherung;
import LB.Enum.Spannungsart;
import LB.Enum.Spannungsfall;
import LB.Enum.Temperatur;
import LB.Enum.Verlegeart;
import LB.Fachwerte.Spannung;
import LB.Fachwerte.Strom;
import LB.Services.AErmittler;
import LB.Services.DelUBerechner;
import LB.Services.Del_uErmittler;
import LB.Services.FaktorF1Ermittler;
import LB.Services.IzBerechner;
import LB.Services.InErmittler;
import LB.Services.FaktorF2Ermittler;
import LB.Services.IrBerechner;
import LB.Werkzeuge.Ergebnisanzeige.ErgebnisanzeigeWerkzeug;
import LB.Werkzeuge.Schritt1.Schritt1Werkzeug;
import LB.Werkzeuge.Schritt2.Schritt2Werkzeug;
import LB.Werkzeuge.Schritt3.Schritt3Werkzeug;
import LB.Werkzeuge.Schritt4.Schritt4Werkzeug;

/**
 * Diese Klasse fügt alle Subwerkzeuge zusammen und erstellt mit den UI Klassen
 * das Hauptfenster
 * 
 * @author cris
 * @version 07.08.2016
 * @version 13.12.2016 - Methoden optimiert
 * @version 17.04.2018 - Anzeige optimiert
 * @version 09.04.2018 - Anzeige für das CosPhi verbessert
 * @version 25.04.2018 - Prüfe und Kontrolle überarbeitet -> Es wird nun korregt
 *                          angezeigt, wenn der Spannungsfall zu hoch ist, dass
 *                          dann der Querschnitt nicht ausreicht.
 *
 */
public class LeitungsberechnerWerkzeug
{
    private LeitungsberechnerUI _ui;
    private Schritt1Werkzeug _schritt1;
    private Schritt2Werkzeug _schritt2;
    private Schritt3Werkzeug _schritt3;
    private Schritt4Werkzeug _schritt4;
    private ErgebnisanzeigeWerkzeug _ergebnisanzeige;

    // Data
    private Strom _ib;
    private Strom _in;
    Strom _ir;
    Strom _iz;
    private Spannung _ub;
    private Spannung _dU;
    private Spannung _dUMax;
    private boolean _isCosPhi = true;
    private boolean _verkettungsfaktor = false;
    private Sicherung _sicherung;
    private Material _material;
    private Isolierung _isolierung;
    private Verlegeart _verlegeart;
    private Häufung _häufung;
    private Temperatur _temperatur;
    private Spannungsfall _spannungsfall;
    private double _länge;
    private double _cosPhi;
    private double _q;
    private double _f1;
    private double _f2;

    /**
     * Konstruktor hier werden die Felder initialisiert und die Subwerkzeuge erstellt
     */
    public LeitungsberechnerWerkzeug()
    {
        erzeugeWerkzeuge();
        erstellePanelderWerkzeuge();
        registriereSchließerButton();
        _schritt4.getBerechneButton()
            .addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    try
                    {
                        einlesenDerDaten();
                        zeigeGegebenAn();
                        BerechnungUndErmittlung();
                        zeigeBerechnungUndErmittlungAn();
                        prüfeUndKorrigiere();
                    }
                    catch (NumberFormatException e1)
                    {
                        JOptionPane.showMessageDialog(null,
                                "Es müssen alle Felder ausgefüllt sein!");
                    }
                }
            });
        _ui.zeigeFenster();
    }

    /**
     * Erst werden alle Eingegeben Daten ermittelt und anschließend werden die
     * Berechnungen durchgeführt.
     */
    private void BerechnungUndErmittlung()
    {
        // Nennstrom der Sicherung In
        _in = InErmittler.getSicherungNennstrom(_ib,
                (Sicherung) _schritt1.getSicherungComboBox()
                    .getSelectedItem());
        // Strombelastbarkeit der Leitung mit Abhängigkeiten Iz
        _iz = IzBerechner.getIz(_in);
        // Temperaturfaktor f1
        _f1 = FaktorF1Ermittler.getFaktor(_isolierung, _temperatur);
        // Temperatur Faktor f2
        _f2 = FaktorF2Ermittler.getFaktor(_häufung);
        // Strombelastbarkeit der Leitung Ir
        _ir = IrBerechner.getIr(_iz, _f1, _f2);
        // Querschnitt ermitteln
        _q = AErmittler.getA(_material, _verlegeart, _verkettungsfaktor, _ir);
    }

    /**
     * Prüft ob bei der Länge der Leitung der maximale Spannungsfall nicht
     * unterschritten wird. Falls doch, so wird der Querschnitt automatisch 
     * um den nächst größeren erhöht und erneut geprüft. Es wird solange Geprüft,
     * bis der höchste Querschnitt erreicht wird, oder der der Spannungsfall 
     * kleiner ist als, der maximal Wert. 
     */
    private void prüfeUndKorrigiere()
    {
        prüfeSpannungsfall();
        zeigePrüfeUndKorrigiere();
        
        // solange DELTA U <= DELTA U Max ist oder der Querschnitt 120qmm ist ...
        while( (_dUMax.istGrößerAls(_dU) || _dUMax.istGleich(_dU)) && _q != 120.0) 
        {
            _q = AErmittler.nächtHöhererQuerschnitt(_q);
            prüfeSpannungsfall();
            zeilenUmbruch();
            _ergebnisanzeige.getErgebnisTextArea()
                .append("  " + "Setze q/A auf: \t" + _q);
            zeilenUmbruch();
            _ergebnisanzeige.getErgebnisTextArea()
                .append("  " + "Delta U: \t \t" + _dU.getStringFormatiert());
            zeilenUmbruch();
            _ergebnisanzeige.getErgebnisTextArea()
                .append("  " + "Delta U max.:\t" + _dUMax.getStringFormatiert());
            zeilenUmbruch();
        }
        // Wenn der höchste Querschnitt nicht ausreicht...
        if (_dUMax.istGrößerAls(_dU) && _q == 120.0 )
        {
            zeilenUmbruch();
            _ergebnisanzeige.getErgebnisTextArea()
            .append("  " + "Es gibt keinen geeigneten Querschnitt. Bitte die Länge "
                    + " prüfen");
        }
        else
        {
            zeilenUmbruch();
            _ergebnisanzeige.getErgebnisTextArea()
            .append("  " + "Zu wählender Querschnitt: \t" + _q +"mm²");
            zeilenUmbruch();
            _ergebnisanzeige.getErgebnisTextArea()
            .append("  \t\t" + "======");            
        }
    }

    /**
     * Überprüft, ob der Spannungsfall nicht höher ist, als zulässig
     */
    private void prüfeSpannungsfall()
    {
        _dUMax = Del_uErmittler.getDel_uMin(_ub, _spannungsfall);
        _dU = DelUBerechner.getDeltaU(_länge, _ib, _cosPhi, _q);
    }


    /**
     * Gibt Zeigt die Daten an, die ausgewählt werden, damit das Ergebnis
     * überprüft werden kann.
     */
    private void zeigeGegebenAn()
    {
        zeilenUmbruch();
        _ergebnisanzeige.getErgebnisTextArea()
            .setText("");
        _ergebnisanzeige.getErgebnisTextArea()
            .append("******************** Gegeben: ***********************");
        zeilenUmbruch();
        _ergebnisanzeige.getErgebnisTextArea()
            .append("  " + "Betriabsspannung: \t" + _ub + " V");
        zeilenUmbruch();
        _ergebnisanzeige.getErgebnisTextArea()
            .append("  " + "Ib: \t \t" + _ib.getStringFormatiert());
        zeilenUmbruch();
        if(_isCosPhi) 
        {
            _ergebnisanzeige.getErgebnisTextArea()
            .append("  " + "cosPhi: \t \t" + "Wird berücksichtigt :" + _cosPhi);            
        }
        else 
        {
            _ergebnisanzeige.getErgebnisTextArea()
            .append("  " + "cosPhi: \t \t" + "Wird nicht berücksichtigt");
        }       
        zeilenUmbruch();
        _ergebnisanzeige.getErgebnisTextArea()
            .append("  " + "Sicherung: \t \t" + _sicherung);
        zeilenUmbruch();
        _ergebnisanzeige.getErgebnisTextArea()
            .append("  " + "Leitungsmaterial: \t" + _material);
        zeilenUmbruch();
        _ergebnisanzeige.getErgebnisTextArea()
            .append("  " + "Isolierung: \t \t" + _isolierung);
        zeilenUmbruch();
        _ergebnisanzeige.getErgebnisTextArea()
            .append("  " + "Verlegungsart: \t" + _verlegeart);
        zeilenUmbruch();
        _ergebnisanzeige.getErgebnisTextArea()
            .append("  " + "Häufung: \t \t" + _häufung);
        zeilenUmbruch();
        _ergebnisanzeige.getErgebnisTextArea()
            .append("  " + "Temperatur: \t \t" + _temperatur);
        zeilenUmbruch();
        _ergebnisanzeige.getErgebnisTextArea()
            .append("  " + "Spannungsfall: \t" + _spannungsfall);
        zeilenUmbruch();
        _ergebnisanzeige.getErgebnisTextArea()
            .append("  " + "Länge: \t \t" + _länge + " m");
        zeilenUmbruch();
    }

    /**
     * Zeigt die Ergebnisse der Berechnungen an.
     */
    private void zeigeBerechnungUndErmittlungAn()
    {
        zeilenUmbruch();
        _ergebnisanzeige.getErgebnisTextArea()
            .append("************* Berechnungen / "
                    + "Ermittlungen:************");
        zeilenUmbruch();

        // In Anzeigen
        _ergebnisanzeige.getErgebnisTextArea()
            .append("  " + "In: \t \t" + _in.getStringFormatiert());
        zeilenUmbruch();
        // f1 Anzeigen
        _ergebnisanzeige.getErgebnisTextArea()
            .append("  " + "f1: \t \t" + ((double) _f1));
        zeilenUmbruch();
        // f2 Anzeigen
        _ergebnisanzeige.getErgebnisTextArea()
            .append("  " + "f2: \t \t" + ((double) _f2));
        zeilenUmbruch();
        // Ir Anzeigen
        _ergebnisanzeige.getErgebnisTextArea()
            .append("  " + "Ir: \t \t" + _ir.getStringFormatiert());
        zeilenUmbruch();
        // Iz Anzeigen
        _ergebnisanzeige.getErgebnisTextArea()
            .append("  " + "Iz: \t \t" + IzBerechner.getIz(_in));
        zeilenUmbruch();
        // q Anzeigen
        _ergebnisanzeige.getErgebnisTextArea()
            .append("  " + "A/q: \t \t" + _q + " qmm");
        zeilenUmbruch();
    }

    /**
     * Zeigt die Ergebnisse der Kontrolle an
     */
    private void zeigePrüfeUndKorrigiere()
    {
        zeilenUmbruch();
        _ergebnisanzeige.getErgebnisTextArea()
            .append("******************* Prüfe  / "
                    + "Korrigiere:******************");
        zeilenUmbruch();
        _ergebnisanzeige.getErgebnisTextArea()
            .append("  " + "Delta U: \t \t" + _dU.getStringFormatiert());
        zeilenUmbruch();
        _ergebnisanzeige.getErgebnisTextArea()
            .append("  " + "Delta U max.: \t" + _dUMax.getStringFormatiert());
        zeilenUmbruch();
    }

    /**
     * Fügt einen Zeilenumbruch bei der Anzeige durch
     */
    private void zeilenUmbruch()
    {
        _ergebnisanzeige.getErgebnisTextArea()
            .append("\n");
    }

    /**
     * Liest die Daten der Eingabekomponenten aus
     */
    private void einlesenDerDaten()
    {
        // Spannung U
        String str = _schritt1.getSpannungTextField()
            .getText();
        int milliVolt = Integer.parseInt(str);
        _ub = Spannung.get(milliVolt * 1000);
        // Betriebsstrom Ib
        str = _schritt1.getBetriebsstromTextField()
            .getText();
        str = parseKommaZuPunkt(str);
        double d = Double.parseDouble(str);
        int milliAmpere = (int) Math.round(d * 1000);
        _ib = Strom.get(milliAmpere);
        // CosPhi
        _isCosPhi = (Spannungsart.Wechselspannung == _schritt1.getSpannungsart()
            .getSelectedItem())
                || (Spannungsart.Dreiphasenwechselspannung == _schritt1
                    .getSpannungsart()
                    .getSelectedItem());
        _verkettungsfaktor = Spannungsart.Dreiphasenwechselspannung == _schritt1
            .getSpannungsart()
            .getSelectedItem();
        str = _schritt1.getCosPhiTextField()
            .getText();
        _cosPhi = Double.parseDouble(parseKommaZuPunkt(str));
        // Sicherungsart
        _sicherung = (Sicherung) _schritt1.getSicherungComboBox()
            .getSelectedItem();
        // Materialart
        _material = (Material) _schritt2.getMaterialComboBox()
            .getSelectedItem();
        // Isolierung
        _isolierung = (Isolierung) _schritt2.getIsolierungComboBox()
            .getSelectedItem();
        // Verlegeart
        _verlegeart = (Verlegeart) _schritt2.getVerlegeartCpmboBox()
            .getSelectedItem();
        // Häufungen
        _häufung = (Häufung) _schritt2.getHäufungComboBox()
            .getSelectedItem();
        // Temperatur
        _temperatur = (Temperatur) _schritt2.getTemperaturComboBox()
            .getSelectedItem();
        // Spannungsfall [delta]u
        _spannungsfall = (Spannungsfall) _schritt3.getSpannungsfallComboBox()
            .getSelectedItem();
        // Leitungslänge
        str = _schritt3.getLängeTextField()
            .getText();
        str = parseKommaZuPunkt(str);
        _länge = Double.parseDouble(str);
        // Wärmefaktoren
        _f1 = FaktorF1Ermittler.getFaktor(_isolierung, _temperatur);
        zeilenUmbruch();
        _f2 = FaktorF2Ermittler.getFaktor(_häufung);
        zeilenUmbruch();
    }

    /**
     * Wandelt im CosPhi alle Komma in ein Punkt um
     * @return String
     * 
     * @ensure String != null
     */
    private String parseKommaZuPunkt(String str)
    {
        str = str.replace(",", ".");
        return str;
    }

    private void erstellePanelderWerkzeuge()
    {
        _ui = new LeitungsberechnerUI(_schritt1.getPanel(),
                _schritt2.getPanel(), _schritt3.getPanel(),
                _schritt4.getPanel(), _ergebnisanzeige.getPanel());
    }

    private void erzeugeWerkzeuge()
    {
        _schritt1 = new Schritt1Werkzeug();
        _schritt2 = new Schritt2Werkzeug();
        _schritt3 = new Schritt3Werkzeug();
        _schritt4 = new Schritt4Werkzeug();
        _ergebnisanzeige = new ErgebnisanzeigeWerkzeug();
    }

    /**
     * Hier wird der Schließbefehl für den Fensterschließerbutton verknüpft
     */
    private void registriereSchließerButton()
    {
        _ui.getSchließerButton()
            .addActionListener(new ActionListener()
            {

                @Override
                public void actionPerformed(ActionEvent e)
                {
                    _ui.schliesseFenster();
                }
            });
    }

}
