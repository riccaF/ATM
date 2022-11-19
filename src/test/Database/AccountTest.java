package test.Database;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import code.Business_Logic.Euro;
import code.Database.Account;

public class AccountTest {
    Account testAccount;

    @Before
    public void setUp() {
        testAccount = new Account(11111, 42421, new Euro(1000), new Euro(1200));
    }

    @Test
    public void testCredit() {
        testAccount.credit(new Euro(100));
        assertEquals(130000, testAccount.getTotalBalance().getValore());
    }

    @Test
    public void testDebit() {
        testAccount.debit(new Euro(100));
        assertEquals(110000, testAccount.getTotalBalance().getValore());
    }

    @Test
    public void testGetAccountNumber() {
        assertEquals(11111, testAccount.getAccountNumber());
    }

    @Test
    public void testGetAvailableBalance() {
        assertEquals(100000, testAccount.getAvailableBalance().getValore());
    }

    @Test
    public void testGetTotalBalance() {
        assertEquals(120000, testAccount.getTotalBalance().getValore());
    }

    @Test
    public void testValidatePIN() {
        assertTrue(testAccount.validatePIN(42421));
    }
}
