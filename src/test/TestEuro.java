package test;
import static org.junit.Assert.assertEquals;

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
        assertEquals(true, testEuro1.minoreDi(testEuro2));     
    }

    @Test
    public void testSomma() {
        var testEuro1 = new Euro(2,20);
        var testEuro2 = new Euro(3,30);
        assertEquals(550, testEuro1.somma(testEuro2).getValore());
    }

    @Test
    public void testSottrai() {

    }

    @Test
    public void testStampa() {

    }

    @Test
    public void testUgualeA() {

    }
}
