package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.javabank.factories.AccountFactory;
import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.model.account.AccountType;
import org.academiadecodigo.javabank.services.AccountImpl;

public class NewAccountController extends AbstractController {

    private Integer newAccountId;
    private AccountFactory accountFactory;
    private AccountImpl accountService;

    @Override
    public void init() {
        newAccountId = createAccount();
        super.init();
    }

    private int createAccount() {

        Account newAccount = accountFactory.createAccount(AccountType.CHECKING);
        authServiceImpl.getAccessingCustomer().addAccount(newAccount);
        Account account = accountService.createAccount(newAccount);
        return account.getId();
    }

    public Integer getNewAccountId() {
        return newAccountId;
    }

    public void setAccountService(AccountImpl accountService) {
        this.accountService = accountService;
    }

    public void setAccountFactory(AccountFactory accountFactory) {
        this.accountFactory = accountFactory;
    }
}
