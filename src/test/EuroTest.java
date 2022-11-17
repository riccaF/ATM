package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import code.Business_logic.Euro;

public class EuroTest {

    @Test
    public void testGetValore() {

    }

    @Test
    public void testMinoreDi() {

    }

    @Test
    public void testSomma() {

    }

    @Test
    public void testSottrai() {

    }

    @Test
    public void testStampa() {
        Euro eu = new Euro(1000, 50);
        String actual = eu.stampa();
        String expected = "1000.5 euro";
        assertEquals(expected, actual);
    }

    @Test
    public void testUgualeA() {
        Euro eu = new Euro(1000, 50);
        long expected = eu.getValore();
        assertEquals(expected, 100050);
    }
}
