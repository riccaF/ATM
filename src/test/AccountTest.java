package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import code.Buisness_logic.Account;
import code.Buisness_logic.Euro;

public class AccountTest {
    @Test
    public void testCredit() {
        Account primoACC = new Account(12345, 54321, new Euro(200.0), new Euro(1000.0));
        primoACC.credit(new Euro(500.0));
        assertEquals(150000, primoACC.getTotalBalance().getValore());
    }

    @Test
    public void testDebit() {
        Account primoACC = new Account(12345, 54321, new Euro(200.0), new Euro(1000.0));
        primoACC.debit(new Euro(500.0));
        assertEquals(50000, primoACC.getTotalBalance().getValore());
    }

    @Test
    public void testGetAvailableBalance() {
        Account primoACC = new Account(12345, 54321, new Euro(200.0), new Euro(1000.0));
        assertEquals(20000, primoACC.getAvailableBalance().getValore());
    }

    @Test
    public void testGetTotalBalance() {
        Account primoACC = new Account(12345, 54321, new Euro(200.0), new Euro(1000.0));
        assertEquals(100000, primoACC.getTotalBalance().getValore());
    }

}
