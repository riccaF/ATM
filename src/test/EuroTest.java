package test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import code.Business_logic.Euro; 

public class EuroTest {

    @Test
    public void testGetValore() {
       Euro eu = new Euro(125,50);
       long exptected = 12550;
       assertEquals(exptected, eu.getValore());
    }

    @Test
    public void testMinoreDi() {
        Euro eu1 = new Euro(125,50);
        Euro eu2 = new Euro(15,70);
        boolean exptected = false;
        assertEquals(exptected, eu1.minoreDi(eu2));
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
