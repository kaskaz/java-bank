package org.academiadecodigo.javabank.test;

import org.academiadecodigo.javabank.domain.Bank;
import org.academiadecodigo.javabank.domain.Customer;
import org.academiadecodigo.javabank.managers.AccountManager;
import org.academiadecodigo.javabank.managers.CustomerManager;
import org.academiadecodigo.javabank.ui.BankUserInterface;

public class BankUserInterfaceTest {

    public boolean test(){

        CustomerManager customerManager = new CustomerManager();
        AccountManager accountManager = new AccountManager();
        Bank bank = new Bank( accountManager, customerManager);

        Customer customer = customerManager.CustomerFactory();
        customer.setAccountManager(accountManager);

        BankUserInterface bankUserInterface = new BankUserInterface(bank);
        bankUserInterface.run();

        return true;

    }

}
