package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import code.BusinessLogic.Euro;
import code.database.Account;

public class testAccount {

    private Account account;

    @Before
    public void setUp() {
        account = new Account(12345, 1111, 200.0, 500.0);
    }

    @Test
    public void testValidatePIN() {
        assertTrue(account.validatePIN(1111));
        assertFalse(account.validatePIN(2222));
    }

    @Test
    public void testGetAvailableBalance() {
        assertTrue(new Euro(200.0).ugualeA(account.getAvailableBalance()));
    }

    @Test
    public void testGetTotalBalance() {
        assertTrue(new Euro(500.0).ugualeA(account.getTotalBalance()));
    }

    @Test
    public void testCredit() {
        account.credit(new Euro(100.0));
        assertTrue(new Euro(600.0).ugualeA(account.getTotalBalance()));
    }

    @Test
    public void testDebit() {
        account.debit(new Euro(50.0));
        assertTrue(new Euro(150.0).ugualeA(account.getAvailableBalance()));
        assertTrue(new Euro(450.0).ugualeA(account.getTotalBalance()));
    }

    @Test
    public void testGetAccountNumber() {
        assertEquals(12345, account.getAccountNumber());
    }
}