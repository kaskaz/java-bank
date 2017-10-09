package org.academiadecodigo.javabank.view;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.javabank.domain.Bank;

public abstract class AbstractView implements View{

    protected Prompt prompt;
    protected Bank bank;

    public AbstractView() {
        prompt = new Prompt( System.in, System.out);
    }

    public void setBank(Bank bank){
        this.bank = bank;
    }

}
