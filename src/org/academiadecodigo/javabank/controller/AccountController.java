package org.academiadecodigo.javabank.controller;


import org.academiadecodigo.javabank.domain.account.Account;
import org.academiadecodigo.javabank.view.AccountView;

public class AccountController {

    private Account model;
    private AccountView view;

    public AccountController( Account model, AccountView view) {
        this.model = model;
        this.view = view;
    }

    public void updateView(){
        view.updateView( model.getId(), model.getBalance(), model.getAccountType().name());
    }


}
