package test;

import org.junit.Test;
import static org.junit.Assert.*;

import code.Database.Account;
import code.Business_logic.Euro;


public class AccountTest {
  @Test
  public void testGetAvailableBalance() {
    Euro initialBalance = new Euro(10, 0);
    Account account = new Account(1, 1234, initialBalance, initialBalance);
    assertEquals(1000, account.getAvailableBalance().getValore());
  }

  @Test
  public void testValidatePIN() {
    Account account = new Account(1, 1234, new Euro(10, 0), new Euro(10, 0));
    assertTrue(account.validatePIN(1234));
    assertFalse(account.validatePIN(1111));
  }

  @Test
  public void testCredit() {
    Euro initialBalance = new Euro(10, 0);
    Account account = new Account(1, 1234, initialBalance, initialBalance);
    account.credit(new Euro(5, 0));
    assertEquals(1500, account.getTotalBalance().getValore());
  }

  @Test
  public void testGetAccountNumber() {
    Account account = new Account(1, 1234, new Euro(10, 0), new Euro(10, 0));
    assertEquals(1, account.getAccountNumber());
  }

  @Test
  public void testGetTotalBalance() {
    Euro initialBalance = new Euro(10, 0);
    Account account = new Account(1, 1234, initialBalance, initialBalance);
    assertEquals(1000, account.getTotalBalance().getValore());
  }

  @Test
  public void testDebit() {
    Account account = new Account(1, 1234, new Euro(10, 0), new Euro(10, 0));
    account.debit(new Euro(5, 0));
    assertEquals(500, account.getAvailableBalance().getValore());
    assertEquals(500, account.getTotalBalance().getValore());
  }
}
