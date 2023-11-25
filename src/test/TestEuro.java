package test;

import static org.junit.Assert.*;
import org.junit.*;

import code.Euro;

public class TestEuro {
    @Test
    public void testConstructorA1(){
        Euro element = new Euro(1000, 30);
        assertEquals(100030,element.getValore());
    }

    @Test
    public void testConstructorA2(){
        Euro element = new Euro(-1000, 30);
        assertEquals(-100030,element.getValore());    
    }

    @Test
    public void testConstructorB1(){
        Euro element = new Euro(12.34);
        assertEquals(1234,element.getValore());
    }

    @Test
    public void testSomma(){
        double num1 = 56789.23;
        double num2 = 12345.67;
        Euro a = new Euro(num1);
        Euro b = new Euro(num2);
        a.somma(b);
        assertEquals((long)((num1+num2)*100),a.getValore());
    }

    @Test
    public void testSottrai(){
        double num1 = 56789.23;
        double num2 = 12345.67;
        Euro a = new Euro(num1);
        Euro b = new Euro(num2);
        a.sottrai(b);
        assertEquals((long)((num1-num2)*100),a.getValore());
    }

    @Test
    public void testUgualea(){
        double num1 = 12345.67;
        double num2 = 12345.67;
        Euro a = new Euro(num1);
        Euro b = new Euro(num2);
        assertEquals(a.getValore(),b.getValore());
        assertTrue(a.ugualeA(b));
    }

    @Test
    public void testUgualea2(){
        double num1 = 12345.22;
        double num2 = 12345.67;
        Euro a = new Euro(num1);
        Euro b = new Euro(num2);
        assertNotEquals(a.getValore(),b.getValore());
        assertFalse(a.ugualeA(b));
    }

    @Test
    public void testMinoreDi_1(){
        double num1 = 12345.67;
        double num2 = 12.34;
        Euro a = new Euro(num1);
        Euro b = new Euro(num2);
        assertTrue(a.getValore()>=b.getValore());
        assertTrue(b.minoreDi(a));
    }

    @Test
    public void testMinoreDi_2(){
        double num1 = 12345.67;
        double num2 = 12.34;
        Euro a = new Euro(num1);
        Euro b = new Euro(num2);
        assertFalse(a.minoreDi(b));
    }

    @Test
    public void stampa(){
        String s="12345.67 euro";
        Euro euro=new Euro(12345.67);
        assertEquals(s,euro.stampa());
    }

}