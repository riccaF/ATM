package test;

import org.junit.Test;
import code.Business_logic.Euro;
import static org.junit.Assert.*;
import org.junit.Before;

public class TestEuro {
    
    private Euro euro1;
    private Euro euro2;
    
    @Before  //usiamo @Before e non @BeforeEach perchè usiamo junit 4
    public void setUp() {
        euro1 = new Euro(10, 50);
        euro2 = new Euro(15, 25);
    }

    @Test
    public void testGetValore() {
        
        long expectedValore = 1050;
        
        long actualValore = euro1.getValore();
        
        assertEquals(expectedValore, actualValore);
    }

    @Test
    public void testMinoreDi() {
        
        assertTrue(euro1.minoreDi(euro2));
        assertFalse(euro2.minoreDi(euro1));
    }

    @Test
    public void testSomma() {
        Euro euro1 = new Euro(10, 50);
        Euro euro2 = new Euro(15, 25);
        Euro expectedSum = new Euro(25, 75);
        
        Euro actualSum = euro1.somma(euro2);
        
        assertEquals(expectedSum.getValore(), actualSum.getValore());
    }

    @Test
    public void testSottrai() {
        Euro euro1 = new Euro(15, 25);
        Euro euro2 = new Euro(10, 50);
        Euro expectedDifference = new Euro(4, 75);
        
        Euro actualDifference = euro1.sottrai(euro2);
        
        assertEquals(expectedDifference.getValore(), actualDifference.getValore());
    }

    @Test
    public void testStampa() {
        Euro euro = new Euro(10, 50);
        String expectedOutput = "10.5 euro";
        
        String actualOutput = euro.stampa();
        
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testUgualeA() {
        Euro euro1 = new Euro(10, 50);
        Euro euro2 = new Euro(10, 50);
        
        assertTrue(euro1.ugualeA(euro2));
        assertFalse(euro1.ugualeA(new Euro(10, 25)));
    }
}
