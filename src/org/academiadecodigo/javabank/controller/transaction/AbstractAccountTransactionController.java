package org.academiadecodigo.javabank.controller.transaction;

import org.academiadecodigo.javabank.controller.AbstractController;
import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.services.AuthService;
import org.academiadecodigo.javabank.services.CustomerService;

import java.util.Set;

public abstract class AbstractAccountTransactionController extends AbstractController implements AccountTransactionController {

    protected CustomerService customerService;
    protected AuthService authService;

    public void setAuthService(AuthService authService) {
        this.authService = authService;
    }

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public Set<Integer> getCustomerAccountIds(){
        return customerService.getCustomer( authService.getLoginCustomer() ).getAccountIds();
    }

}
