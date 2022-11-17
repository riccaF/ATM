package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import code.Business_logic.Euro;

public class EuroTest {
    //dichiarazione oggetti
    private Euro a;
    private Euro b;
    private Euro c;
    private Euro d;
    
    //metodo chiamato prima di ogni test method
    @Before
    public void setUp() {
        // inizializzazione degli oggetti da testare
        a = new Euro(13.10);
        b = new Euro(25.15);
        c = new Euro(50);
        d = new Euro(50);
    }
    
    @Test
    public void testGetValore() {
        // valore atteso: 100x valore di a
        assertEquals(1310, a.getValore());
    }
    
    @Test
    public void testSomma() {
        a.somma(b);
        assertEquals(3825, a.getValore());
    }
    
    @Test
    public void testSottrai() {
        b.sottrai(a);
        assertEquals(1205, b.getValore());
    }
    
    @Test
    public void testUgualeA() {
        assertTrue(c.ugualeA(d));
    }
    @Test
    public void testMinoreDi() {
        // ok se il valore di a è minore di b
        assertTrue(a.minoreDi(b));
    }
    
    @Test
    public void testStampa() {
        assertEquals("13.1 euro", a.stampa());
    }
}
    
    