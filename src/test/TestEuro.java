package test;
import static org.junit.Assert.assertEquals; 
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import code.Business_logic.Euro;

public class TestEuro {
    // Creating 3 Euro objects
    Euro eurozero, euroone, eurotwo;
    // Using "Before" instead of "BeforeEach" because we are using junit4
    @Before 
    public void setUp(){
        // Initializing the objects created already
        eurozero = new Euro(1);
        euroone = new Euro(1);
        eurotwo = new Euro(2);
    }
    @Test
    public void testGetValore() {
        assertEquals(eurotwo.getValore(), 200);
        //euro.valore() is 100 times the value that we pass to the constructor
    }

    @Test
    public void testMinoreDi() {
        assertTrue(euroone.minoreDi(eurotwo));
        //we write the test by asserting that the function should recognize the bigger one
    }

    @Test
    public void testSomma() {
        assertEquals(300, eurotwo.somma(euroone).getValore()); 
        //remembering that euro.valore() is 100 times the double we pass to the constructor we write the test
    }

    @Test
    public void testSottrai() {
        // Using assertEquals to test the function "sottrai"
        // The result has to be multiplied per 100 because of how the function is written
        assertEquals(100, eurotwo.sottrai(euroone).getValore());
    }

    @Test
    public void testStampa() {
        // Using assertEquals to test the function "stampa"
        assertEquals("1.0 euro", euroone.stampa());
    }

    @Test
    public void testUgualeA() {
        // Using assertTrue to test the function "ugualeA"
        assertTrue(euroone.ugualeA(eurozero));
    }
}


