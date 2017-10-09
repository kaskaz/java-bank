package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.javabank.domain.Bank;
import org.academiadecodigo.javabank.view.View;

public abstract class AbstractController implements Controller{

    protected View view;
    protected Bank bank;

    @Override
    public void setView(View view) {
        this.view = view;
    }

    @Override
    public void run(){
        view.show();
    }

    public void setBank(Bank bank){
        this.bank = bank;
    }

}
