 package test;

 // import the assertion
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

// import the code to test
import code.Database.BankDatabase;

public class TestBankDatabase {

    BankDatabase bdtest;

    @Before
    public void SetUp() {
        bdtest = new BankDatabase();
    }

    @Test
    public void testValidAuthenticateUser() {
        assertTrue("The user 1234 is abilited", bdtest.authenticateUser(12345, 54321));
    }

    @Test
    public void testInvalidAuthenticateUser() {
        assertTrue("The user 1234 is not abilited", !bdtest.authenticateUser(1234, 5432));
    }

    @Test
    public void testValidGetAvailableBalance() {
        assertTrue("The user 12345 has 100000.0 euro available", bdtest.getAvailableBalance(12345).getValore() == 100000);
    }

    @Test
    public void testInvalidGetAvailableBalance() {
        assertTrue("The user 12345 has not 1000.0 euro available", bdtest.getAvailableBalance(12345).getValore() != 1000);
    }

    @Test
    public void testGetTotalBalance() {
        assertTrue("The user 12345 has a total amount of 120000.0 euro ", bdtest.getTotalBalance(12345).getValore() == 120000);
    }
}
