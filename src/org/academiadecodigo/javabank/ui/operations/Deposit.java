package org.academiadecodigo.javabank.ui.operations;

import org.academiadecodigo.javabank.managers.AccountManager;

public class Deposit implements Operation {

    private AccountManager accountManager;

    public Deposit(AccountManager accountManager){
        this.accountManager = accountManager;
    }

    @Override
    public void run(int context) {
        System.out.println(description());
    }

    @Override
    public String description() {
        return "Deposit";
    }

}