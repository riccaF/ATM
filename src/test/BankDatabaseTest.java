package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import Business_logic.Euro;
import Database.BankDatabase;

public class BankDatabaseTest {
    BankDatabase bankdatabase;
    Euro euro12, euro2, euro24, euro10;
    //creating a bankdatabase object as well as some euro objects needed for the tests
    @Before
    public void setup(){
        bankdatabase = new BankDatabase();
        euro12 = new Euro(1200);
        euro10 = new Euro(1000);
        euro2 = new Euro(200);
        euro24 = new Euro(2400);
    }
    @Test
    public void testAuthenticateUser() {
        assertTrue(bankdatabase.authenticateUser(12345, 54321));
        //the default contructor creates an Account with accountNumber 12345 and pin 54321
        //so we use its credentials to testify authenticateUser
    }

    @Test
    public void testCredit() {
        bankdatabase.credit(12345, euro12); //we add euro12 to the total balance of the Account 12345
        assertEquals(euro24.getValore(), bankdatabase.getTotalBalance(12345).getValore());
        //since the TotalBalance of 12345 was set at a new Euro(1200) doubling it means its value
        //should match euro24's
    }

    @Test
    public void testDebit() {
        bankdatabase.debit(12345, euro10); //same thing as debit, except this time we subtract euro10 from the total balance
        assertEquals(euro2.getValore(), bankdatabase.getTotalBalance(12345).getValore());
    }

    @Test
    public void testGetAvailableBalance() {
        assertEquals(euro2.getValore(), bankdatabase.getAvailableBalance(98765).getValore());
        //the availableBalance of the Account 98765 is set as a new Euro(200) so its value
        //should match euro2's
    }

    @Test
    public void testGetTotalBalance() {
        assertEquals(euro12.getValore(), bankdatabase.getTotalBalance(12345).getValore());
        //same thing as we did in testAvailableBalance except we do it with the totalBalance
        //knowing that the totalBalnce of the account 12345 was set as a new Euro(1200)
        //it should match euro12's value
    }
}
