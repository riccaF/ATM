package test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import Business_logic.Euro;

public class TestEuro {
    // Creating 3 Euro objects
    Euro euro0, euro1, euro2;
    // Using "Before" instead of "BeforeEach" because we are using junit4
    @Before 
    public void setUp(){
        // Initializing the objects created already
        euro0 = new Euro(1);
        euro1 = new Euro(1);
        euro2 = new Euro(2);
    }
    @Test
    public void testGetValore() {
        assertEquals(euro2.getValore(), 200);
        //euro.valore() is 100 times the value that we pass to the constructor
    }

    @Test
    public void testMinoreDi() {
        assertTrue(euro1.minoreDi(euro2));
        //we write the test by asserting that the function should recognize the bigger one
    }

    @Test
    public void testSomma() {
        assertEquals(300, euro2.somma(euro1).getValore()); 
        //remembering that euro.valore() is 100 times the double we pass to the constructor we write the test
    }

    @Test
    public void testSottrai() {
        // Using assertEquals to test the function "sottrai"
        // The result has to be multiplied per 100 because of how the function is written
        assertEquals(100, euro2.sottrai(euro1).getValore());
    }

    @Test
    public void testStampa() {
        // Using assertEquals to test the function "stampa"
        assertEquals("1.0 euro", euro1.stampa());
    }

    @Test
    public void testUgualeA() {
        // Using assertTrue to test the function "ugualeA"
        assertTrue(euro1.ugualeA(euro0));
    }
}
