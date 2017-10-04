package org.academiadecodigo.javabank.domain;

import java.util.HashMap;
import java.util.Map;

public class AccountsManager {

    public static final int MIN_SAVINGS_BALANCE = 100;

    private Map<Integer, Account> accounts = new HashMap<>();

    public void addAccount(Account account) {
        accounts.put(account.getId(), account);
    }

    public void deposit(int id, double amount) {
        accounts.get(id).credit(amount);
    }

    public void withdraw(int id, double amount) {

        Account account = accounts.get(id);

        if (account.getAccountType() == AccountType.SAVINGS) {
            return;
        }

        account.debit(amount);

    }

    public void transfer(int srcId, int destId, double amount) {

        Account srcAccount = accounts.get(srcId);
        Account dstAccount = accounts.get(destId);

        // if there is no balance in src account do nothing
        if (srcAccount.getBalance() < amount) {
            return;
        }

        // if src account is savings, we need to keep a minimum balance
        if (srcAccount.getAccountType() == AccountType.SAVINGS &&
                srcAccount.getBalance() < MIN_SAVINGS_BALANCE + amount) {
            return;
        }

        srcAccount.debit(amount);
        dstAccount.credit(amount);

    }
}
