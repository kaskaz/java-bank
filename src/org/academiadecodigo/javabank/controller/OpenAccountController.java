package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.javabank.domain.Customer;
import org.academiadecodigo.javabank.domain.account.AccountType;

public class OpenAccountController extends AbstractController {

    private int lastOpenAccount;

    public void onOpenAccount(){

        Customer customer = bank.getCustomer( bank.getAcessingCustomerId() );
        lastOpenAccount = customer.openAccount(AccountType.CHECKING);

    }

    public int getLastOpenAccount() {
        return lastOpenAccount;
    }
}
