package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import code.Business_logic.Account;

public class AccountTest {
    @Test
    public void testCredit() {

    }

    @Test
    public void testDebit() {

    }

    @Test
    public void testGetAccountNumber() {
        Account acc = new Account(12345, 000, 10, 100);
        int expectedAccountNumber = 12345;

        assertEquals(expectedAccountNumber, acc.getAccountNumber());
    }

    @Test
    public void testGetAvailableBalance() {
        Account acc = new Account(12345, 000, 12345, 1000000);
        double expectedBalance = 12345;

        assertEquals(expectedBalance, acc.getAvailableBalance());
    }

    @Test
    public void testGetTotalBalance() {

    }

    @Test
    public void testValidatePIN() {

    }
}
