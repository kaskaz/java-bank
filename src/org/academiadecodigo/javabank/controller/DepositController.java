package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.javabank.domain.Customer;

public class DepositController extends AbstractController {

    public void onDeposit( int accountId, double amount){

        Customer customer = bank.getCustomer( bank.getAcessingCustomerId() );

        if (customer.getAccountIds().contains(accountId)) {
            bank.getAccountManager().deposit(accountId, amount);
        }
    }


}
