package org.academiadecodigo.javabank.controller.transaction;

import org.academiadecodigo.javabank.controller.AbstractController;
import org.academiadecodigo.javabank.services.AccountImpl;
import org.academiadecodigo.javabank.services.CustomerImpl;

import java.util.Set;

public abstract class AbstractAccountTransactionController extends AbstractController implements AccountTransactionController {

    AccountImpl accountService;
    CustomerImpl customerService;

    public Set<Integer> getAccountIds() {
        return customerService.getCustomerAccountIds(authServiceImpl.getAccessingCustomer().getId());
    }

    public void setAccountService(AccountImpl accountService) {
        this.accountService = accountService;
    }

    public void setCustomerService(CustomerImpl customerService) {
        this.customerService = customerService;
    }
}
