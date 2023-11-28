package test;

import org.junit.Assert;
import org.junit.Test;
import code.Business_logic.Euro;

public class TestEuro {

    @Test
    public void testSomma() {
        Euro euro1 = new Euro(5, 50);
        Euro euro2 = new Euro(4, 50);
        euro1.somma(euro2);
        Assert.assertEquals(1000, euro1.getValore());
    }

    @Test
    public void testSottrai() {
        Euro euro1 = new Euro(5, 50);
        Euro euro2 = new Euro(4, 50);
        euro1.sottrai(euro2);
        Assert.assertEquals(100, euro1.getValore());
    }

    @Test
    public void testUgualeA() {
        Euro euro1 = new Euro(5, 50);
        Euro euro2 = new Euro(5, 50);
        Assert.assertTrue(euro1.ugualeA(euro2));
    }

    @Test
    public void testMinoreDi() {
        Euro euro1 = new Euro(4, 50);
        Euro euro2 = new Euro(5, 50);
        Assert.assertTrue(euro1.minoreDi(euro2));
    }
}