package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import code.Business_logic.Euro;
import code.Database.BankDatabase;

public class TestBankDatabase {

    @Test
    public void testAuthenticateUser() {
        BankDatabase bankDatabase = new BankDatabase();

        assertTrue(bankDatabase.authenticateUser(12345, 54321)); // Valid account number and PIN
        assertFalse(bankDatabase.authenticateUser(12345, 9999)); // Invalid PIN
        assertFalse(bankDatabase.authenticateUser(99999, 54321)); // Invalid account number
    }

    @Test
    public void testGetAvailableBalance() {
        BankDatabase bankDatabase = new BankDatabase();

        assertEquals(new Euro(1000.0), bankDatabase.getAvailableBalance(12345));
        assertEquals(new Euro(200.0), bankDatabase.getAvailableBalance(98765));
    }

    @Test
    public void testGetTotalBalance() {
        BankDatabase bankDatabase = new BankDatabase();

        assertEquals(new Euro(1200.0), bankDatabase.getTotalBalance(12345));
        assertEquals(new Euro(200.0), bankDatabase.getTotalBalance(98765));
    }

    @Test
    public void testCredit() {
        BankDatabase bankDatabase = new BankDatabase();
        bankDatabase.credit(12345, new Euro(500.00));

        assertEquals(new Euro(1700.00), bankDatabase.getTotalBalance(12345));
    }

    @Test
    public void testDebit() {
        BankDatabase bankDatabase = new BankDatabase();
        bankDatabase.debit(12345, new Euro(200.00));
        
        assertEquals(new Euro(800.00), bankDatabase.getAvailableBalance(12345));
    }


    @ParameterizedTest
    @CsvSource({"5.5", "0.85", "2056.23", "112.56"})
    public void testCreditParametrizzato(double credit) {
        BankDatabase bankDatabase = new BankDatabase();
        bankDatabase.debit(12345, new Euro(credit));
        assertEquals(new Euro(1200.00 - credit), bankDatabase.getTotalBalance(12345));
    }
    
}