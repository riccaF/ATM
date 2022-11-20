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
        BankDatabase db = new BankDatabase();
        Euro expectedBalance = new Euro(1700);

        db.credit(12345,500.0);

        assertEquals(expectedBalance.getValore(), db.getTotalBalance(12345).getValore());
    }

    @Test
    public void testDebit() {
        BankDatabase db = new BankDatabase();
        Euro expectedBalance = new Euro(700);

        db.debit(12345,500.0);

        assertEquals(expectedBalance.getValore(), db.getTotalBalance(12345).getValore());
    }

    @Test
    public void testGetAvailableBalance() {
        BankDatabase db = new BankDatabase();
        Euro actual = db.getAvailableBalance(12345);
        Euro expected = new Account(12345, 54321, new Euro(1000.0), new Euro(1200.0)).getAvailableBalance();
        assertEquals(expected.getValore(), actual.getValore());
    }

    @Test
    public void testGetTotalBalance() {
        BankDatabase db = new BankDatabase();
        Euro actual = db.getTotalBalance(12345);
        Euro expected = new Account(12345, 54321, new Euro(1000.0), new Euro(1200.0)).getTotalBalance();
        assertEquals(expected.getValore(), actual.getValore());
    }
}
