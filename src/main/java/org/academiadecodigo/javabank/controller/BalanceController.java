package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.services.CustomerImpl;

public class BalanceController extends AbstractController {

    CustomerImpl customerService;

    public Customer getCustomer() {
        return authServiceImpl.getAccessingCustomer();
    }

    public double getCustomerBalance() {
        return customerService.getBalance(authServiceImpl.getAccessingCustomer().getId());
    }

    public void setCustomerService(CustomerImpl customerService) {
        this.customerService = customerService;
    }
}
