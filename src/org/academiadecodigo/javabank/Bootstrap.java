package org.academiadecodigo.javabank;

import org.academiadecodigo.javabank.application.UserOptions;
import org.academiadecodigo.javabank.application.operations.BalanceOperation;
import org.academiadecodigo.javabank.application.operations.NewAccountOperation;
import org.academiadecodigo.javabank.application.operations.Operation;
import org.academiadecodigo.javabank.application.operations.transaction.DepositOperation;
import org.academiadecodigo.javabank.application.operations.transaction.WithdrawOperation;
import org.academiadecodigo.javabank.controller.Controller;
import org.academiadecodigo.javabank.controller.LoginController;
import org.academiadecodigo.javabank.controller.MenuController;
import org.academiadecodigo.javabank.domain.Bank;
import org.academiadecodigo.javabank.view.AbstractView;
import org.academiadecodigo.javabank.view.LoginView;
import org.academiadecodigo.javabank.view.MenuView;
import org.academiadecodigo.javabank.view.View;

import java.util.HashMap;
import java.util.Map;

public class Bootstrap {

    LoginController loginController;

    public void start() {

        Bank bank = new Bank();

        /**
         * Login
         */
        loginController = new LoginController();
        LoginView loginView = new LoginView(loginController);
        loginController.setView(loginView);

        /**
         * Operations
         */
        Map<Integer, Controller> map = buildOperationsMap();

        /**
         * Menu
         */
        MenuController menuController = new MenuController(map);
        MenuView menuView = new MenuView(menuController);
        menuController.setView(menuView);


        /**
         * Set bank
         */
        loginView.setBank(bank);
        loginController.setBank(bank);

        loginController.run();

    }

    private Map<Integer, Controller> buildOperationsMap() {

        Map<Integer, Controller> map = new HashMap<>();
        map.put(UserOptions.GET_BALANCE.getOption(), new BalanceOperation(this));
        map.put(UserOptions.DEPOSIT.getOption(), new DepositOperation(this));
        map.put(UserOptions.WITHDRAW.getOption(), new WithdrawOperation(this));
        map.put(UserOptions.OPEN_ACCOUNT.getOption(), new NewAccountOperation(this));

        return map;

    }

}


