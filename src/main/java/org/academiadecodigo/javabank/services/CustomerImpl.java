package org.academiadecodigo.javabank.services;

import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.persistence.dao.DAO;

import java.util.Set;

public interface CustomerImpl {

    double getBalance(Integer id);

    Set<Integer> getCustomerAccountIds(Integer id);

    Customer findById(Integer id);

}
