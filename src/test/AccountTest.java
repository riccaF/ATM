package test;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import GUI.Account;

public class AccountTest {
    private Account account;

    @Before
    public void setUp() {
        // Create a new Account object for each test
        account = new Account(123456, 1234, 1000.0, 1000.0);
    }

    @Test
    public void testValidatePIN() {
        assertTrue(account.validatePIN(1234));
        assertFalse(account.validatePIN(4321));
    }

    @Test
    public void testGetAvailableBalance() {
        assertEquals(1000, account.getAvailableBalance(), 0);
    }

    @Test
    public void testGetTotalBalance() {
        assertEquals(1000.0, account.getTotalBalance(), 0);
    }

    @Test
    public void testCredit() {
        account.credit(500.0);
        assertEquals(1500.0, account.getTotalBalance(), 0);
    }

    @Test
    public void testDebit() {
        account.debit(500.0);
        assertEquals(500.0, account.getTotalBalance(), 0);
    }

    @Test
    public void testGetAccountNumber() {
        assertEquals(123456, account.getAccountNumber());
    }
}

