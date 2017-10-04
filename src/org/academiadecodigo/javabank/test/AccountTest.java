package org.academiadecodigo.javabank.test;

import org.academiadecodigo.javabank.domain.Account;
import org.academiadecodigo.javabank.domain.AccountCheckings;
import org.academiadecodigo.javabank.domain.AccountSavings;
import org.academiadecodigo.javabank.domain.AccountType;

public class AccountTest {

    public boolean test() {

        Account account1 = new AccountCheckings(1);
        Account account2 = new AccountSavings(1);

        // account should start with zero money
        if (account1.getBalance() != 0) {
            return false;
        }

        // we should be able to deposit money in account
        account1.credit(80);
        if (account1.getBalance() != 80) {
            return false;
        }

        // we should be able to take money from account
        account1.debit(40);
        if (account1.getBalance() != 40) {
            return  false;
        }

        return true;
    }

}
