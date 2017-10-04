package org.academiadecodigo.javabank.test;

import org.academiadecodigo.javabank.domain.AccountsManager;

public class Test {

    public static void main(String[] args) {

        AccountTest accountTest = new AccountTest();
        CustomerTest customerTest = new CustomerTest();
        BankTest bankTest = new BankTest();
        AccountsManagerTest accountsManagerTest = new AccountsManagerTest();

        System.out.println("Account: " + (accountTest.test() ? "OK" : "FAIL"));
        System.out.println("Customer: " + (customerTest.test() ? "OK" : "FAIL"));
        System.out.println("Bank: " + (bankTest.test() ? "OK" : "FAIL"));
        System.out.println("Accounts Manager: " + (accountsManagerTest.test() ? "OK" : "FAIL"));


    }


}
