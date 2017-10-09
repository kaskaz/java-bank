package org.academiadecodigo.javabank.test;

import org.academiadecodigo.javabank.controller.AccountController;
import org.academiadecodigo.javabank.domain.account.Account;
import org.academiadecodigo.javabank.domain.account.AccountType;
import org.academiadecodigo.javabank.factories.AccountFactory;
import org.academiadecodigo.javabank.view.AccountView;

public class TestMVC {

    public static void main(String[] args) {

        TestMVC testMVC = new TestMVC();
        testMVC.test();
    }

    private void test(){

        testAccount();
    //    testCustomerView();
    //    testBankView();


    }

    private void testAccount(){

        AccountFactory accountFactory = new AccountFactory();
        Account model = accountFactory.createAccount(AccountType.CHECKING);

        model.credit(200);

        AccountView view = new AccountView();

        AccountController controller = new AccountController( model, view);

        controller.updateView();



    }
}
