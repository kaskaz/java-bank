package org.academiadecodigo.javabank.view;

import org.academiadecodigo.javabank.application.Messages;
import org.academiadecodigo.javabank.controller.OpenAccountController;
import org.academiadecodigo.javabank.domain.Customer;
import org.academiadecodigo.javabank.domain.account.AccountType;

public class OpenAccountView extends AbstractView {

    private OpenAccountController controller;

    public OpenAccountView(OpenAccountController controller) {
        this.controller = controller;
    }

    @Override
    public void show() {

        controller.onOpenAccount();

        int accountId = controller.getLastOpenAccount();

        System.out.println("\n" + Messages.CREATED_ACCOUNT + bank.getCustomer( bank.getAcessingCustomerId() ).getName() + " : " + accountId);

    }


}
