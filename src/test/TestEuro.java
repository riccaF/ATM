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

    }

    // TODO(anubi0)
    @Test
    public void testSomma() {
        Euro e1 = new Euro(1);
        Euro e2 = new Euro(2);
        e1.somma(e2);
        assertEquals(300, e1.getValore());
    }

    // TODO(arkeane)
    @Test
    public void testSottrai() {

    }

    // TODO(iobah)
    @Test
    public void testStampa() {

    }

    // TODO(anubi0)
    @Test
    public void testUgualeA() {
        Euro e1 = new Euro(1);
        Euro e2 = new Euro(1);
        assertEquals(true, e1.ugualeA(e2));
    }
}
