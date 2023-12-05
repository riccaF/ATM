package test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import code.Database.BankDatabase;
import code.Business_logic.Euro;

public class TestBankDatabase {

   private BankDatabase bankDatabase;

   @Before
   public void setUp() {
      bankDatabase = new BankDatabase();
   }

   @Test
   public void testAuthenticateUserValidCredentials() {
      assertTrue(bankDatabase.authenticateUser(12345, 54321));
   }

   @Test
   public void testAuthenticateUserInvalidCredentials() {
      assertFalse(bankDatabase.authenticateUser(12345, 99999));
   }

   @Test
   public void testGetAvailableBalance() {
      Euro expectedBalance = new Euro(1000.0);
      assertEquals(expectedBalance.getValore(), bankDatabase.getAvailableBalance(12345).getValore());
   }

   @Test
   public void testgetAvailableBalance() {
      Euro expectedBalance = new Euro(1000.0);
      assertEquals(expectedBalance.getValore(), bankDatabase.getAvailableBalance(12345).getValore());
   }

   @Test
   public void testGetTotalBalance() {
      Euro expectedBalance = new Euro(1200.0);
      assertEquals(expectedBalance.getValore(), bankDatabase.getTotalBalance(12345).getValore());
   }
   

   @Test
   public void testCredit() {
      Euro amountToCredit = new Euro(300.0);
      bankDatabase.credit(12345, amountToCredit);
      Euro expectedBalance = new Euro(1500.0);
      assertEquals(expectedBalance.getValore(), bankDatabase.getTotalBalance(12345).getValore());
   }

   @Test
   public void testDebitSufficientFunds() {
      Euro amountToDebit = new Euro(200.0);
      bankDatabase.debit(12345, amountToDebit);
      Euro expectedBalance = new Euro(800.0);
      assertEquals(expectedBalance.getValore(), bankDatabase.getAvailableBalance(12345).getValore());
   }

   @Test
   public void testDebitInsufficientFunds() {
      Euro amountToDebit = new Euro(2000.0);
      // Ensure that the balance doesn't change if there are insufficient funds
      bankDatabase.debit(12345, amountToDebit);
      Euro expectedBalance = new Euro(1000.0);
      assertEquals(expectedBalance.getValore(), bankDatabase.getAvailableBalance(12345).getValore());
   }
}
