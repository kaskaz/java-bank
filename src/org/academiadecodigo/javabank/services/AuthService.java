package org.academiadecodigo.javabank.services;

public class AuthService {

    private CustomerService customerService;

    public AuthService(){

    }

    public void setCustomerService(CustomerService customerService){
        this.customerService = customerService;
    }

    public boolean auth(int id){

        boolean isCustomer = customerService.getCustomerIds().contains(id);

        if (isCustomer)
            customerService.setLoginCustomer(id);

        return isCustomer;

    }

}
