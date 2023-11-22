package test;

import org.junit.Before;
import org.junit.Test;

import code.BusinessLogic.Euro;

import static org.junit.Assert.*;

public class testEuro {
    private Euro euro1;
    private Euro euro2;

    @Before
    public void setup() {
        euro1 = new Euro(5, 50);
        euro2 = new Euro(4, 50);
    }

    @Test
    public void testEuroLongConstructor() {
        assertEquals(550, euro1.getValore());
    }

    @Test
    public void testEuroDoubleConstructor() {
        Euro euro = new Euro(5.50);
        assertEquals(550, euro.getValore());
    }

    @Test
    public void testGetValore() {
        assertEquals(550, euro1.getValore());
    }

    @Test
    public void testSomma() {
        euro1.somma(euro2);
        assertEquals(1000, euro1.getValore());
    }

    @Test
    public void testSottrai() {
        euro1.sottrai(euro2);
        assertEquals(100, euro1.getValore());
    }

    @Test
    public void testUgualeA() {
        Euro euro = new Euro(5, 50);
        assertTrue(euro1.ugualeA(euro));
    }

    @Test
    public void testMinoreDi() {
        assertTrue(euro2.minoreDi(euro1));
    }

    @Test
    public void testStampa() {
        assertEquals("5.5 euro", euro1.stampa());
    }
}