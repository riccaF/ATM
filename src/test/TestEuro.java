package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import Business_logic.Euro;

public class TestEuro {
    Euro a, b, c, d;
    //si utilizza "Before", equivalente di BeforeEach in junit4
    @Before
    public void setUp(){
        //inizializzazione degli oggetti da testare
        a = new Euro(22.10);
        b = new Euro(25.15);
        c = new Euro(44);
        d = new Euro(44);    
    }
    @Test
    public void testGetValore() {
        //valore atteso: 100x valore di a
        assertEquals(2210, a.getValore());
    }

    @Test
    public void testMinoreDi() {
        //assertTrue restituisce True se il valore di a è minore di b
        assertTrue(a.minoreDi(b));
    }

    @Test
    public void testSomma() {
        a.somma(c);
        assertEquals(4425, a.getValore());
    }

    @Test
    public void testSottrai() {
        b.sottrai(a);
        assertEquals(305, b.getValore());
    }

    @Test
    public void testStampa() {
        assertEquals("22.1 euro", a.stampa());
    }

    @Test
    public void testUgualeA() {
        //restituisce true se c è uugale a d;
        assertTrue(c.ugualeA(d));
    }
}
