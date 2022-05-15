package com.revoltcode.AccountTest;

import org.junit.Assert;
import org.junit.Test;

public class AccountTest {
    private double epsilon = 1e-6;

    @Test
    public void accountCannotHaveNegativeOverdraftLimit() {
        Account account = new Account(-20);

        Assert.assertEquals(0d, account.getOverdraftLimit(), epsilon);
    }

    @Test
    public void accountCannotDepositNegativeAmount(){
        Account account = new Account(20);
        Assert.assertFalse(account.deposit(-20));
    }

    @Test
    public void accountCannotWithdrawNegativeAmount(){
        Account account = new Account(20);
        Assert.assertFalse(account.withdraw(-20));
    }

    @Test
    public void accountCannotOverstepOverdraftLimit(){
        Account account = new Account(10);
        account.deposit(20);
        Assert.assertEquals(false, account.withdraw(31));
    }

    @Test
    public void accountDepositValid(){
        Account account = new Account(10);
        account.deposit(20);
        Assert.assertEquals(20d, account.getBalance(), epsilon);
    }

    @Test
    public void accountWithdrawalValid(){
        Account account = new Account(10);
        account.deposit(20);
        account.withdraw(10);
        Assert.assertEquals(10d, account.getBalance(), epsilon);
    }

    @Test
    public void accountDepositSuccessful(){
        Account account = new Account(10);
        Assert.assertEquals(true,  account.deposit(20));
    }

    @Test
    public void accountWithdrawalSuccessful(){
        Account account = new Account(10);
        account.deposit(20);
        Assert.assertEquals(true, account.withdraw(10));
    }
}