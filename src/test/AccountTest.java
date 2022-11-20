package test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import Business_logic.Account;
import Business_logic.Euro;

public class AccountTest {
    // Creating what is needed then in the tests
    int accountNumber;
    int thepin;
    Euro theAvailableBalance;
    Euro theTotalBalance;
    Euro euro;
    Account account1;
    // Using "Before" instead of "BeforeEach" because we are using junit4
    @Before
    public void setUp(){
        // Initializations
        accountNumber = 12345;
        thepin = 54321;
        theAvailableBalance = new Euro(1000);
        theTotalBalance = new Euro(1200);
        euro = new Euro(50);
        account1 = new Account(accountNumber, thepin,
        theAvailableBalance, theTotalBalance);
    } 
    @Test
    public void testCredit() {
        // Using the method credit and then testing totalBalance with assertEquals
        account1.credit(euro);
        assertEquals(theTotalBalance.somma(euro), account1.getTotalBalance());
    }

    // Splitting test Debit in testDebitTotBalance and in testDebitAvBalance
    // to destinguish the two different tests and respective results

    @Test
    public void testDebitTotBalance() {
        // Using the method debit and then testing totalBalance with assertEquals
        account1.debit(euro);
        assertEquals(theTotalBalance.sottrai(euro), account1.getTotalBalance());
    }

    @Test
    public void testDebitAvBalance() {
        // Using the method debit and then testing availableBalance with assertEquals
        account1.debit(euro);
        assertEquals(theAvailableBalance.sottrai(euro), account1.getAvailableBalance());
    }

    @Test
    public void testGetAccountNumber() {
        // Using assertEquals to test the function "getAccountNumber"
        assertEquals(accountNumber, account1.getAccountNumber());
    }

    @Test
    public void testGetAvailableBalance() {
        // Using assertEquals to test the function "getAvailableBalance"
        assertEquals(theAvailableBalance, account1.getAvailableBalance());
    }

    @Test
    public void testGetTotalBalance() {
        // Using assertEquals to test the function "getTotalBalance"
        assertEquals(theTotalBalance, account1.getTotalBalance());
    }

    @Test
    public void testValidatePIN() {
        // Using assertTrue to test the function "validatePIN", 
        // because it has a boolean as return value
        assertTrue(account1.validatePIN(thepin));
    }
}
