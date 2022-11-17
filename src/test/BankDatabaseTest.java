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

    }
}
