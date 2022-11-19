package test.Business_Logic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import code.Business_Logic.Euro;

public class EuroTest {

    Euro testEuro1, testEuro2;
    
    @Before
    public void setUp() {
        testEuro1 = new Euro(42);
        testEuro2 = new Euro(43);
    }

    @Test
    public void testGetValore() { assertEquals(4200, testEuro1.getValore()); }

    @Test
    public void testMinoreDi() { assertTrue(testEuro1.minoreDi(testEuro2)); }

    @Test
    public void testSomma() {
        testEuro1.somma(testEuro1);
        assertEquals(testEuro1.getValore(), 8400);
    }

    @Test
    public void testSottrai() {
        testEuro1.sottrai(testEuro1);
        assertEquals(testEuro1.getValore(), 0);
    }

    @Test
    public void testStampa() { assertEquals(testEuro1.stampa(), "42.0 euro"); }

    @Test
    public void testUgualeA() { assertFalse(testEuro1.equals(testEuro2)); }
}