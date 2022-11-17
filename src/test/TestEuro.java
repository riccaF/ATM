package test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import code.Business_logic.Euro;

public class TestEuro {
   

    @Test
    public void testGetValore() {
        var testEuro = new Euro(1,23);
        assertEquals(123, testEuro.getValore());
    }

    @Test
    public void testMinoreDi() {
        var testEuro1 = new Euro(99,23);
        var testEuro2 = new Euro(100,23);
        assertTrue("99.23 < 100.23", testEuro1.minoreDi(testEuro2));     
    }

    @Test
    public void testSomma() {
        var testEuro1 = new Euro(3,20);
        var testEuro2 = new Euro(2,20);
        assertEquals(540, testEuro1.somma(testEuro2).getValore());
    }

    @Test
    public void testSottrai() {
        var testEuro1 = new Euro(3,20);
        var testEuro2 = new Euro(2,20);
        assertEquals(100, testEuro1.sottrai(testEuro2).getValore());
    }

    @Test
    public void testStampa() {
        var testEuro1 = new Euro(3);
        assertEquals("3.0 euro", testEuro1.stampa());

    }

    @Test
    public void testUgualeA() {
        var testEuro1 = new Euro(3);
        var testEuro2 = new Euro(3,0);
        assertTrue("3 euro equivalgono a 3.0 euro", testEuro1.ugualeA(testEuro2));
    }
}
