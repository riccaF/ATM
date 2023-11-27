package test;

import code.Business_logic.Euro;

import org.junit.Test;
import org.junit.Before;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import static org.junit.Assert.*;


public class TestEuro {
    private static Euro euro1;
    private static Euro euro2;
    private static Euro euro3;

    @Before
    public void setUp() {
        euro1 = new Euro(10, 50);
        euro2 = new Euro(-5, 75);
        euro3 = new Euro(15.75);
    }

    @Test
    public void testInitialValues() {
        assertEquals("10.5 euro", euro1.stampa());
        assertEquals("-5.75 euro", euro2.stampa());
        assertEquals("15.75 euro", euro3.stampa());
    }

    @Test
    public void testSumOperation() {
        Euro sumResult = euro1.somma(euro2);
        assertEquals("4.75 euro", sumResult.stampa());
    }

    @Test
    public void testSubtractOperation() {
        Euro subtractResult = euro1.sottrai(euro3);
        assertEquals("-5.25 euro", subtractResult.stampa());
    }

    @Test
    public void testEquality() {
        Euro euro4 = new Euro(10, 50);
        assertTrue(euro1.ugualeA(euro4));
    }

    @Test
    public void testComparison() {
        assertTrue(euro1.minoreDi(euro3));
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TestEuro.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println("All tests passed: " + result.wasSuccessful());
    }
}
