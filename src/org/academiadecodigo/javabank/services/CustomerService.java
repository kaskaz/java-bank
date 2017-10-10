package org.academiadecodigo.javabank.services;

import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.model.account.Account;

import java.util.HashMap;
import java.util.Set;

public class CustomerService {

    private AccountService accountService;
    private HashMap<Integer, Customer> customers;

    public CustomerService() {
        this.customers = new HashMap<>();
    }

    public void addCustomer(Customer customer) {
        customers.put(customer.getId(), customer);
    }

    public Set<Integer> getCustomerIds() {
        return customers.keySet();
    }

    public double getBalance() {

        double balance = 0;

        for (Customer customer : customers.values()) {
            balance += getCustomerBalance(customer.getId());
        }

        return balance;
    }

    public double getCustomerBalance(int id){

        Set<Account> accounts = customers.get(id).getAccounts();

        double balance = 0;
        for (Account account : accounts) {
            balance += account.getBalance();
        }

        return balance;
    }

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    public AccountService getAccountService() {
        return accountService;
    }

    public Customer getCustomer(int id) {
        return customers.get(id);
    }


}
