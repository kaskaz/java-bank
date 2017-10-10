package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.javabank.services.AuthService;
import org.academiadecodigo.javabank.services.CustomerService;
import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.model.account.AccountType;

public class NewAccountController extends AbstractController {

    private CustomerService customerService;
    private AuthService authService;
    private Integer newAccountId;

    @Override
    public void init() {

        newAccountId = createAccount();
        super.init();
    }

    private int createAccount() {

        Account newAccount = customerService.getAccountService().openAccount(AccountType.CHECKING);
        customerService.getCustomer( authService.getLoginCustomer() ).addAccount(newAccount);

        return newAccount.getId();
    }

    public Integer getNewAccountId() {
        return newAccountId;
    }

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    public void setAuthService(AuthService authService) {
        this.authService = authService;
    }
}
