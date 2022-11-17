package test;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import code.Database.BankDatabase;

public class BankDatabaseTest {

    BankDatabase bdtest;

    @Before
    public void SetUp() {
        bdtest = new BankDatabase();
    }

    @Test
    public void testValidAuthenticateUser() {
        assertTrue("User 1234 is authenticated", bdtest.authenticateUser(12345, 54321));
    }

    @Test
    public void testInvalidAuthenticateUser() {
        assertTrue("User 1234 is not authenticated", !bdtest.authenticateUser(1234, 5432));
    }

    @Test
    public void testValidGetAvailableBalance() {
        assertTrue("User 12345 has 100000.0 euro available", bdtest.getAvailableBalance(12345).getValore() == 100000);
    }

    @Test
    public void testInvalidGetAvailableBalance() {
        assertTrue("User 12345 has not 1000.0 euro available", bdtest.getAvailableBalance(12345).getValore() != 1000);
    }

    @Test
    public void testGetTotalBalance() {
        assertTrue("User 12345 has 120000.0 euro in total", bdtest.getTotalBalance(12345).getValore() == 120000);
    }
}
