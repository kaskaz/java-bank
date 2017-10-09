package org.academiadecodigo.javabank.controller;

public class LoginController extends AbstractController{

    private Controller nextController;

    public void setNextController(){
        this.nextController = nextController;
    }

    public void setCustomerId(int customerId){

        bank.setAcessingCustomerId(customerId);
        nextController.run();

    }

}
