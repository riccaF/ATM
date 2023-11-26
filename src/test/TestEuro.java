package test;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Business_logic.Euro;

public class TestEuro {

    private Euro euro1;
    private Euro euro2;
    private Euro euro3;

    @Before
    public void setUp() {
        euro1 = new Euro(10, 50);
        euro2 = new Euro(-5, 75);
        euro3 = new Euro(12.75);
    }

    @Test
    public void testConstructor() {
        assertEquals(1050, euro1.getValore());
        assertEquals(-575, euro2.getValore());
        assertEquals(1275, euro3.getValore());
    }

    @Test
    public void testGetValore() {
        assertEquals(1050, euro1.getValore());
    }

    @Test
    public void testSomma() {
        euro1.somma(new Euro(5, 75));
        assertEquals(1625, euro1.getValore());
    }

    @Test
    public void testSottrai() {
        euro1.sottrai(new Euro(5, 75));
        assertEquals(475, euro1.getValore());
    }

    @Test
    public void testUgualeA() {
        assertTrue(euro1.ugualeA(new Euro(10, 50)));
        assertFalse(euro1.ugualeA(new Euro(5, 75)));
    }

    @Test
    public void testMinoreDi() {
        assertFalse(euro1.minoreDi(new Euro(5, 75)));
        assertTrue(euro1.minoreDi(new Euro(15, 25)));
    }

    @Test
    public void testStampa() {
        assertEquals("10.5 euro", euro1.stampa());
    }
}