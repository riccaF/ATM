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
    }

    @Test
    public void testSomma() {
        Euro altroEuro = new Euro(25, 50);
        Euro risultato = euro.somma(altroEuro);

        assertEquals(76.25, risultato.getValore() / 100.0, 0.01);
    }

    @Test
    public void testSottrai() {
        Euro altroEuro = new Euro(25, 50);
        Euro risultato = euro.sottrai(altroEuro);

        assertEquals(25.25, risultato.getValore() / 100.0, 0.01);
    }

    @Test
    public void testUgualeA() {
        Euro stessoEuro = new Euro(50, 75);

        assertTrue(euro.ugualeA(stessoEuro));
    }

    @Test
    public void testMinoreDi() {
        Euro altroEuro = new Euro(75, 0);

        assertTrue(euro.minoreDi(altroEuro));
    }

    @Test
    public void testCostruttoreDouble() {
        double valoreDouble = 20.75;
        long valoreCent = 2075;

        Euro euroCostruito = new Euro(valoreDouble);

        assertEquals(valoreCent, euroCostruito.getValore());
    }

    @Test
    public void testStampa() {
        assertEquals("50.75 euro", euro.stampa());
    }
}
