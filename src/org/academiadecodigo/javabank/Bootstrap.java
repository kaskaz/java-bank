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
        Map<Integer, Controller> mapOperationsControllers = buildOperationsControllers();
        Map<Integer, View> mapOperationsViewers = buildOperationsViewers(mapOperationsControllers);

        /**
         * Menu
         */
        MenuController menuController = new MenuController(mapOperationsControllers);
        MenuView menuView = new MenuView(menuController);
        menuController.setView(menuView);


        /**
         * Set bank
         */
        loginView.setBank(bank);
        loginController.setBank(bank);

        loginController.run();

    }

    private Map<Integer, Controller> buildOperationsControllers() {

        Map<Integer, Controller> map = new HashMap<>();

        map.put(UserOptions.GET_BALANCE.getOption(), new BalanceController());
        map.put(UserOptions.DEPOSIT.getOption(), new DepositController());
        map.put(UserOptions.WITHDRAW.getOption(), new WithdrawController());
        map.put(UserOptions.OPEN_ACCOUNT.getOption(), new OpenAccountController());

        return map;

    }

    private Map<Integer, View> buildOperationsViewers(Map<Integer, Controller> map){

        Map<Integer, View> viewers = new HashMap<>();

        viewers.put( UserOptions.GET_BALANCE.getOption(), new BalanceView( map.get(UserOptions.GET_BALANCE.getOption()) ));
        viewers.put( UserOptions.DEPOSIT.getOption(), new DepositView( map.get(UserOptions.DEPOSIT.getOption()) ));
        viewers.put( UserOptions.WITHDRAW.getOption(), new WithdrawView( map.get(UserOptions.WITHDRAW.getOption()) ));
        viewers.put( UserOptions.OPEN_ACCOUNT.getOption(), new OpenAccountView( map.get(UserOptions.OPEN_ACCOUNT.getOption()) ));

        map.get( UserOptions.GET_BALANCE.getOption() ).setView( viewers.get(UserOptions.GET_BALANCE.getOption()) );
        map.get( UserOptions.DEPOSIT.getOption() ).setView( viewers.get(UserOptions.DEPOSIT.getOption()) );
        map.get( UserOptions.WITHDRAW.getOption() ).setView( viewers.get(UserOptions.WITHDRAW.getOption()) );
        map.get( UserOptions.OPEN_ACCOUNT.getOption() ).setView( viewers.get(UserOptions.OPEN_ACCOUNT.getOption()) );

        return viewers;
    }

}


