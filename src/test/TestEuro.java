package test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import code.Business_logic.Euro;

public class TestEuro {
   
    Euro testEuro, testEuro1, testEuro2, testEuro3, testEuro4, testEuro5;

    @Before
    public void SetUp(){
        testEuro = new Euro(1,23);
        testEuro1 = new Euro(100,23);
        testEuro2 = new Euro(90,23);
        testEuro3 = new Euro(3);
        testEuro4 = new Euro(3,0);
        testEuro5 = new Euro(2,99);
    }


    @Test
    public void testGetValore() {
        assertEquals(123, testEuro.getValore());
        assertNotEquals("1,23", testEuro.getValore());
    }

    @Test
    public void testMinoreDi() {
        assertTrue("90.23 < 100.23", testEuro2.minoreDi(testEuro1));
        assertFalse("100.23 < 900.23", !(testEuro2.minoreDi(testEuro1)));
    }

    @Test
    public void testSomma() {
        assertEquals(19046, testEuro1.somma(testEuro2).getValore());
        assertNotEquals("190,46", testEuro1.somma(testEuro2).getValore());
    }

    @Test
    public void testSottrai() {
        assertEquals(9900, testEuro1.sottrai(testEuro).getValore());
        assertNotEquals(9900, testEuro2.sottrai(testEuro1).getValore());
    }

    @Test
    public void testStampa() {
        assertEquals("1.23 euro", testEuro.stampa());
        assertNotEquals(123, testEuro.stampa());

    }

    @Test
    public void testUgualeA() {
        assertTrue("3 euro equivalgono a 3.0 euro", testEuro4.ugualeA(testEuro3));
        assertFalse("3 euro NON equivalgono a 2.99 euro", testEuro4.ugualeA(testEuro5));
    }
}
