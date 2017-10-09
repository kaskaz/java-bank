package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.javabank.view.View;

public class MenuController implements Controller {

    private View view;

    public void setView(View view) {
        this.view = view;
    }

    @Override
    public void run() {
        view.show();
    }

}
