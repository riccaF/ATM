package test;

import code.GUI.Euro;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class TestEuro {

    private Euro euro;

    @BeforeEach
    public void setup() {
        // Inizializzazione prima di ogni test
        euro = new Euro(5, 50);
    }

    @Test
    public void testCostruttoreConValoriPositivi() {
        assertEquals(550, euro.getValore());
    }

    @Test
    public void testCostruttoreConValoriNegativi() {
        Euro euroNegativo = new Euro(-5, 50);
        assertEquals(-450, euroNegativo.getValore());
    } // deve fallire (controlliamo -450 ma il valore è -550)

    @Test
    public void testCostruttoreConDouble() {
        Euro euroDouble = new Euro(5.50);
        assertEquals(550, euroDouble.getValore());
    }

    @Test
    public void testSomma() {
        Euro euro2 = new Euro(3, 25);
        Euro risultato = euro.somma(euro2);
        assertEquals(875, risultato.getValore());
    }

    @Test
    public void testSottrai() {
        Euro euro2 = new Euro(3, 25);
        Euro risultato = euro.sottrai(euro2);
        assertEquals(225, risultato.getValore());
    }

    @Test
    public void testUgualeA() {
        Euro euroUguale = new Euro(5, 50);
        assertTrue(euro.ugualeA(euroUguale));
    }

    @Test
    public void testNonUgualeA() {
        Euro euroNonUguale = new Euro(3, 25);
        assertFalse(euro.ugualeA(euroNonUguale));
    }

    @Test
    public void testMinoreDi() {
        Euro euroMinore = new Euro(3, 50);
        assertTrue(euroMinore.minoreDi(euro));
    }

    @Test
    public void testNonMinoreDi() {
        Euro euroNonMinore = new Euro(8, 25);
        assertFalse(euroNonMinore.minoreDi(euro));
    }

    @ParameterizedTest
    @CsvSource({ "5.50, 550", "3.75, 375", "7.80, 780" })
    public void testCostruttoreConDoubleParametrizzato(double valoreDouble, long valoreCentesimi) {
        Euro euroParametrizzato = new Euro(valoreDouble);
        assertEquals(valoreCentesimi, euroParametrizzato.getValore());
    }

    @Test
    public void testStampa() {
        assertEquals("5.5 euro", euro.stampa());
    }
}
