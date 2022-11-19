package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.*;


import code.Business_logic.*;



public class AccountTest {

    int accountNumber;
    int thePIN;
    Euro theAvaibleBalance;
    Euro theTotalBalance;
    Euro euro;
    Account account1;


    

    //metodo chiamato prima di ogni test method
    @Before
    public void setUp() {

        accountNumber = 12345;
        thePIN = 54321;
        theAvaibleBalance = new Euro(1000);
        theTotalBalance = new Euro(1200);
        euro = new Euro(50);
        
        account1 = new Account(accountNumber, thePIN, theAvaibleBalance, theTotalBalance); 
    }

    @Test
    public void testCredit() {
        account1.credit(euro);
        assertEquals((50*100)+(1200*100), account1.getTotalBalance().getValore());
    }

    @Test
    public void testDebit() {
        account1.debit(euro);
        assertEquals((1000*100)-(50*100), account1.getAvailableBalance().getValore());
        assertEquals((1200*100)-(50*100), account1.getTotalBalance().getValore());

    }

    @Test
    public void testGetAccountNumber() {
        assertEquals(12345, account1.getAccountNumber());

    }

    @Test
    public void testGetAvailableBalance() {
        assertEquals(1000*100, account1.getAvailableBalance().getValore());

    }

    @Test
    public void testGetTotalBalance() {
        assertEquals(1200*100, account1.getTotalBalance().getValore());


    }

    @Test
    public void testValidatePIN() {
       
        assertTrue("True",  account1.validatePIN(54321));


    }
}
