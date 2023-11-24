package test;

import org.junit.Test;
import static org.junit.Assert.*;
import code.Business_logic.Euro;

public class TestEuro {
    @Test
    public void testEuroConstructorAndGetValore() {
        Euro euro = new Euro(50, 20);
        assertEquals(5020, euro.getValore());
    }

    @Test
    public void testEuroConstructorNegativeAndGetValore() {
        Euro euro = new Euro(-50, 20);
        assertEquals(-5020, euro.getValore());
    }

    @Test
    public void testEuroDoubleConstructorAndGetValore() {
        Euro euro = new Euro(50.20);
        assertEquals(5020, euro.getValore());
    }

    @Test
    public void testSomma() {
        Euro euro1 = new Euro(50, 20);
        Euro euro2 = new Euro(30, 10);
        euro1.somma(euro2);
        assertEquals(8030, euro1.getValore());
    }

    @Test
    public void testSottrai() {
        Euro euro1 = new Euro(50, 20);
        Euro euro2 = new Euro(30, 10);
        euro1.sottrai(euro2);
        assertEquals(2010, euro1.getValore());
    }

    @Test
    public void testUgualeA() {
        Euro euro1 = new Euro(50, 20);
        Euro euro2 = new Euro(50, 20);
        assertTrue(euro1.ugualeA(euro2));
    }

    @Test
    public void testUgualeAFailure() {
        Euro euro1 = new Euro(50, 20);
        Euro euro2 = new Euro(30, 30);
        assertFalse(euro1.ugualeA(euro2));
    }

    @Test
    public void testMinoreDi() {
        Euro euro1 = new Euro(50, 20);
        Euro euro2 = new Euro(60, 20);
        assertTrue(euro1.minoreDi(euro2));
    }

    @Test
    public void testMinoreDiFailure() {
        Euro euro1 = new Euro(50, 20);
        Euro euro2 = new Euro(10, 10);
        assertFalse(euro1.minoreDi(euro2));
    }

    @Test
    public void testStampa() {
        Euro euro = new Euro(50, 20);
        assertEquals("50.2 euro", euro.stampa());
    }
}
