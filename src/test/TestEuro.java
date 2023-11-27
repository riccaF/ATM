package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import code.Database.Euro;

public class TestEuro {
    
    // Single argument (Double Values)
    Euro value1;
    Euro value2;
    Euro negativeValue1;
    Euro negativeValue2;
    Euro doubleValue;
    Euro negativeDoubleValue1;
    Euro negativeDoubleValue2;
    
    // Two arguments (long euro, long cent)
    Euro value3;
    Euro value4;
    Euro negativeEuroT;
    Euro negativeCentT;
    Euro negativeEuroAndCentT;

    @Before
    public void setUp() {
        value1 = new Euro(35);
        value2 = new Euro(15);
        negativeValue1 = new Euro(-11);
        negativeValue2 = new Euro(-33);
        doubleValue = new Euro(42.75);
        negativeDoubleValue1 = new Euro(-12.33);
        negativeDoubleValue2 = new Euro(-24.52);

        value3 = new Euro(25, 10);
        value4 = new Euro(72, 54);
        negativeEuroT = new Euro(-50,30);
        negativeCentT = new Euro(50, -30);
        negativeEuroAndCentT = new Euro(-50, -30);
    }


    // Tests for initialize Euro //
    @Test
    public void InitOneArgumentOKTest() {
        assertEquals(3500, value1.getValore());
    }

    @Test
    public void InitDoubleValueOKTest() {
        assertEquals(4275, doubleValue.getValore());
    }

    @Test
    public void InitNegativeDoubleValueOKTest() {
        assertEquals(-1233, negativeDoubleValue1.getValore());
    }

    @Test
    public void InitTwoArgumentsOKTest() {
        assertEquals(2510, value3.getValore());
    }

    @Test
    public void InitNegativeEuroOKTest() {
        assertEquals(-5030, negativeEuroT.getValore());
    }

    @Test
    public void InitNegativeCentOKTest() {
        assertEquals(4970, negativeCentT.getValore());
    }

    @Test
    public void InitNegativeEuroAndCentOKTest() {
        assertEquals(-4970, negativeEuroAndCentT.getValore());
    }



    // Tests for sum //
    @Test
    public void SommaOneArgumentBothPositiveOKTest() {
        Euro result = value1.somma(value2);
        assertEquals(5000, result.getValore());
    }

    @Test
    public void SommaOneArgumentOneNegativeOKTest() {
        Euro result = value1.somma(negativeValue1);
        assertEquals(2400, result.getValore());
    }

    @Test
    public void SommaOneArgumentBothNegativeOKTest() {
        Euro result = negativeValue1.somma(negativeValue2);
        assertEquals(-4400, result.getValore());
    }

    @Test
    public void SommaOneArgumentOneNegativeDoubleOKTest() {
        Euro result = negativeDoubleValue1.somma(value1);
        assertEquals(2267, result.getValore());
    }

    @Test
    public void SommaOneArgumentBothNegativeDoubleOKTest(){
        Euro result = negativeDoubleValue1.somma(negativeDoubleValue2);
        assertEquals(-3685, result.getValore());
    }


    @Test
    public void SommaTwoArgumentsBothPositiveOKTest() {
        Euro result = value3.somma(value4);
        assertEquals(9764, result.getValore());
    }

    @Test
    public void SommaTwoArgumentsOneNegativeOKTest() {
        Euro result = value3.somma(negativeEuroT);
        assertEquals(-2520, result.getValore());
    }

    @Test
    public void SommaTwoArgumentBothNegativeOKTest() {
        Euro result = negativeEuroT.somma(negativeCentT);
        assertEquals(-60, result.getValore());
    }


    @Test
    public void SommaMixedArgumentsOKTest() {
        Euro result = value1.somma(value3);
        assertEquals(6010, result.getValore());
    }




    // Tests for sub //

    @Test
    public void SottraiOneArgumentBothPositiveOKTest() {
        Euro result = value1.sottrai(value2);
        assertEquals(2000, result.getValore());
    }

    @Test
    public void SottraiOneArgumentOneNegativeOKTest() {
        Euro result = value1.sottrai(negativeValue1);
        assertEquals(4600, result.getValore());
    }

    @Test
    public void SottraiOneArgumentBothNegativeOKTest() {
        Euro result = negativeValue1.sottrai(negativeValue2);
        assertEquals(2200, result.getValore());
    }

    @Test
    public void SottraiOneArgumentOneNegativeDoubleOKTest() {
        Euro result = negativeDoubleValue1.sottrai(value1);
        assertEquals(-4733, result.getValore());
    }

    @Test
    public void SottraiOneArgumentBothNegativeDoubleOKTest(){
        Euro result = negativeDoubleValue1.sottrai(negativeDoubleValue2);
        assertEquals(1219, result.getValore());
    }


     @Test
    public void SottraiTwoArgumentsBothPositiveOKTest() {
        Euro result = value3.sottrai(value4);
        assertEquals(-4744, result.getValore());
    }

    @Test
    public void SottraiTwoArgumentsOneNegativeOKTest() {
        Euro result = value3.sottrai(negativeEuroT);
        assertEquals(7540, result.getValore());
    }

    @Test
    public void SottraiTwoArgumentBothNegativeOKTest() {
        Euro result = negativeEuroT.sottrai(negativeCentT);
        assertEquals(-10000, result.getValore());
    }


    @Test
    public void SottraiMixedArgumentsOKTest() {
        Euro result = value1.sottrai(value3);
        assertEquals(990, result.getValore());
    }



    // Tests EqualsTo //

    @Test
    public void UgualeA1OKTest() {
        assertTrue(value1.ugualeA(new Euro (35, 0)));
    }

    @Test
    public void UgualeA2OKTest() {
        Euro val1 = new Euro(10);
        Euro val2 = new Euro(5);
        Euro result = val1.somma(val2);
        assertTrue(value2.ugualeA(result));
    }

    @Test
    public void NotUgualeAFAILURETest() {
        assertFalse(value4.ugualeA(negativeDoubleValue1));
    }


    // Tests LessThan //

    @Test 
    public void MinoreDi1OKTest() {
        assertTrue(value2.minoreDi(value1));
    }

    @Test
    public void MinoreDi2OKTest() {
        assertTrue(doubleValue.minoreDi(new Euro(60)));
    }

    @Test
    public void MinoreDi3FAILURETest() {
        assertFalse(negativeDoubleValue1.minoreDi(negativeDoubleValue2));
    }


    // Tests Print //

    @Test
    public void StampaOneArgument1OKTest() {
        assertEquals("35.0 euro", value1.stampa());
    }

    @Test
    public void StampaOneArgument2OKTest() {
        assertEquals("15.0 euro", value2.stampa());
    }

    @Test
    public void StampaTwoArguments1OKTest() {
        assertEquals("25.1 euro", value3.stampa());
    }

    @Test
    public void StampaTwoArguments2OKTest() {
        assertEquals("72.54 euro", value4.stampa());
    }

    @Test
    public void StampaFalseOKTest() {
        assertNotEquals("128.44 euro", negativeDoubleValue1.stampa());
    }
}