package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import code.Business_logic.Account;
import code.Business_logic.Euro;

public class BankDatabaseTest {
    @Test
    public void testAuthenticateUser() {
        

    }

    @Test
    public void testCredit() {
        Account acc = new Account(12345, 54321, new Euro(100.0), new Euro(1000));
        Euro expectedBalance = new Euro(1500);

        acc.credit(500.0);

        assertEquals(expectedBalance.getValore(), acc.getTotalBalance().getValore());
    }

    @Test
    public void testDebit() {

    }

    @Test
    public void testGetAvailableBalance() {

    }

    @Test
    public void testGetTotalBalance() {

    }
}
