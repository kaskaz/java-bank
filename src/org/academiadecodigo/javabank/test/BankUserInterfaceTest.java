package org.academiadecodigo.javabank.test;

import org.academiadecodigo.javabank.domain.Bank;
import org.academiadecodigo.javabank.domain.Customer;
import org.academiadecodigo.javabank.managers.AccountManager;
import org.academiadecodigo.javabank.ui.BankUserInterface;

public class BankUserInterfaceTest {

    public boolean test(){

        AccountManager accountManager = new AccountManager();
        Bank bank = new Bank(accountManager);

        Customer customer = new Customer();
        customer.setAccountManager(accountManager);

        BankUserInterface bankUserInterface = new BankUserInterface(bank);
        bankUserInterface.run();

        return true;

    }

}
