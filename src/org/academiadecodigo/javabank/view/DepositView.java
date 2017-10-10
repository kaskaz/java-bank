package org.academiadecodigo.javabank.view;

import org.academiadecodigo.javabank.application.Messages;
import org.academiadecodigo.javabank.controller.DepositController;
import org.academiadecodigo.javabank.domain.Customer;

public class DepositView extends AbstractView {

    private DepositController controller;

    public DepositView(DepositController controller) {
        this.controller = controller;
    }

    @Override
    public void show() {

        Customer customer = bank.getCustomer( bank.getAcessingCustomerId() );

        if ( !hasAccounts() ) {

            System.out.println(Messages.ERROR_NO_ACCOUNT);
            return;

        }

        Integer accountId = scanAccount();
        Double amount = scanAmount();

        controller.onDeposit( accountId, amount);

    }
}
