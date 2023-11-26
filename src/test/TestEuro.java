package test;

import org.junit.Test;
import code.Business_logic.Euro;
import static org.junit.Assert.*;
import org.junit.Before;

public class TestEuro {
    
    private Euro euro1;
    private Euro euro2;
    private Euro euro3;
    private Euro euro4;
    
    @Before  //usiamo @Before e non @BeforeEach perchè usiamo junit 4
    public void setUp() {
        euro1 = new Euro(10, 50);
        euro2 = new Euro(15, 25);
        euro3 = new Euro(20, 00);
        euro4 = new Euro(30, 00);

    }

    @Test
    public void testGetValore() {
        
        long expectedValore = 1050;
        long actualValore = euro1.getValore();

        long expectedValore1 = 2000;
        long actualValore1 = euro3.getValore();

        assertEquals(expectedValore, actualValore);
        assertEquals(expectedValore1, actualValore1);
        
    }

    @Test
    public void testMinoreDi() {
        
        assertTrue(euro1.minoreDi(euro2));
        assertFalse(euro2.minoreDi(euro1));
        assertTrue(euro3.minoreDi(euro4));
        assertFalse(euro4.minoreDi(euro3));
        assertTrue(euro2.minoreDi(euro3));
    }

    @Test
    public void testSomma() {
        // Test case 1: euro1 + euro2
        Euro expectedSum1 = new Euro(25, 75);
        Euro actualSum1 = euro1.somma(euro2);
        assertEquals(expectedSum1.getValore(), actualSum1.getValore());
        //Test case 2: euro2 + euro3
        Euro expectedSum2 = new Euro(35, 25);
        Euro actualSum2 = euro2.somma(euro3);
        assertEquals(expectedSum2.getValore(), actualSum2.getValore());
        //Test case 3: euro3 + euro4
        Euro expectedSum3 = new Euro(50, 00);
        Euro actualSum3 = euro3.somma(euro4);
        assertEquals(expectedSum3.getValore(), actualSum3.getValore());
    }

    @Test
    public void testSottrai() {
        //Test case 1: euro2 - euro1 (euro2 > euro1) 
        Euro expectedDiff1 = new Euro(4, 75);
        Euro actualDiff1 = euro2.sottrai(euro1);
        assertEquals(expectedDiff1.getValore(), actualDiff1.getValore());

        
    }

    @Test
    public void testStampa() {
        
        String expectedOutput = "10.5 euro";
        String expectedOutput1 = "15.25 euro";
        String expectedOutput2 = "20.0 euro";
        String expectedOutput3 = "30.0 euro";
        
        String actualOutput = euro1.stampa();
        String actualOutput1 = euro2.stampa();
        String actualOutput2 = euro3.stampa();
        String actualOutput3 = euro4.stampa();
        
        assertEquals(expectedOutput, actualOutput);
        assertEquals(expectedOutput1, actualOutput1);
        assertEquals(expectedOutput2, actualOutput2);
        assertEquals(expectedOutput3, actualOutput3);
    }

    @Test
    public void testUgualeA() {
        
        assertFalse(euro1.ugualeA(euro2));
        assertFalse(euro1.ugualeA(new Euro(10, 25)));
    }
}
