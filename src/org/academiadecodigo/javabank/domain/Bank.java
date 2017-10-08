package org.academiadecodigo.javabank.domain;

import org.academiadecodigo.javabank.managers.AccountManager;
import org.academiadecodigo.javabank.managers.CustomerManager;

import java.util.HashSet;
import java.util.Set;

public class Bank {

    private AccountManager accountManager;
    private CustomerManager customerManager;
    private Set<Customer> customers = new HashSet<>();

    public Bank(AccountManager accountManager, CustomerManager customerManager) {
        this.accountManager = accountManager;
        this.customerManager = customerManager;
    }

    public AccountManager getAccountManager() {
        return accountManager;
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
        customer.setAccountManager(accountManager);
    }

    public double getBalance() {

        double balance = 0;

        for (Customer customer : customers) {
            balance += customer.getBalance();
        }

        return balance;
    }

}
