package org.academiadecodigo.javabank;

import org.academiadecodigo.javabank.application.UserOptions;
import org.academiadecodigo.javabank.controller.*;
import org.academiadecodigo.javabank.domain.Bank;
import org.academiadecodigo.javabank.view.*;

import java.util.HashMap;
import java.util.Map;

public class Bootstrap {

    LoginController loginController;

    public void start(Bank bank) {

        /**
         * Operations
         */
        Map<Integer, Controller> mapOperationsControllers = buildOperationsControllers(bank);
        Map<Integer, View> mapOperationsViewers = buildOperationsViewers(mapOperationsControllers, bank);

        /**
         * Menu
         */
        MenuController menuController = new MenuController(mapOperationsControllers);
        MenuView menuView = new MenuView(menuController);
        menuController.setView(menuView);

        /**
         * Login
         */
        loginController = new LoginController();
        LoginView loginView = new LoginView(loginController);
        loginController.setView(loginView);
        loginController.setNextController(menuController);


        /**
         * Set bank
         */
        loginView.setBank(bank);
        loginController.setBank(bank);
        menuView.setBank(bank);
        menuController.setBank(bank);


        loginController.run();

    }

    private Map<Integer, Controller> buildOperationsControllers(Bank bank) {

        Map<Integer, Controller> map = new HashMap<>();

        map.put(UserOptions.GET_BALANCE.getOption(),    new BalanceController());
        map.put(UserOptions.DEPOSIT.getOption(),        new DepositController());
        map.put(UserOptions.WITHDRAW.getOption(),       new WithdrawController());
        map.put(UserOptions.OPEN_ACCOUNT.getOption(),   new OpenAccountController());

        ((AbstractController)map.get(UserOptions.GET_BALANCE.getOption() )).setBank(bank);
        ((AbstractController)map.get(UserOptions.DEPOSIT.getOption()     )).setBank(bank);
        ((AbstractController)map.get(UserOptions.WITHDRAW.getOption()    )).setBank(bank);
        ((AbstractController)map.get(UserOptions.OPEN_ACCOUNT.getOption())).setBank(bank);

        return map;

    }

    private Map<Integer, View> buildOperationsViewers(Map<Integer, Controller> map, Bank bank){

        Map<Integer, View> viewers = new HashMap<>();

        viewers.put( UserOptions.GET_BALANCE.getOption(),   new BalanceView( (BalanceController) map.get(UserOptions.GET_BALANCE.getOption()) ));
        viewers.put( UserOptions.DEPOSIT.getOption(),       new DepositView( (DepositController) map.get(UserOptions.DEPOSIT.getOption()) ));
        viewers.put( UserOptions.WITHDRAW.getOption(),      new WithdrawView( (WithdrawController) map.get(UserOptions.WITHDRAW.getOption()) ));
        viewers.put( UserOptions.OPEN_ACCOUNT.getOption(),  new OpenAccountView( (OpenAccountController) map.get(UserOptions.OPEN_ACCOUNT.getOption()) ));

        map.get( UserOptions.GET_BALANCE.getOption()    ).setView( viewers.get(UserOptions.GET_BALANCE.getOption()) );
        map.get( UserOptions.DEPOSIT.getOption()        ).setView( viewers.get(UserOptions.DEPOSIT.getOption()) );
        map.get( UserOptions.WITHDRAW.getOption()       ).setView( viewers.get(UserOptions.WITHDRAW.getOption()) );
        map.get( UserOptions.OPEN_ACCOUNT.getOption()   ).setView( viewers.get(UserOptions.OPEN_ACCOUNT.getOption()) );

        ((AbstractView)viewers.get( UserOptions.GET_BALANCE.getOption() )).setBank(bank);
        ((AbstractView)viewers.get( UserOptions.DEPOSIT.getOption()     )).setBank(bank);
        ((AbstractView)viewers.get( UserOptions.WITHDRAW.getOption()    )).setBank(bank);
        ((AbstractView)viewers.get( UserOptions.OPEN_ACCOUNT.getOption())).setBank(bank);

        return viewers;
    }

}


