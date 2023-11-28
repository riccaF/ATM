package test;

import static org.junit.Assert.*;
import org.junit.*;

import code.Business_logic.Euro;

/*Questo file contiene i test della classe Euro, passa attraverso i costruttori principali
 * A -> intero,intero
 * B -> double
 * e procede attraverso tutte le funzioni di variazione e confronto che sono disponibili
 * nella suddetta classe.
 */

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

    @Test //test del metodo somma
    public void testSomma(){
        double num1 = 56789.23;
        double num2 = 12345.67;
        Euro a = new Euro(num1);
        Euro b = new Euro(num2);
        a.somma(b);
        assertEquals((long)((num1+num2)*100),a.getValore());
    }

    @Test//test del metodo sottrai
    public void testSottrai(){
        double num1 = 56789.23;
        double num2 = 12345.67;
        Euro a = new Euro(num1);
        Euro b = new Euro(num2);
        a.sottrai(b);
        assertEquals((long)((num1-num2)*100),a.getValore());
    }

    @Test //test del metodo uguale 1
    public void testUgualea(){
        double num1 = 12345.67;
        double num2 = 12345.67;
        Euro a = new Euro(num1);
        Euro b = new Euro(num2);
        assertEquals(a.getValore(),b.getValore());
        assertTrue(a.ugualeA(b));
    }

    @Test //test del metodo uguale 2
    public void testUgualea2(){
        double num1 = 12345.22;
        double num2 = 12345.67;
        Euro a = new Euro(num1);
        Euro b = new Euro(num2);
        assertNotEquals(a.getValore(),b.getValore());
        assertFalse(a.ugualeA(b));
    }

    @Test //test 1 del metodo minore di
    public void testMinoreDi_1(){
        double num1 = 12345.67;
        double num2 = 12.34;
        Euro a = new Euro(num1);
        Euro b = new Euro(num2);
        assertTrue(a.getValore()>=b.getValore());
        assertTrue(b.minoreDi(a));
    }

    @Test //test 2 del metodo minore di
    public void testMinoreDi_2(){
        double num1 = 12345.67;
        double num2 = 12.34;
        Euro a = new Euro(num1);
        Euro b = new Euro(num2);
        assertFalse(a.minoreDi(b));
    }

    @Test //test del metodo stampa
    public void stampa(){
        String s="12345.67 euro";
        Euro euro=new Euro(12345.67);
        assertEquals(s,euro.stampa());
    }

}