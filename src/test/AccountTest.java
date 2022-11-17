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
        Account acc = new Account(12345, 54321, new Euro(10.0), new Euro(100.0));
        int expectedAccountNumber = 12345;

        assertEquals(expectedAccountNumber, acc.getAccountNumber());
    }

    @Test
    public void testGetAvailableBalance() {
        Account acc = new Account(12345, 54321, new Euro(12345.0), new Euro(1000000.0));
        Euro expectedBalance = new Euro(12345.0);

        // assertTrue(expectedBalance.ugualeA(acc.getAvailableBalance()));
        assertEquals(expectedBalance.getValore(), acc.getAvailableBalance().getValore()); // getValore() è già stato testato in EuroTest.java <3
    }

    @Test
    public void testGetTotalBalance() {

    }

    @Test
    public void testValidatePIN() {

    }
}
