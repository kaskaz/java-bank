package org.academiadecodigo.javabank.services;

import org.academiadecodigo.javabank.model.Customer;

public interface AuthServiceImpl {

    boolean authenticate(Integer id);

    Customer getAccessingCustomer();

}
