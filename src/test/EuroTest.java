package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import code.Business_logic.Euro; 

public class EuroTest {

    @Test
    public void testGetValore() {
       
    }

    @Test
    public void testMinoreDi() {

    }

    @Test
    public void testSomma() {
        Euro eu = new Euro(100,55);
        Euro toSum = new Euro(10,45);
        Euro expected = new Euro(111,00);

        assertEquals(expected.getValore(), eu.somma(toSum).getValore());
    }

    @Test
    public void testSottrai() {
        Euro eu = new Euro(100,55);
        Euro toSub = new Euro(10,55);
        Euro expected = new Euro(90,00);

        assertEquals(expected.getValore(), eu.sottrai(toSub).getValore());
    }

    @Test
    public void testStampa() {

    }

    @Test
    public void testUgualeA() {

    }
}
