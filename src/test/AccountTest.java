package test;
import code.GUI.Account;
import org.junit.Assert;
import org.junit.Test;
import code.Business_Logic.Euro;

public class AccountTest {
    //I valori expected sono in centesimi perchè i get ritornano il valore in centesimi
    @Test
    public void TestValidatePINSuccess() {
        Account account = new Account(1234, 1234, 100, 100);
        Assert.assertTrue(account.validatePIN(1234));
    }

    @Test
    public void TestValidatePINFail() {
        Account account = new Account(1234, 1234, 100, 100);
        Assert.assertFalse(account.validatePIN(1235));
    }

    @Test
    public void TestCostruttore() {
        Account myAccount = new Account(1234, 1234, 1000, 1000);
        Assert.assertEquals(1234, myAccount.getAccountNumber());
        Assert.assertEquals(100000, myAccount.getAvailableBalance().getValore());
        Assert.assertEquals(100000, myAccount.getTotalBalance().getValore());
    }

    @Test
    public void TestCredit() {
        Account myAccount = new Account(1234, 1234, 1000, 1000);
        myAccount.credit(new Euro(100));
        Assert.assertEquals(110000, myAccount.getTotalBalance().getValore());
    }

    @Test
    public void TestDebit() {
        Account myAccount = new Account(1234, 1234, 1000, 1000);
        myAccount.debit(new Euro(100));
        Assert.assertEquals(90000, myAccount.getAvailableBalance().getValore());
        Assert.assertEquals(90000, myAccount.getTotalBalance().getValore());
    }
}