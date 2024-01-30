package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import code.Business_logic.Account;
import code.Business_logic.Euro;

public class TestAccount {
    
    private Account Account1;
    private Account Account2;
    private Account Account3;

    private Euro Euro0;

    @Before
    public void init (){
        Account1    = new Account(1, 1, new Euro(1000), new Euro(1250));
        Account2    = new Account(2, 2, new Euro(2000), new Euro(2500));
        Account3    = new Account(3, 3, new Euro(5000), new Euro(5000));
        Euro0       = new Euro(250);
    }
    
    @Test
    public void testCredit(){
        Account1.credit(Euro0);
        Account2.credit(Euro0);
        Account3.credit(Euro0);
        assertEquals(150000, Account1.getTotalBalance().getValore());
        assertEquals(275000, Account2.getTotalBalance().getValore());
        assertEquals(525000, Account3.getTotalBalance().getValore());
    }

    @Test
    public void testDebit(){
        Account1.debit(Euro0);
        Account2.debit(Euro0);
        Account3.debit(Euro0);
        assertEquals(100000, Account1.getTotalBalance().getValore());
        assertEquals(225000, Account2.getTotalBalance().getValore());
        assertEquals(475000, Account3.getTotalBalance().getValore());
    }

    @Test
    public void testGetAccountNumber() {
        assertEquals(1, Account1.getAccountNumber());
        assertEquals(2, Account2.getAccountNumber());
        assertEquals(3, Account3.getAccountNumber());
    }

    @Test
    public void testGetTotalBalance() {
        assertEquals(125000, Account1.getTotalBalance().getValore());
        assertEquals(250000, Account2.getTotalBalance().getValore());
        assertEquals(500000, Account3.getTotalBalance().getValore());
    }

    @Test
    public void testGetAvailableBalance() {
        assertEquals(100000, Account1.getAvailableBalance().getValore());
        assertEquals(200000, Account2.getAvailableBalance().getValore());
        assertEquals(500000, Account3.getAvailableBalance().getValore());
    }

    @Test
    public void testValidatePin() {
        assertTrue(Account1.validatePIN(1));
        assertTrue(Account2.validatePIN(2));
        assertTrue(Account3.validatePIN(3));   
        assertFalse(Account1.validatePIN(2));
        assertFalse(Account2.validatePIN(3));
        assertFalse(Account3.validatePIN(1));    
    }

}
