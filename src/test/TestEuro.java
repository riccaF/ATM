package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import code.Business_logic.Euro;

public class TestEuro {
    @Test
    public void testGetValore() {
        Euro e = new Euro(10, 50);
        assertEquals(1050, e.getValore());
    }

    @Test
    public void testMinoreDi() {
        Euro a= new Euro(1);
        Euro b=new Euro(2);
        assertTrue( a.minoreDi(b));
    }

    @Test
    public void testSomma() {
        Euro e1 = new Euro(1);
        Euro e2 = new Euro(2);
        e1.somma(e2);
        assertEquals(300, e1.getValore());
    }

    @Test
    public void testSottrai() {
        Euro e1 = new Euro(2, 50);
        Euro e2 = new Euro(5, 50);
        e1.sottrai(e2);
        assertEquals(-300, e1.getValore());
    }

    @Test
    public void testStampa() {
        Euro a= new Euro(1,20);
        assertEquals("1.2 euro" , a.stampa());
    }

    @Test
    public void testUgualeA() {
        Euro e1 = new Euro(1);
        Euro e2 = new Euro(1);
        assertTrue(e1.ugualeA(e2));
    }
}
