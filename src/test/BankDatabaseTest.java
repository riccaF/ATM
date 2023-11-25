package test;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import code.Business_logic.Euro;
import code.Database.BankDatabase;

public class BankDatabaseTest {
  private BankDatabase bankDatabase;

  @Before
  public void setUp() {
    bankDatabase = new BankDatabase();
  }

  @Test
  public void testAuthenticateUser() {
    assertTrue(bankDatabase.authenticateUser(12345, 54321));
    assertFalse(bankDatabase.authenticateUser(12345, 9999));
    assertFalse(bankDatabase.authenticateUser(9999, 54321));
  }

  @Test
  public void testGetAvailableBalance() {
    assertEquals(100000, bankDatabase.getAvailableBalance(12345).getValore());
    assertEquals(20000, bankDatabase.getAvailableBalance(98765).getValore());
  }

  @Test
  public void testGetTotalBalance() {
    assertEquals(120000, bankDatabase.getTotalBalance(12345).getValore());
    assertEquals(20000, bankDatabase.getTotalBalance(98765).getValore());
  }

  @Test
  public void testCredit() {
    bankDatabase.credit(12345, new Euro(500.0));
    assertEquals(170000, bankDatabase.getTotalBalance(12345).getValore());
  }

  @Test
  public void testDebit() {
    bankDatabase.debit(98765, new Euro(100.0));
    assertEquals(10000, bankDatabase.getAvailableBalance(98765).getValore());
    assertEquals(10000, bankDatabase.getTotalBalance(98765).getValore());
  }
}
