package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import code.Business_logic.Euro;
import code.Database.Account;

public class TestAccount {

    @Test
    public void testValidatePIN() {
        Account account = new Account(12345, 6789, 100.0, 150.0);
        
        assertTrue(account.validatePIN(6789));
        assertFalse(account.validatePIN(9999));
    }

    @Test
    public void testGetAvailableBalance() {
        Account account = new Account(12345, 6789, 100.0, 150.0);
        
        assertEquals(new Euro(100.0), account.getAvailableBalance());
    }

    @Test
    public void testGetTotalBalance() {
        Account account = new Account(12345, 6789, 100.0, 150.0);
        
        assertEquals(new Euro(150.0), account.getTotalBalance());
    }

    @Test
    public void testCredit() {
        Account account = new Account(12345, 6789, 100.0, 150.0);
        
        account.credit(new Euro(50.0));
        assertEquals(new Euro(200.0), account.getTotalBalance());
    }

    @Test
    public void testDebit() {
        Account account = new Account(12345, 6789, 100.0, 150.0);
        
        account.debit(new Euro(50.0));
        assertEquals(new Euro(50.0), account.getAvailableBalance());
        assertEquals(new Euro(100.0), account.getTotalBalance());
    }

    @Test
    public void testGetAccountNumber() {
        Account account = new Account(12345, 6789, 100.0, 150.0);
        
        assertEquals(12345, account.getAccountNumber());
    }

    @Test
    public void testConstructor() {
        Account account = new Account(98765, 4321, 75.0, 100.0);

        assertEquals(98765, account.getAccountNumber());
        assertTrue(account.validatePIN(4321));
        assertEquals(new Euro(75.0), account.getAvailableBalance());
        assertEquals(new Euro(100.0), account.getTotalBalance());
    }

    @Test
    public void testCreditWithZeroAmount() {
        Account account = new Account(11111, 9999, 50.0, 50.0);

        account.credit(new Euro(0.0));
        assertEquals(new Euro(50.0), account.getTotalBalance());
    }


    @Test
    public void testDebitWithZeroAmount() {
        Account account = new Account(33333, 7777, 20.0, 20.0);

        // Debit with zero amount, balances should remain unchanged
        account.debit(new Euro(0.0));

        assertEquals(new Euro(20.0), account.getAvailableBalance());
        assertEquals(new Euro(20.0), account.getTotalBalance());
    }

    @Test
    public void testMultipleCreditsAndDebits() {
        Account account = new Account(44444, 6666, 200.0, 200.0);

        account.credit(new Euro(50.0));
        account.debit(new Euro(30.0));
        account.credit(new Euro(25.0));
        account.debit(new Euro(20.0));

        assertEquals(new Euro(225.0), account.getTotalBalance());
        assertEquals(new Euro(150.0), account.getAvailableBalance());
    }
    
}
