package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import code.Business_logic.Euro;
import code.Database.Account;

public class AccountTest {
    private Account p1;
    private Account p2;
    private Account p3;

    @BeforeEach
    public void setUp() {
        p1 = new Account(12345, 54321, new Euro(1000.0), new Euro(1200.0));
        p2 = new Account(98765, 56789, new Euro(200.0), new Euro(200.0));
        p3 = new Account(11111, 00000, new Euro(10000.0), new Euro(10000.0));
    }

    @Test
    void testCredit() {
        //Test case 1: p1 + 200 = 1400
        Euro expectedcreditp1 = new Euro(1400);
        p1.credit(new Euro(200));
        assertEquals(expectedcreditp1.getValore(), p1.getTotalBalance().getValore());
        //Test case 2: p3 + 0 = 10000
        Euro expectedcreditp3 = new Euro(10000);
        p3.credit(new Euro(0));
        assertEquals(expectedcreditp3.getValore(), p3.getTotalBalance().getValore());
    }

    @Test
    void testDebit() {
        //Test case 1: p2 - 200 = 0
        Euro expectedcreditp2 = new Euro(0);
        p2.debit(new Euro(200));
        assertEquals(expectedcreditp2.getValore(), p2.getAvailableBalance().getValore());
        assertEquals(expectedcreditp2.getValore(), p2.getTotalBalance().getValore());
        //Test case 2: p3 - 1000 = 9000
        Euro expectedcreditp3 = new Euro(9000);
        p3.debit(new Euro(1000));
        assertEquals(expectedcreditp3.getValore(), p3.getAvailableBalance().getValore());
        assertEquals(expectedcreditp3.getValore(), p3.getTotalBalance().getValore());
    }

    @Test
    void testGetAccountNumber() {
        assertEquals(12345, p1.getAccountNumber());
        assertEquals(98765, p2.getAccountNumber());
        assertEquals(11111, p3.getAccountNumber());
    }

    @Test
    void testGetAvailableBalance() {
        assertEquals(new Euro(1000.0).getValore(), p1.getAvailableBalance().getValore());
        assertEquals(new Euro(200.0).getValore(), p2.getAvailableBalance().getValore());
        assertEquals(new Euro(10000.0).getValore(), p3.getAvailableBalance().getValore());
    }

    @Test
    void testGetTotalBalance() {
        assertEquals(new Euro(1200.0).getValore(), p1.getTotalBalance().getValore());
        assertEquals(new Euro(200.0).getValore(), p2.getTotalBalance().getValore());
        assertEquals(new Euro(10000.0).getValore(), p3.getTotalBalance().getValore());
    }

    @Test
    void testValidatePIN() {
        assertTrue(p1.validatePIN(54321));
        assertTrue(p2.validatePIN(56789));
        assertTrue(p3.validatePIN(00000));
    }
}
