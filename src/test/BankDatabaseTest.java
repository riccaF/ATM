package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import code.Business_logic.Euro;
import code.Database.BankDatabase;

public class BankDatabaseTest {
    private static BankDatabase db1;

    @BeforeAll
    public static void setUp() {
        db1 = new BankDatabase();
    }

    @AfterEach
    public void tearDown() {
        db1 = new BankDatabase();
    }

    @Test
    void testAuthenticateUser() {
        assertTrue(db1.authenticateUser(12345, 54321));
        assertFalse(db1.authenticateUser(12345, 54322));
        assertTrue(db1.authenticateUser(98765, 56789));
        assertFalse(db1.authenticateUser(98765, 56788));
    }

    @Test
    void testCredit() {
        //Test case 1: 1200 + 200 = 1400
        Euro expectedcredit = new Euro(1400);
        db1.credit(12345, new Euro(200));
        assertEquals(expectedcredit.getValore(), db1.getTotalBalance(12345).getValore());
        //Test case 2: 200 + 0 = 10000
        expectedcredit = new Euro(200);
        db1.credit(98765, new Euro(0));
        assertEquals(expectedcredit.getValore(), db1.getTotalBalance(98765).getValore());
    }

    @Test
    void testDebit() {
        //Test case 1: 200 - 200 = 0
        Euro expectedcredit = new Euro(0);
        db1.debit(98765, new Euro(200));
        assertEquals(expectedcredit.getValore(), db1.getAvailableBalance(98765).getValore());
        assertEquals(expectedcredit.getValore(), db1.getTotalBalance(98765).getValore());
        //Test case 2: p3 - 1000 = 9000
        expectedcredit = new Euro(0);
        Euro expectedcredittotal = new Euro(200);
        db1.debit(12345, new Euro(1000));
        assertEquals(expectedcredit.getValore(), db1.getAvailableBalance(12345).getValore());
        assertEquals(expectedcredittotal.getValore(), db1.getTotalBalance(12345).getValore());
    }

    @Test
    void testGetAvailableBalance() {
        assertEquals(new Euro(1000.0).getValore(), db1.getAvailableBalance(12345).getValore());
        assertEquals(new Euro(200.0).getValore(), db1.getAvailableBalance(98765).getValore());
    }

    @Test
    void testGetTotalBalance() {
        assertEquals(new Euro(1200.0).getValore(), db1.getTotalBalance(12345).getValore());
        assertEquals(new Euro(200.0).getValore(), db1.getTotalBalance(98765).getValore());

    }
}
