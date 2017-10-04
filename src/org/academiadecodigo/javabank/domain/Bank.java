package org.academiadecodigo.javabank.domain;

import java.util.HashSet;
import java.util.Set;

public class Bank {

    //private Set<Customer> customers = new HashSet<>();
    //private Set<AccountsManager> accountsManagers = new HashSet<>();
    private AccountsManager accountsManager;

    public Bank() {
        accountsManager = new AccountsManager();
    }

/*    public void addCustomer(Customer customer) {
        customers.add(customer);
    }*/

    public double getBalance() {

        double balance = 0;

        for (Customer customer : customers) {
            balance += customer.getBalance();
        }

        return balance;
    }

}
