package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import code.Business_logic.Euro;

public class TestEuro {
    @Test
    public void testCostruttoreEuroPositivo() {
        Euro euro = new Euro(5, 50);
        assertEquals(550, euro.getValore());
    }

    @Test
    public void testCostruttoreEuroNegativo() {
        Euro euro = new Euro(-5, 50);
        assertEquals(-550, euro.getValore());
    }

    @Test
    public void testCostruttoreDouble() {
        Euro euro = new Euro(7.25);
        assertEquals(725, euro.getValore());
    }

    @Test
    public void testSomma() {
        Euro euro1 = new Euro(5, 50);
        Euro euro2 = new Euro(3, 25);
        Euro risultato = euro1.somma(euro2);
        assertEquals(875, risultato.getValore());
    }

    @Test
    public void testSottrai() {
        Euro euro1 = new Euro(5, 50);
        Euro euro2 = new Euro(3, 25);
        Euro risultato = euro1.sottrai(euro2);
        assertEquals(225, risultato.getValore());
    }

    @Test
    public void testUgualeA() {
        Euro euro1 = new Euro(5, 50);
        Euro euro2 = new Euro(5, 50);
        assertTrue(euro1.ugualeA(euro2));
    }

    @Test
    public void testNonUgualeA() {
        Euro euro1 = new Euro(5, 50);
        Euro euro2 = new Euro(3, 25);
        assertFalse(euro1.ugualeA(euro2));
    }

    @Test
    public void testMinoreDi() {
        Euro euro1 = new Euro(3, 50);
        Euro euro2 = new Euro(5, 25);
        assertTrue(euro1.minoreDi(euro2));
    }

    @Test
    public void testNonMinoreDi() {
        Euro euro1 = new Euro(5, 50);
        Euro euro2 = new Euro(3, 25);
        assertFalse(euro1.minoreDi(euro2));
    }

    @Test
    public void testStampa() {
        Euro euro = new Euro(5, 50);
        assertEquals("5,50 euro", euro.stampa());
    }
}
