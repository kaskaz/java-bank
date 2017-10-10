package org.academiadecodigo.javabank.view;

import org.academiadecodigo.javabank.application.Messages;
import org.academiadecodigo.javabank.controller.BalanceController;
import org.academiadecodigo.javabank.domain.Customer;
import org.academiadecodigo.javabank.domain.account.Account;

import java.util.Set;

public class BalanceView extends AbstractView {

    private BalanceController controller;

    public BalanceView(BalanceController controller) {
        this.controller = controller;
    }

    @Override
    public void show() {

        Customer customer;
        customer = bank.getCustomer( bank.getAcessingCustomerId() );

        System.out.println("\n" + customer.getName() + Messages.BALANCE_MESSAGE + "\n");

        Set<Account> accounts = customer.getAccounts();
        for (Account account: accounts) {
            System.out.println(account.getId() + "\t" + account.getAccountType() + "\t" + df.format(account.getBalance()));
        }

        System.out.println("\n\n" + Messages.BALANCE_TOTAL_MESSAGE + df.format(customer.getBalance()));

    }
}
