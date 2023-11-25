package test;

import org.junit.Test;
import static org.junit.Assert.*;

import code.Business_logic.Euro;

public class EuroTest {

    @Test
    public void testCostruttoreConDueParametriPositivi() {
        Euro euro = new Euro(5, 50);
        assertEquals(550, euro.getValore());
    }

    @Test
    public void testCostruttoreConDueParametriDiCuiEuroNegativo() {
        Euro euro = new Euro(-5, 50);
        assertEquals(-550, euro.getValore());
    }

    @Test
    public void testCostruttoreConSingoloParamentro() {
        Euro euro = new Euro(5.50);
        assertEquals(550, euro.getValore());
    }

}
