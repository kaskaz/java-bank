package org.academiadecodigo.javabank.view;

import org.academiadecodigo.javabank.application.Messages;
import org.academiadecodigo.javabank.domain.Bank;
import org.academiadecodigo.javabank.domain.Customer;
import org.academiadecodigo.javabank.domain.account.Account;

import java.text.DecimalFormat;
import java.util.Set;

public class BalanceOperationView implements View{

    private Customer customer;

    DecimalFormat df = new DecimalFormat("#.##");

    public void setCustomer(Customer customer){
        this.customer = customer;
    }

    @Override
    public void show() {

        System.out.println("\n" + customer.getName() + Messages.BALANCE_MESSAGE + "\n");

        Set<Account> accounts = customer.getAccounts();
        for (Account account: accounts) {
            System.out.println(account.getId() + "\t" + account.getAccountType() + "\t" + df.format(account.getBalance()));
        }

        System.out.println("\n\n" + Messages.BALANCE_TOTAL_MESSAGE + df.format(customer.getBalance()));

    }

    @Override
    public void setBank(Bank bank) {

    }
}
