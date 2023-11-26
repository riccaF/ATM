package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import code.Database.Account;
import code.Database.Euro;

public class TestAccount {
    Account account;

    @Before
    public void setUp () {
        account = new Account(12345,54321, new Euro(1000.0), new Euro(1200.0));
    }


    // Test for validatePIN //

    @Test
    public void validatePINTest () {
        assertTrue( account.validatePIN( 54321 ) );
    }

    @Test
    public void validatePINFailureTest () {
        assertFalse( account.validatePIN( 123213 ) );
    }


    // Test for getAvailableBalace //

    @Test
    public void getAvailableBalanceTest () {
        assertTrue( new Euro(1000).ugualeA(account.getAvailableBalance()) );
    }

    @Test
    public void getAvailableBalanceFailureTest () {
        assertFalse( new Euro(100).ugualeA(account.getAvailableBalance()) );
    }


    // Test for getTotalBalance //

    @Test
    public void getTotalBalanceTest () {
        assertTrue( new Euro(1200).ugualeA(account.getTotalBalance()) );
    }

    @Test
    public void getTotalBalanceFailureTest () {
        assertFalse( new Euro(100).ugualeA(account.getTotalBalance()) );
    }


    // Test for credit //

    @Test
    public void testCredit () {
        account.credit(new Euro(200));
        assertTrue(new Euro(1400).ugualeA(account.getTotalBalance()));
    }

    @Test
    public void testCreditNegative () {
        account.credit(new Euro(-200));
        assertTrue(new Euro(1000).ugualeA(account.getTotalBalance()));
    }


    // Test for debit //

    @Test 
    public void testDebit () {
        account.debit(new Euro(200));
        assertTrue(new Euro(800).ugualeA(account.getAvailableBalance()));
        assertTrue(new Euro(1000).ugualeA(account.getTotalBalance()));
    } 

    @Test
    public void testDebitNegative () {
        account.debit(new Euro(2000));
        assertTrue(new Euro(-1000).ugualeA(account.getAvailableBalance()));
        assertTrue(new Euro(-800).ugualeA(account.getTotalBalance()));
    }


    // Test for getAccountNumber //

    @Test
    public void testGetAccountNumber () {
        assertEquals(12345, account.getAccountNumber());
    }

    @Test
    public void testGetAccountNumberFailure () {
        assertNotEquals(123145, account.getAccountNumber());
    }



}
