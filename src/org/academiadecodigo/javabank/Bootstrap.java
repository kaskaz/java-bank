package org.academiadecodigo.javabank;

import org.academiadecodigo.javabank.controller.LoginController;
import org.academiadecodigo.javabank.domain.Bank;
import org.academiadecodigo.javabank.view.AbstractView;
import org.academiadecodigo.javabank.view.LoginView;
import org.academiadecodigo.javabank.view.View;

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
         * Menu
         */


        /**
         * Set bank
         */
        loginView.setBank(bank);
        loginController.setBank(bank);

        loginController.run();

    }

}


