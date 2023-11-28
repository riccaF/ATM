import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EuroTest {

    @Test
    void testSomma() {
        Euro euro1 = new Euro(100);
        Euro euro2 = new Euro(200);
        Euro result = euro1.somma(euro2);
        assertEquals(300, result.getValore());
    }

    @Test
    void testSottrai() {
        Euro euro1 = new Euro(200);
        Euro euro2 = new Euro(100);
        Euro result = euro1.sottrai(euro2);
        assertEquals(100, result.getValore());
    }

    @Test
    void testUgualeA() {
        Euro euro1 = new Euro(100);
        Euro euro2 = new Euro(100);
        assertTrue(euro1.ugualeA(euro2));
    }

    @Test
    void testMinoreDi() {
        Euro euro1 = new Euro(100);
        Euro euro2 = new Euro(200);
        assertTrue(euro1.minoreDi(euro2));
    }

    @Test
    void testStampa() {
        Euro euro = new Euro(100);
        assertEquals("1.0 euro", euro.stampa());
    }
}