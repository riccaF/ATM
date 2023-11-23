package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import code.Buisness_logic.Euro;

public class EuroTest {
    @Test
    public void testGetValore() {
        Euro testval = new Euro(60);
        assertEquals(6000, testval.getValore());
    }

    @Test
    public void testMinoreDi() {
        Euro primo = new Euro(5);
        Euro secondo = new Euro(2);
        assertEquals(true, secondo.minoreDi(primo));
    }

    @Test
    public void testSetValore() {

    }

    @Test
    public void testSomma() {
        Euro primo = new Euro(10);
        Euro secondo = new Euro(5);
        secondo.somma(primo);
        assertEquals(1500, secondo.getValore());
    }

    @Test
    public void testSottrai() {
        Euro primo = new Euro(10);
        Euro secondo = new Euro(5);
        primo.sottrai(secondo);
        assertEquals(500, secondo.getValore());
    }

    @Test
    public void testStampa() {
        Euro primo = new Euro(50);
        String testString = "50.0 euro";
        assertEquals(testString, primo.stampa());
    }

    @Test
    public void testUgualeA() {
        Euro primo = new Euro(5);
        Euro secondo = new Euro(5);
        assertEquals(true, secondo.ugualeA(primo));
    }
}
