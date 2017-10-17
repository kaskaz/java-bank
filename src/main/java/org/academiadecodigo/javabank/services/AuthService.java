package org.academiadecodigo.javabank.services;

import org.academiadecodigo.javabank.model.Customer;

public class AuthService implements AuthServiceImpl {

    private Integer accessingCustomerId;
    private CustomerImpl customerService;

    @Override
    public boolean authenticate(Integer id) {

        Customer customer = customerService.findById(id);

        if (customer == null) {
            return false;
        }

        accessingCustomerId = customer.getId();
        return true;
    }

    @Override
    public Customer getAccessingCustomer() {
        return customerService.findById(accessingCustomerId);
    }

    public void setCustomerService(CustomerImpl customerService) {
        this.customerService = customerService;
    }
}
