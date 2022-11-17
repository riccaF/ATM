package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import code.Business_logic.Account;
import code.Business_logic.Euro;

public class AccountTest {
    @Test
    public void testCredit() {

    }

    @Test
    public void testDebit() {

    }

    @Test
    public void testGetAccountNumber() {

    }

    @Test
    public void testGetAvailableBalance() {

    }

    @Test
    public void testGetTotalBalance() {
        Account acc = new Account(1, 1, new Euro(10), new Euro(100));
        long actual = acc.getTotalBalance().getValore();
        long expected = 10000;
        assertEquals(expected, actual);
    }

    @Test
    public void testValidatePIN() {
        int pin = 1;
        Account acc = new Account(1, pin, new Euro(10), new Euro(100));
        assertTrue(acc.validatePIN(pin));
    }
}
