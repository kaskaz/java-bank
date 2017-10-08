package org.academiadecodigo.javabank.ui.operations;

import org.academiadecodigo.javabank.domain.Customer;
import org.academiadecodigo.javabank.managers.CustomerManager;

import java.util.Set;

public class CustomerBalance implements Operation {

    private CustomerManager customerManager;

    public CustomerBalance(CustomerManager customerManager){
        this.customerManager = customerManager;
    }

    @Override
    public void run(int context) {

        Customer customer;
        Set<Integer> accounts;

        customer = customerManager.getCustomer(context);
        accounts = customer.getAccountIds();

        if (accounts.isEmpty()){
            System.out.println("No accounts.");
            return;
        }

        System.out.println("Partial balance:");

        for (Integer account : accounts) {
            System.out.println("\t" + account.intValue() + "\t" + customer.getBalance(account) + "\t" + customer.getAccountType(account).name());
        }

        System.out.println("Total balance: " + customer.getBalance());

    }

    @Override
    public String description() {
        return "Balance";
    }

}
