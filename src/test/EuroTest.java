package test;

import org.junit.Test;
import static org.junit.Assert.*;

import code.Business_logic.Euro;

public class EuroTest {
  @Test
  public void testCostruttoreConDueParametriPositivi() {
    Euro euro = new Euro(5, 50);
    assertEquals(550, euro.getValore());
  }

  @Test
  public void testCostruttoreConDueParametriDiCuiEuroNegativo() {
    Euro euro = new Euro(-5, 50);
    assertEquals(-550, euro.getValore());
  }

  @Test
  public void testCostruttoreConSingoloParametro() {
    Euro euro = new Euro(5.50);
    assertEquals(550, euro.getValore());
  }

  @Test
  public void testSomma() {
    Euro euro1 = new Euro(5, 50);
    Euro euro2 = new Euro(3, 75);

    Euro risultato = euro1.somma(euro2);
    assertEquals(925, risultato.getValore());
  }

  @Test
  public void testSottrai() {
    Euro euro1 = new Euro(5, 50);
    Euro euro2 = new Euro(3, 75);

    Euro risultato = euro1.sottrai(euro2);
    assertEquals(175, risultato.getValore());
  }

  @Test
  public void testUgualeA() {
    Euro euro1 = new Euro(5, 50);
    Euro euro2 = new Euro(5, 50);
    assertTrue(euro1.ugualeA(euro2));

    Euro euro3 = new Euro(8, 25);
    assertFalse(euro1.ugualeA(euro3));
  }

  @Test
  public void testMinoreDi() {
    Euro euro1 = new Euro(5, 50);
    Euro euro2 = new Euro(8, 25);
    assertTrue(euro1.minoreDi(euro2));

    Euro euro3 = new Euro(3, 75);
    assertFalse(euro1.minoreDi(euro3));
  }

  @Test
  public void testStampaaaaaaaaaaaaa() {
    Euro euro = new Euro(5, 50);
    assertEquals("5.5 euro", euro.stampa());
  }
}
