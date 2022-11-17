package test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import code.Business_logic.Euro;

import code.Business_logic.Euro;

public class TestEuro {
    // TODO(arkeane)
    @Test
    public void testGetValore() {
        Euro e = new Euro(10, 50);
        assertEquals(1050, e.getValore());
    }

    // TODO(iobah)
    @Test
    public void testMinoreDi() {
        Euro a= new Euro(1);
        Euro b=new Euro(2);
        assertEquals(true , a.minoreDi(b));
    }

    // TODO(anubi0)
    @Test
    public void testSomma() {

    }

    // TODO(arkeane)
    @Test
    public void testSottrai() {
        Euro e1 = new Euro(2, 50);
        Euro e2 = new Euro(5, 50);
        e1.sottrai(e2);
        assertEquals(-300, e1.getValore());
    }

    // TODO(iobah)
    @Test
    public void testStampa() {
        Euro a= new Euro(1,20);
        assertEquals("1.2 euro" , a.stampa());
    }

    // TODO(anubi0)
    @Test
    public void testUgualeA() {

    }
}
