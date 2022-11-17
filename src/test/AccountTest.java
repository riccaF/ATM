package test;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import code.Business_logic.Euro;
import code.Business_logic.Account;

public class AccountTest {
    @Test
    public void testCredit() {
        Euro available = new Euro(1000, 0);
        Euro total = new Euro(1500, 0);
        Account acc = new Account(12345, 54321, available, total);
        acc.credit(200);
        Euro expectedTotal = new Euro(1700, 0);
        assertEquals(expectedTotal.getValore(), acc.getTotalBalance().getValore());
    }

    @Test
    public void testDebit() {
        Euro available = new Euro(1000, 0);
        Euro total = new Euro(1500, 0);
        Account acc = new Account(12345, 54321, available, total);
        acc.debit(200);
        Euro expectedAvailable = new Euro(800, 0);
        Euro expectedTotal = new Euro(1300, 0);
        assertEquals(expectedAvailable.getValore(), acc.getAvailableBalance().getValore());
        assertEquals(expectedTotal.getValore(), acc.getTotalBalance().getValore());
    }

    @Test
    public void testGetAccountNumber() {

    }

    @Test
    public void testGetAvailableBalance() {

    }

    @Test
    public void testGetTotalBalance() {

    }

    @Test
    public void testValidatePIN() {

    }
}
