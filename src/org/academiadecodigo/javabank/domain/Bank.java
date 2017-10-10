package org.academiadecodigo.javabank.domain;

import org.academiadecodigo.javabank.managers.AccountManager;

import java.util.HashMap;
import java.util.Set;

public class Bank {

    private AccountManager accountManager;
    private HashMap<Integer, Customer> customers;

    private int acessingCustomerId;

    public Bank() {
        this.customers = new HashMap<>();
    }

    public void addCustomer(Customer customer) {
        customers.put(customer.getId(), customer);
        customer.setAccountManager(accountManager);
    }

    public Customer getCustomer(int id) {
        return customers.get(id);
    }

    public Set<Integer> getCustomerIds() {
        return customers.keySet();
    }

    public double getBalance() {

        double balance = 0;

        for (Customer customer : customers.values()) {
            balance += customer.getBalance();
        }

        return balance;
    }

    public void setAccountManager(AccountManager accountManager) {
        this.accountManager = accountManager;
    }

    public AccountManager getAccountManager() {
        return accountManager;
    }

    public void setAcessingCustomerId(int acessingCustomerId) {
        this.acessingCustomerId = acessingCustomerId;
    }

    public int getAcessingCustomerId() {
        return acessingCustomerId;
    }
}
