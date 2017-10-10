package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.services.AuthService;
import org.academiadecodigo.javabank.services.CustomerService;

public class BalanceController extends AbstractController {

    private CustomerService customerService;
    private AuthService authService;

    public void setAuthService(AuthService authService) {
        this.authService = authService;
    }

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    public Customer getCustomer(){
        return customerService.getCustomer( authService.getLoginCustomer() );
    }

    public double getCustomerBalance(){
        return customerService.getCustomerBalance( authService.getLoginCustomer() );
    }

}
