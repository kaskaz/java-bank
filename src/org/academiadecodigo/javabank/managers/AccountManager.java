package org.academiadecodigo.javabank.managers;

import org.academiadecodigo.javabank.domain.account.Account;
import org.academiadecodigo.javabank.domain.account.AccountType;
import org.academiadecodigo.javabank.domain.account.CheckingAccount;
import org.academiadecodigo.javabank.domain.account.SavingsAccount;

import java.util.HashMap;
import java.util.Map;

public class AccountManager {

    private static int numberAccounts = 0;
    Map<Integer, Account> accountMap;

    public AccountManager() {
        this.accountMap = new HashMap<>();
    }

    public AccountManager AccountManagerFactory(){
        return new AccountManager();
    }

    public Account openAccount(AccountType accountType) {

        Account newAccount;

        numberAccounts++;
        if (accountType == AccountType.CHECKING) {
            newAccount = new CheckingAccount(numberAccounts);
        } else {
            newAccount = new SavingsAccount(numberAccounts);
        }

        accountMap.put(newAccount.getId(), newAccount);
        return newAccount;

    }

    public void deposit(int id, double amount) {
        accountMap.get(id).credit(amount);
    }

    public void withdraw(int id, double amount) {

        Account account = accountMap.get(id);

        if (account.getAccountType() == AccountType.SAVINGS) {
            return;
        }

        accountMap.get(id).debit(amount);
    }

    public void transfer(int srcId, int dstId, double amount) {

        Account srcAccount = accountMap.get(srcId);
        Account dstAccount = accountMap.get(dstId);

        // make sure src account has sufficient funds
        if (srcAccount.getBalance() < amount) {
            return;
        }

        // if src account is savings, we need to keep a minimum balance
        if (srcAccount.getAccountType() == AccountType.SAVINGS &&
                srcAccount.getBalance() < SavingsAccount.MIN_BALANCE + amount) {
            return;
        }

        srcAccount.debit(amount);
        dstAccount.credit(amount);

    }
}