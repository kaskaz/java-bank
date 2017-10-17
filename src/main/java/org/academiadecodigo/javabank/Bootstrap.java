package org.academiadecodigo.javabank;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.javabank.controller.*;
import org.academiadecodigo.javabank.controller.transaction.DepositController;
import org.academiadecodigo.javabank.controller.transaction.WithdrawalController;
import org.academiadecodigo.javabank.factories.AccountFactory;
import org.academiadecodigo.javabank.persistence.managers.SessionManager;
import org.academiadecodigo.javabank.persistence.managers.TransactionManager;
import org.academiadecodigo.javabank.persistence.managers.jpa.JpaSessionManager;
import org.academiadecodigo.javabank.persistence.managers.jpa.JpaTransactionManager;
import org.academiadecodigo.javabank.services.AccountImpl;
import org.academiadecodigo.javabank.services.CustomerImpl;
import org.academiadecodigo.javabank.services.AuthService;
import org.academiadecodigo.javabank.view.*;

import javax.persistence.EntityManagerFactory;
import java.util.HashMap;
import java.util.Map;

public class Bootstrap {

    private AuthService authService;
    private CustomerImpl customerService;
    private AccountImpl accountService;
    private EntityManagerFactory entityManagerFactory;

    public Controller wireObjects() {

        // attach all input to standard i/o
        Prompt prompt = new Prompt(System.in, System.out);

        // wire services
        authService.setCustomerService(customerService);

        // wire login controller and view
        LoginController loginController = new LoginController();
        LoginView loginView = new LoginView();
        loginController.setView(loginView);
        loginController.setAuthServiceImpl(authService);
        loginView.setLoginController(loginController);
        loginView.setPrompt(prompt);

        // wire main controller and view
        MainController mainController = new MainController();
        MainView mainView = new MainView();
        mainView.setPrompt(prompt);
        mainView.setMainController(mainController);
        mainController.setView(mainView);
        mainController.setAuthServiceImpl(authService);
        loginController.setNextController(mainController);

        // wire balance controller and view
        BalanceController balanceController = new BalanceController();
        BalanceView balanceView = new BalanceView();
        balanceView.setBalanceController(balanceController);
        balanceController.setView(balanceView);
        balanceController.setCustomerService(customerService);
        balanceController.setAuthServiceImpl(authService);

        // wire new account controller and view
        NewAccountView newAccountView = new NewAccountView();
        NewAccountController newAccountController = new NewAccountController();
        newAccountController.setAccountService(accountService);
        newAccountController.setAuthServiceImpl(authService);
        newAccountController.setAccountFactory(new AccountFactory());
        newAccountController.setView(newAccountView);
        newAccountView.setNewAccountController(newAccountController);

        // wire account transactions controllers and views
        DepositController depositController = new DepositController();
        WithdrawalController withdrawalController = new WithdrawalController();
        AccountTransactionView depositView = new AccountTransactionView();
        AccountTransactionView withdrawView = new AccountTransactionView();
        depositController.setAuthServiceImpl(authService);
        depositController.setAccountService(accountService);
        depositController.setCustomerService(customerService);
        depositController.setView(depositView);
        withdrawalController.setAuthServiceImpl(authService);
        withdrawalController.setCustomerService(customerService);
        withdrawalController.setAccountService(accountService);
        withdrawalController.setView(withdrawView);
        depositView.setPrompt(prompt);
        depositView.setTransactionController(depositController);
        withdrawView.setPrompt(prompt);
        withdrawView.setTransactionController(withdrawalController);

        // setup the controller map
        Map<Integer, Controller> controllerMap = new HashMap<>();
        controllerMap.put(UserOptions.GET_BALANCE.getOption(), balanceController);
        controllerMap.put(UserOptions.OPEN_ACCOUNT.getOption(), newAccountController);
        controllerMap.put(UserOptions.DEPOSIT.getOption(), depositController);
        controllerMap.put(UserOptions.WITHDRAW.getOption(), withdrawalController);

        mainController.setControllerMap(controllerMap);

        return loginController;
    }

    public void setAuthService(AuthService authService) {
        this.authService = authService;
    }

    public void setCustomerService(CustomerImpl customerService) {
        this.customerService = customerService;
    }

    public void setAccountService(AccountImpl accountService) {
        this.accountService = accountService;
    }


}
