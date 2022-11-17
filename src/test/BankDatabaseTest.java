package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import code.Business_logic.Account;
import code.Business_logic.Euro;
import code.Database.BankDatabase;

public class BankDatabaseTest {
    @Test
    public void testAuthenticateUser() {

    }

    @Test
    public void testCredit() {

    }

    @Test
    public void testDebit() {

    }

    @Test
    public void testGetAvailableBalance() {

    }

    @Test
    public void testGetTotalBalance() {
        BankDatabase db = new BankDatabase();
        Euro actual = db.getTotalBalance(12345);
        Euro expected = new Account(12345, 54321, new Euro(1000.0), new Euro(1200.0)).getTotalBalance();
        assertEquals(expected.getValore(), actual.getValore());
    }
}
