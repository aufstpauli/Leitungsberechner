package LB.Fachwerte;

import static org.junit.Assert.*;

import org.junit.Test;

public class SpannungTest
{
    // globale Variablen für die Milli Volt
    private static final int Z1 = 1;
    private static final int Z2 = 10;
    private static final int Z3 = 999;
    private static final int Z4 = 1000;
    private static final int Z5 = 1001;
    private static final int Z6 = 999999;
    private static final int Z7 = 1000000;
    private static final int Z8 = 1000001;
    
    // Globale Variablen für die Erzeungung der Objekte der Klasse Spannung
    private Spannung _u1;
    private Spannung _u2;
    private Spannung _u3;
    private Spannung _u4;
    private Spannung _u5;
    private Spannung _u6;
    private Spannung _u7;
    private Spannung _u8;
    
    /**
     * Bereitet die Tests vor in dem Objekte der klasse Spannung mit verschiedenen Werten erzeugt
     * werden
     */
    private void setup()
    {
        _u1 = Spannung.get(Z1);
        _u2 = Spannung.get(Z2);
        _u3 = Spannung.get(Z3);
        _u4 = Spannung.get(Z4);
        _u5 = Spannung.get(Z5);
        _u6 = Spannung.get(Z6);
        _u7 = Spannung.get(Z7);
        _u8 = Spannung.get(Z8);
    }
    
    /**
     * Hier wird der Konstruktor getestet
     */
    @Test
    public void KonstruktorTest()
    {
        setup();
//        System.out.println(_u1.toInt());
        assertEquals(Z1,_u1.toInt());
        assertEquals(Z2,_u2.toInt());
        assertEquals(Z3,_u3.toInt());
        assertEquals(Z4,_u4.toInt());
        assertEquals(Z5,_u5.toInt());
        assertEquals(Z6,_u6.toInt());
        assertEquals(Z7,_u7.toInt());
        assertEquals(Z8,_u8.toInt());
    }
    
    /**
     * Hier wird die Methode ist Gleich getestet
     */
    @Test
    public void istGleichtest()
    {
        setup();
        // zusätzlich benötigte Variablen
        Spannung u11 = Spannung.get(Z1);
        Spannung u12 = Spannung.get(Z2);
        Spannung u13 = Spannung.get(Z3);
        Spannung u14 = Spannung.get(Z4);
        Spannung u15 = Spannung.get(Z5);
        Spannung u16 = Spannung.get(Z6);
        Spannung u17 = Spannung.get(Z7);
        Spannung u18 = Spannung.get(Z8);
        
        // Korrektheitstest
        assertEquals(_u1, u11);
        assertEquals(_u2, u12);
        assertEquals(_u3, u13);
        assertEquals(_u4, u14);
        assertEquals(_u5, u15);
        assertEquals(_u6, u16);
        assertEquals(_u7, u17);
        assertEquals(_u8, u18);
        
        // Robustheitstest
        assertFalse(_u1 == u12);
        assertFalse(_u2 == u13);
        assertFalse(_u3 == u14);
        assertFalse(_u4 == u15);
        assertFalse(_u5 == u16);
        assertFalse(_u6 == u17);
        assertFalse(_u7 == u18);
        assertFalse(_u8 == u11);
    }
    
    /**
     * Hier wird getestet ob die istGrößer Methode funktioniert
     */
    @Test
    public void istGrößerTest()
    {
        setup();
        // korrektheitstest
        assertTrue(_u8.istKleinerAls(_u7));
        assertTrue(_u7.istKleinerAls(_u6));
        assertTrue(_u6.istKleinerAls(_u5));
        assertTrue(_u5.istKleinerAls(_u4));
        assertTrue(_u4.istKleinerAls(_u3));
        assertTrue(_u3.istKleinerAls(_u2));
        assertTrue(_u2.istKleinerAls(_u1));
        // Robustheitstest
        assertFalse(_u8.istKleinerAls(_u8));
        assertFalse(_u7.istKleinerAls(_u8));
        assertFalse(_u7.istKleinerAls(_u7));
        assertFalse(_u6.istKleinerAls(_u6));
        assertFalse(_u6.istKleinerAls(_u7));
        assertFalse(_u5.istKleinerAls(_u5));
        assertFalse(_u5.istKleinerAls(_u6));
    }
    
    /**
     * Hier wird getestet ob istKleiner Methode funktioniert
     */
    @Test
    public void istKleinerTest()
    {
        setup();
        // korrektheitstest
        assertTrue(_u1.istGrößerAls(_u2));
        assertTrue(_u2.istGrößerAls(_u3));
        assertTrue(_u3.istGrößerAls(_u4));
        assertTrue(_u4.istGrößerAls(_u5));
        assertTrue(_u5.istGrößerAls(_u6));
        assertTrue(_u6.istGrößerAls(_u7));
        assertTrue(_u7.istGrößerAls(_u8));
        // Robistheitstest
        assertFalse(_u8.istGrößerAls(_u1));
        assertFalse(_u7.istGrößerAls(_u1));
        assertFalse(_u6.istGrößerAls(_u1));
        assertFalse(_u5.istGrößerAls(_u1));
        assertFalse(_u4.istGrößerAls(_u1));
        assertFalse(_u3.istGrößerAls(_u1));
        assertFalse(_u2.istGrößerAls(_u1));
        assertFalse(_u1.istGrößerAls(_u1));
    }
    
    /**
     * Diese Mezhode Testet die addiereMit und die MultipliziereMit Methoden in dem eine Spannung
     * mit sich selbst addiert und verglicen wird mit der Spannung die sich selbst mit 2 
     * multipliziert
     */
    @Test
    public void addiereMitUndMultipliziereMit_Test()
    {
        setup();
        // Korrektheitstest
        assertEquals(_u1.multiplizierMit(2), _u1.addiereMit(_u1));
        assertEquals(_u2.multiplizierMit(2), _u2.addiereMit(_u2));
        assertEquals(_u3.multiplizierMit(2), _u3.addiereMit(_u3));
        assertEquals(_u4.multiplizierMit(2), _u4.addiereMit(_u4));
        assertEquals(_u5.multiplizierMit(2), _u5.addiereMit(_u5));
        assertEquals(_u6.multiplizierMit(2), _u6.addiereMit(_u6));
        assertEquals(_u7.multiplizierMit(2), _u7.addiereMit(_u7));
        assertEquals(_u8.multiplizierMit(2), _u8.addiereMit(_u8));
        // Robustheitstest
        assertFalse(_u1.multiplizierMit(3) == _u1.addiereMit(_u1));
        assertFalse(_u1.multiplizierMit(2) == _u2.addiereMit(_u2));
        assertFalse(_u3.multiplizierMit(1) == _u3.addiereMit(_u3));
        assertFalse(_u4.multiplizierMit(2) == _u5.addiereMit(_u4));
        assertFalse(_u5.multiplizierMit(2) == _u5.addiereMit(_u5));
        assertFalse(_u6.multiplizierMit(2) == _u6.addiereMit(_u7));
        assertFalse(_u1.multiplizierMit(2) == _u7.addiereMit(_u7));
        assertFalse(_u1.multiplizierMit(5) == _u8.addiereMit(_u2));
    }
    
    /**
     * Hier wird die subtrahiereMit Methode getestet
     */
    @Test
    public void subtrahiereMitTest()
    {
        setup();
        // zusätzliche Vorraussetzungen
        Spannung u11 = Spannung.get(Z1-Z1);
        Spannung u12 = Spannung.get(Z2-Z1);
        Spannung u13 = Spannung.get(Z3-Z1);
        Spannung u14 = Spannung.get(Z4-Z1);
        Spannung u15 = Spannung.get(Z5-Z1);
        Spannung u16 = Spannung.get(Z6-Z1);
        Spannung u17 = Spannung.get(Z7-Z1);
        Spannung u18 = Spannung.get(Z8-Z1);
        
        // Korrektheitstest
        assertEquals(u11, _u1.subtrahiereMit(_u1));
        assertEquals(u12, _u2.subtrahiereMit(_u1));
        assertEquals(u13, _u3.subtrahiereMit(_u1));
        assertEquals(u14, _u4.subtrahiereMit(_u1));
        assertEquals(u15, _u5.subtrahiereMit(_u1));
        assertEquals(u16, _u6.subtrahiereMit(_u1));
        assertEquals(u17, _u7.subtrahiereMit(_u1));
        assertEquals(u18, _u8.subtrahiereMit(_u1));
        // Robustheitstest
        assertFalse( u11 == _u1.subtrahiereMit(_u2) );
        assertFalse( u12 == _u1.subtrahiereMit(_u2) );
        assertFalse( u13 == _u1.subtrahiereMit(_u2) );
        assertFalse( u14 == _u1.subtrahiereMit(_u2) );
        assertFalse( u15 == _u1.subtrahiereMit(_u2) );
        assertFalse( u16 == _u1.subtrahiereMit(_u2) );
        assertFalse( u17 == _u1.subtrahiereMit(_u2) );
        assertFalse( u18 == _u1.subtrahiereMit(_u2) );
    }
    
    /**
     * Hier wir ddie diviviereMit Methode getestet
     */
    @Test public void dividiereMit()
    {
        setup();
        // Korrektheitstest
        assertEquals(_u2.toInt() / 2, _u2.dividiereMit(2).toInt());
        assertEquals(_u3.toInt() / 2, _u3.dividiereMit(2).toInt());
        assertEquals(_u4.toInt() / 2, _u4.dividiereMit(2).toInt());
        assertEquals(_u5.toInt() / 1, _u5.dividiereMit(1).toInt());
        assertEquals(_u6.toInt() / 2, _u6.dividiereMit(2).toInt());
        assertEquals(_u7.toInt() / 4, _u7.dividiereMit(4).toInt());
        assertEquals(_u8.toInt() / 2, _u8.dividiereMit(2).toInt());
        assertEquals(_u8.toInt() / 3, _u8.dividiereMit(3).toInt());
        // Robustheitstest
        assertFalse(_u2.toInt() / 2 == _u2.dividiereMit(3).toInt());
        assertFalse(_u2.toInt() / 3 == _u2.dividiereMit(2).toInt());
        assertFalse(_u3.toInt() / 2 == _u3.dividiereMit(3).toInt());
        assertFalse(_u4.toInt() / 2 == _u4.dividiereMit(6).toInt());
        assertFalse(_u5.toInt() / 2 == _u5.dividiereMit(3).toInt());
        assertFalse(_u6.toInt() / 2 == _u6.dividiereMit(4).toInt());
        assertFalse(_u7.toInt() / 2 == _u8.dividiereMit(5).toInt());
        assertFalse(_u8.toInt() / 2 == _u8.dividiereMit(3).toInt());
    }
    
    @Test
    public void toStringTest()
    {
        setup();
        // Korrektheitstest
        assertEquals("0,001", _u1.toString());
        assertEquals("0,010", _u2.toString());
        assertEquals("0,999", _u3.toString());
        assertEquals("1,000", _u4.toString());
        assertEquals("1,001", _u5.toString());
        assertEquals("999,999", _u6.toString());
        assertEquals("1000,000", _u7.toString());
        assertEquals("1000,001", _u8.toString());
        // Robustheitstest
        
    }
    
    @Test
    public void toIntTest()
    {
        setup();
        // Korrektheitstest
        //TODO
        // Robustheitstest
        //TODO
    }
    
    @Test
    public void getStringFormatiertTest()
    {
        setup();
        // Korrektheitstest
        //TODO
        // Robustheitstest
        //TODO
    }
    
    @Test
    public void getSpannungInVoltTest()
    {
        setup();
        // Korrektheitstest
        //TODO
        // Robustheitstest
        //TODO
    }
    
}
