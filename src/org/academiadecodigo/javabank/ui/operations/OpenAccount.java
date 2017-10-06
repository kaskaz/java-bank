package org.academiadecodigo.javabank.ui.operations;

import org.academiadecodigo.javabank.managers.AccountManager;

public class OpenAccount implements Operation{

    private AccountManager accountManager;

    public OpenAccount(AccountManager accountManager){
        this.accountManager = accountManager;
    }

    @Override
    public void run() {

    }

    @Override
    public String description() {
        return "Open a new account";
    }

}
