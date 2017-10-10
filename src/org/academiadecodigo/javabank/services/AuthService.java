package org.academiadecodigo.javabank.services;

public class AuthService {

    private CustomerService customerService;
    private int loginCustomer;

    public AuthService(){

    }

    public void setCustomerService(CustomerService customerService){
        this.customerService = customerService;
    }

    public boolean auth(int id){

        boolean isCustomer = customerService.getCustomerIds().contains(id);

        if (isCustomer)
            setLoginCustomer(id);

        return isCustomer;

    }

    public void setLoginCustomer(int id) {
        this.loginCustomer = id;
    }

    public int getLoginCustomer() {
        return loginCustomer;
    }
}
