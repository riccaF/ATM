package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import code.Business_logic.Euro;

public class TestEuro {

    private Euro euroTest, euroTest1, euroTest2, euroTest3, euroTest4;

    @Before
    public void setUp() {
        euroTest = new Euro(125, 55);
        euroTest1 = new Euro(129, 99);
        euroTest2 = new Euro(6, 20);
        euroTest3 = new Euro(25, 25);
        euroTest4 = new Euro(77, 30);
    }

    @After
    public void clear() {
        euroTest = null;
        assertNull(euroTest);
    }

    @Test
    public void testGetValore() {
        assertEquals(euroTest.getValore(), 12555, 0.0);
    }

    @Test
    public void testMinoreDi() {
        assertTrue(euroTest.minoreDi(euroTest));
        assertFalse(euroTest1.minoreDi(euroTest));
    }

    @Test
    public void testSomma() {
        Euro euro = euroTest.somma(euroTest2);
        assertTrue(euro.ugualeA(new Euro(131, 75)));
    }

    @Test
    public void testSottrai() {
        Euro euro = euroTest.sottrai(euroTest3);
        assertTrue(euro.ugualeA(new Euro(100, 30)));
    }

    @Test
    public void testStampa() {
        String s = "125.55 euro";
        assertEquals(s, euroTest.stampa());
    }

    @Test
    public void testUgualeA() {
        assertTrue(euroTest.ugualeA(euroTest));
        assertFalse(euroTest.ugualeA(euroTest4));
    }
}
