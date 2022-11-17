package test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import code.Business_logic.Euro;

public class TestEuro {
   

    @Test
    public void testGetValore() {
        double d = 0.9 ;
        var testEuro = new Euro(d);
        assertEquals(90, testEuro.getValore());
    }

    @Test
    public void testMinoreDi() {
        double d1 = 0.9 ;
        var testEuro1 = new Euro(d1);
        double d2 = 0.7 ;
        var testEuro2 = new Euro(d2);
        assertTrue("70€ < 90€", testEuro2.minoreDi(testEuro1));       
    }

    @Test
    public void testSomma() {

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
