package LB.Fachwerte;

import static org.junit.Assert.*;

import org.junit.Test;

public class StromTest
{
    private static final int ZAHL1 = 999;
    private static final int ZAHL2 = 1000;
    private static final int ZAHL3 = 1001;
    private static final int ZAHL4 = 99999;
    private static final int ZAHL5 = 100000;
    private static final int ZAHL6 = 100001;
    private static final int ZAHL0 = 0;
    private static final int ZAHL7 = 100001;
    private Strom _strom1;
    private Strom _strom2;
    private Strom _strom3;
    private Strom _strom4;
    private Strom _strom5;
    private Strom _strom6;
    private Strom _strom7;
    private Strom _strom11;
    private Strom _strom12;
    private Strom _strom13;
    private Strom _strom14;
    private Strom _strom0;

    private void setup()
    {
        _strom1 = Strom.get(ZAHL1);
        _strom2 = Strom.get(ZAHL2);
        _strom3 = Strom.get(ZAHL3);
        _strom4 = Strom.get(ZAHL4);
        _strom5 = Strom.get(ZAHL5);
        _strom6 = Strom.get(ZAHL6);
        _strom11 = Strom.get(ZAHL1);
        _strom12 = Strom.get(ZAHL2);
        _strom13 = Strom.get(ZAHL3);
        _strom14 = Strom.get(ZAHL4);
        _strom0 = Strom.get(ZAHL0);
        _strom7 = Strom.get(ZAHL7);
    }

    /**
     * Hier wird der Konstruktor getestet
     */
    @Test
    public void KonstruktorTest()
    {
        setup();
        assertEquals(ZAHL1, _strom1.getMilliAmpere());
        assertEquals(ZAHL2, _strom2.getMilliAmpere());
        assertEquals(ZAHL3, _strom3.getMilliAmpere());
        assertEquals(ZAHL4, _strom4.getMilliAmpere());
    }

    /**
     * Teste die Korrektheit und Robustheit der Methode getMilliAmpere
     */
    @Test
    public void getMilliAmpereTest()
    {
        setup();
        // Korrektheitstest
        assertEquals(ZAHL1, _strom1.getMilliAmpere());
        assertEquals(ZAHL2, _strom2.getMilliAmpere());
        assertEquals(ZAHL3, _strom3.getMilliAmpere());
        assertEquals(ZAHL4, _strom4.getMilliAmpere());
        // Robustheitstest
        assertFalse(ZAHL1 == _strom2.getMilliAmpere());
        assertFalse(ZAHL2 == _strom3.getMilliAmpere());
        assertFalse(ZAHL3 == _strom4.getMilliAmpere());
        assertFalse(ZAHL4 == _strom5.getMilliAmpere());
    }

    /**
     * Testet die korrekte und Robustheit der Methoe istGleich
     */
    @Test
    public void istGleichTest()
    {
        setup();
        // Korrektheitstest
        assertEquals(_strom1, _strom11);
        assertEquals(_strom2, _strom12);
        assertEquals(_strom3, _strom13);
        assertEquals(_strom4, _strom14);
        // Robustheitstest
        assertFalse(_strom1 == _strom12);
        assertFalse(_strom2 == _strom13);
        assertFalse(_strom3 == _strom14);
        assertFalse(_strom4 == _strom11);
    }

    /**
     * Testet die korrekte und Robustheit der Methoe istGrößer
     */
    @Test
    public void istGrößerTest()
    {
        setup();
        // Korrektheitstest
        assertEquals(true, _strom6.istGrößer(_strom5));
        assertEquals(true, _strom5.istGrößer(_strom4));
        assertEquals(true, _strom4.istGrößer(_strom3));
        // Robustheitstest
        assertFalse(_strom1.istGrößer(_strom2));
        assertFalse(_strom2.istGrößer(_strom2));
        assertFalse(_strom3.istGrößer(_strom4));
    }

    /**
     * Testet die korrekte und Robustheit der Methoe istKleiner
     */
    @Test
    public void istKleinerTest()
    {
        setup();
        // Korrektheitstest
        assertEquals(true, _strom1.istKleiner(_strom2));
        assertEquals(true, _strom2.istKleiner(_strom3));
        assertEquals(true, _strom3.istKleiner(_strom4));
        //Robustheitstest
        assertFalse(_strom6.istKleiner(_strom5));
        assertFalse(_strom5.istKleiner(_strom4));
        assertFalse(_strom4.istKleiner(_strom3));
    }

    @Test
    public void addiereTest()
    {
        setup();
        // Korrektheitstest
        assertEquals(2 * _strom1.getMilliAmpere(), _strom1.addiereMit(_strom1)
            .getMilliAmpere());
        assertEquals(2 * _strom2.getMilliAmpere(), _strom2.addiereMit(_strom2)
            .getMilliAmpere());
        assertEquals(2 * _strom3.getMilliAmpere(), _strom3.addiereMit(_strom3)
            .getMilliAmpere());
        //Robustheitstest
        assertFalse(_strom1 == _strom1.addiereMit(_strom2));
        assertFalse(_strom2 == _strom2.addiereMit(_strom3));
        assertFalse(_strom3 == _strom3.addiereMit(_strom4));
    }

    @Test
    public void subtrahiereTest()
    {
        setup();
        // Korrektheitstest
        assertEquals(_strom0, _strom1.subtrahiereMit(_strom11));
        assertEquals(_strom0, _strom2.subtrahiereMit(_strom12));
        assertEquals(_strom0, _strom3.subtrahiereMit(_strom13));
        //Robustheitstest
        assertFalse(_strom1 == _strom0.subtrahiereMit(_strom1));
        assertFalse(_strom1 == _strom1.subtrahiereMit(_strom2));
        assertFalse(_strom0 == _strom1.subtrahiereMit(_strom2));
    }

    @Test
    public void multipliziereMitTest()
    {
        setup();
        // Korrektheitstest
        assertTrue(_strom1.getMilliAmpere() * 2 == _strom1.miltipliziereMit(2)
            .getMilliAmpere());
        assertTrue(_strom2.getMilliAmpere() * 3 == _strom2.miltipliziereMit(3)
            .getMilliAmpere());
        assertTrue(_strom3.getMilliAmpere() * 3 == _strom3.miltipliziereMit(3)
            .getMilliAmpere());
        //Robustheitstest
        assertFalse(_strom1.getMilliAmpere() * 3 == _strom1.miltipliziereMit(2)
            .getMilliAmpere());
        assertFalse(_strom2.getMilliAmpere() * 0 == _strom2.miltipliziereMit(3)
            .getMilliAmpere());
        assertFalse(_strom3.getMilliAmpere() * 1 == _strom3.miltipliziereMit(3)
            .getMilliAmpere());
    }

    @Test
    public void dividiereMitTest()
    {
        setup();
        // Korrektheitstest
        assertTrue((int) ZAHL2 / 10 == _strom2.dividiereMit(10)
            .getMilliAmpere());
        assertTrue((int) ZAHL3 / 10 == _strom3.dividiereMit(10)
            .getMilliAmpere());
        assertTrue((int) ZAHL4 / 10 == _strom4.dividiereMit(10)
            .getMilliAmpere());
        //Robustheitstest
        assertFalse((int) ZAHL2 / 10 == _strom2.dividiereMit(9)
            .getMilliAmpere());
        assertFalse((int) ZAHL2 / 10 == _strom2.dividiereMit(11)
            .getMilliAmpere());
        assertFalse((int) ZAHL3 / 10 == _strom3.dividiereMit(9)
            .getMilliAmpere());
    }

    @Test
    public void toStringTest()
    {
        setup();
        // Korrektheitstest
        assertTrue("0,999".equals(_strom1.toString()));
        assertTrue("1,000".equals(_strom2.toString()));
        assertTrue("1,001".equals(_strom3.toString()));
        assertTrue("100,001".equals(_strom7.toString()));
        //Robustheitstest
        
    }
}
