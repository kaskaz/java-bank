package org.academiadecodigo.javabank.test;

import org.academiadecodigo.javabank.domain.account.Account;
import org.academiadecodigo.javabank.domain.account.AccountFactory;
import org.academiadecodigo.javabank.domain.account.AccountType;

public class AccountFactoryTest {

    public boolean test(){


        AccountFactory accountFactory = new AccountFactory();
        Account account1 = accountFactory.create(1, AccountType.SAVINGS);
        Account account2 = accountFactory.create(2,AccountType.CHECKING);

        if (account1.getAccountType() != AccountType.SAVINGS || account2.getAccountType() != AccountType.CHECKING){
            return false;
        }


        return true;
    }
}
