package org.academiadecodigo.javabank.ui.operations;

import org.academiadecodigo.javabank.domain.account.Account;
import org.academiadecodigo.javabank.managers.AccountManager;

public class Withdraw implements Operation {

    private AccountManager accountManager;

    public Withdraw(AccountManager accountManager){
        this.accountManager = accountManager;
    }

    @Override
    public void run(int context) {
        System.out.println(description());
    }

    @Override
    public String description() {
        return "Withdraw";
    }

}
