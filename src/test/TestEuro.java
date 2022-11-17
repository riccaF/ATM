package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import code.Business_logic.Euro;

public class TestEuro {
    // TODO(arkeane)
    @Test
    public void testGetValore() {

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
