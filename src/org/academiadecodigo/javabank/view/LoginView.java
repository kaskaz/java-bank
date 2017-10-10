package org.academiadecodigo.javabank.view;

import org.academiadecodigo.bootcamp.scanners.integer.IntegerSetInputScanner;
import org.academiadecodigo.javabank.application.Messages;
import org.academiadecodigo.javabank.controller.LoginController;

public class LoginView extends AbstractView{

    private LoginController loginController;

    public LoginView(LoginController loginController) {
        super();
        this.loginController = loginController;
    }

    @Override
    public void show() {

        IntegerSetInputScanner scanner = new IntegerSetInputScanner(bank.getCustomerIds());

        scanner.setMessage(Messages.CHOOSE_CUSTOMER);
        scanner.setError(Messages.ERROR_INVALID_CUSTOMER);

        loginController.onCustomerLogin( prompt.getUserInput(scanner) );

    }

}
