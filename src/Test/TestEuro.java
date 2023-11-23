package Test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import code.Business_logic.Euro;

public class TestEuro {

    private Euro euro1;
    private Euro euro2;

    @Before
    public void setUp() {
        // Inizializza gli oggetti Euro prima di ogni test
        euro1 = new Euro(10, 50);
        euro2 = new Euro(5, 25);
    }

    @Test
    public void testSomma() {
        Euro risultato = euro1.somma(euro2);
        assertEquals(1575, risultato.getValore());
    }

    @Test
    public void testSottrai() {
        Euro risultato = euro1.sottrai(euro2);
        assertEquals(525, risultato.getValore());
    }

    @Test
    public void testUgualeA() {
        assertTrue(euro1.ugualeA(new Euro(10, 50)));
        assertFalse(euro1.ugualeA(euro2));
    }

    @Test
    public void testMinoreDi() {
        assertTrue(euro2.minoreDi(euro1));
        assertFalse(euro1.minoreDi(euro2));
    }

    @Test
    public void testStampa() {
        assertEquals("10.5 euro", euro1.stampa());
        assertEquals("5.25 euro", euro2.stampa());
    }
}
