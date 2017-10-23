package org.academiadecodigo.javabank.services;

import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.model.account.Account;

import java.util.List;
import java.util.Set;

public interface CustomerService {

    Integer add(Customer customer);

    void remove(Integer id);

    Customer findById(Integer id);

    double getBalance(Integer id);

    Set<Integer> getCustomerAccountIds(Integer id);

    List<Customer> getCustomers();
}
