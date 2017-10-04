package org.academiadecodigo.javabank.test;

import org.academiadecodigo.javabank.domain.*;

public class AccountsManagerTest {

    public boolean test(){

        AccountsManager manager = new AccountsManager();
        Customer customer1 = new Customer();
        Customer customer2 = new Customer();

        // customer should start with zero balance
        if (customer1.getBalance() != 0) {
            return false;
        }

        Account a1 = new AccountCheckings(1);
        Account a2 = new AccountSavings(2);
        Account a3 = new AccountSavings(3);
        a1.credit(100);
        a2.credit(120);

        // customer balance should equal sum of all accounts balance
        customer1.addAccount(a1);
        customer1.addAccount(a2);
        if (customer1.getBalance() != 220) {
            return false;
        }

        customer1.addAccount(a1);
        customer1.addAccount(a2);
        customer2.addAccount(a3);

        manager.addAccount(a2);
        manager.addAccount(a1);
        manager.addAccount(a3);

        // customer must keep a min balance on savings account
        manager.transfer(a2.getId(), a1.getId(), 30);
        if (a2.getBalance() != 120) {
            return false;
        }

        // customer must be able to perform transfers between accounts
        manager.transfer(a2.getId(), a1.getId(), 20);
        if (a2.getBalance() != 100 || a1.getBalance() != 120) {
            return false;
        }

        // customer can not withdraw from savings account
        manager.withdraw(2, 1);
        if (a2.getBalance() != 100) {
            return false;
        }

        manager.transfer(a1.getId(),a3.getId(),20);
        if (a1.getBalance() != 100 || a3.getBalance() != 20){
            return false;
        }

        if (customer1.getBalance() != 200 || customer2.getBalance() != 20) {
            return false;
        }

        return true;

    }


}
