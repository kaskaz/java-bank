package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.javabank.domain.Bank;
import org.academiadecodigo.javabank.view.View;

public interface Controller {

    void run();
    void setView(View view);

}
