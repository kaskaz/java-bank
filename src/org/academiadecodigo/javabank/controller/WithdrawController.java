package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.javabank.domain.Customer;

public class WithdrawController extends AbstractController {

    public void onWithdraw( int accountId, double amount){

        Customer customer = bank.getCustomer( bank.getAcessingCustomerId() );

        if (customer.getAccountIds().contains(accountId)) {
            bank.getAccountManager().withdraw(accountId, amount);
        }

    }
}
