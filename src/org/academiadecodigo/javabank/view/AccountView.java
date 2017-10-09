package org.academiadecodigo.javabank.view;

public class AccountView {

    public void updateView( int accountId, double accountBalance, String accountType) {
        System.out.println("ID: " + accountId + "\tType: " + accountType + "\t\tBalance: " + accountBalance + "€");
    }

}
