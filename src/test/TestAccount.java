package test;
import static org.junit.Assert.*;
import org.junit.*;

import code.Business_logic.Account;
import code.Business_logic.Euro;

public class TestAccount {
    //i test valgono anche per il Constructor B1, B2, B3, B4
    @Test
    public void testConstructorA1(){
        Account user= new Account(000001, 1234, 100.0, 100.0);
        assertEquals(000001, user.getAccountNumber());
    
    }
    @Test
    public void testConstructorA3(){
        Account user= new Account(000001, 1234, 100.0, 100.0);
        assertEquals(100.0, user.getAvailableBalance());
    }
    @Test
    public void testConstructorA4(){
        Account user= new Account(000001, 1234, 100.0, 100.0);
        assertEquals(100.0, user.getTotalBalance());
    }
    @Test
    public void TestCredit(){
        Account account = new Account(0001, 1234, 100.0, 100.0);
        Euro totalBalance = account.getTotalBalance();
        assertEquals(50.25, totalBalance.getValoreD(), 0.01);
    }
    
    @Test
    public void testDebit() {
        Account account = new Account(0001, 1234, 100.0, 100.0);
        Euro amount = new Euro(50, 25);
        account.debit(amount);
        Euro totalBalance = account.getTotalBalance();
        assertEquals(49.75, totalBalance.getValoreD(), 0.01);
    }
}