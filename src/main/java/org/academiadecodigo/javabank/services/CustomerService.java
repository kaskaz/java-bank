package org.academiadecodigo.javabank.services;

import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.persistence.dao.CustomerDAO;
import org.academiadecodigo.javabank.persistence.dao.jpa.JpaGenericDao;
import org.academiadecodigo.javabank.persistence.managers.TransactionManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CustomerService implements CustomerImpl {

    private TransactionManager transactionManager;
    private CustomerDAO customerDAO;

    public CustomerService(TransactionManager transactionManager, CustomerDAO customerDAO) {
        this.transactionManager = transactionManager;
        this.customerDAO = customerDAO;
    }

    @Override
    public double getBalance(Integer id) {

        transactionManager.beginRead();

        Customer customer = customerDAO.findById(id);

        if (customer == null) {
            throw new IllegalArgumentException("Customer does not exists");
        }

        List<Account> accounts = customer.getAccounts();

        double balance = 0;
        for (Account account : accounts) {
            balance += account.getBalance();
        }

        return balance;

    }

    @Override
    public Set<Integer> getCustomerAccountIds(Integer id) {

        transactionManager.beginRead();

        Set<Integer> accountIds = new HashSet<>();

        Customer customer = customerDAO.findById(id);

        if (customer == null) {
            throw new IllegalArgumentException("Customer does not exists");
        }

        List<Account> accounts = customer.getAccounts();

        for (Account account : accounts) {
            accountIds.add(account.getId());
        }

        return accountIds;

    }

    @Override
    public Customer findById(Integer id) {

        transactionManager.beginRead();

        Customer customer = customerDAO.findById(id);

        if (customer == null) {
            throw new IllegalArgumentException("Customer does not exists");
        }

        return customer;

    }
}
