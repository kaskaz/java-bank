package org.academiadecodigo.javabank.controller;

public class LoginController extends AbstractController {

    private Controller nextController;

    public void setNextController( MenuController nextController){
        this.nextController = nextController;
    }

    public void onCustomerLogin(int customerId){

        bank.setAcessingCustomerId(customerId);
        nextController.run();

    }

}
