package test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import code.Business_logic.Euro;

public class TestEuro {

    private Euro euro;

    @Before
    public void setup() {
        // Inizializza l'oggetto Euro prima di ogni test
        euro = new Euro(50, 75);
    }

    @Test
    public void testGetValore() {
        assertEquals(5075, euro.getValore());
        assertNotEquals(5076, euro.getValore());
        assertNotEquals(5074, euro.getValore());
    }

    @Test
    public void testSomma() {
        Euro altroEuro = new Euro(25, 50);
        Euro risultato = euro.somma(altroEuro);

        assertEquals(76.25, risultato.getValore() / 100.0, 0.01);
        assertNotEquals(77.26, risultato.getValore() / 100.0, 0.01);
        assertNotEquals(75.25, risultato.getValore() / 100.0, 0.01);
    }

    @Test
    public void testSottrai() {
        Euro altroEuro = new Euro(25, 50);
        Euro risultato = euro.sottrai(altroEuro);

        assertEquals(25.25, risultato.getValore() / 100.0, 0.01);
        assertNotEquals(25.26, risultato.getValore() / 100.0, 0.01);
        assertNotEquals(24.25, risultato.getValore() / 100.0, 0.01);
    }

    @Test
    public void testUgualeA() {
        Euro stessoEuro = new Euro(50, 75);
        Euro euroMaggiore = new Euro(50, 76);
        Euro euroMinore = new Euro(50, 74);

        assertTrue(euro.ugualeA(stessoEuro));
        assertFalse(euro.ugualeA(euroMaggiore));
        assertFalse(euro.ugualeA(euroMinore));
    }

    @Test
    public void testminoreOUgualeDi() {
        Euro euroMaggiore = new Euro(75, 0);
        Euro stessoEuro = new Euro(50, 75);
        Euro euroMinore = new Euro(50, 74);

        assertTrue(euro.minoreOUgualeDi(euroMaggiore));
        assertFalse(euro.minoreOUgualeDi(stessoEuro)); // Ci si aspetta fallisca.

        assertTrue(euro.minoreOUgualeDi(stessoEuro));
        assertFalse(euro.minoreOUgualeDi(euroMinore));
    }

    @Test
    public void testCostruttoreDouble() {
        double valoreDouble = 20.75;
        long valoreCent = 2075;
        long valoreCentErrato = 2076;
        long valoreCentErrato2 = 2074;

        Euro euroCostruito = new Euro(valoreDouble);

        assertEquals(valoreCent, euroCostruito.getValore());
        assertNotEquals(valoreCentErrato, euroCostruito.getValore());
        assertNotEquals(valoreCentErrato2, euroCostruito.getValore());
    }

    @Test
    public void testStampa() {
        assertEquals("50.75 euro", euro.stampa());
        assertNotEquals("50.76 euro", euro.stampa());
        assertNotEquals("50.74 euro", euro.stampa());
    }
}
