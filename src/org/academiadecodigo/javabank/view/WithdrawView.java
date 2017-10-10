package org.academiadecodigo.javabank.view;

import org.academiadecodigo.javabank.application.Messages;
import org.academiadecodigo.javabank.controller.WithdrawController;
import org.academiadecodigo.javabank.domain.Customer;

public class WithdrawView extends AbstractView {

    private WithdrawController  controller;

    public WithdrawView(WithdrawController controller) {
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

        controller.onWithdraw( accountId, amount);

    }
}
