package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.javabank.application.UserOptions;

import java.util.Map;

public class MenuController extends AbstractController {

    private Map<Integer, Controller> controllersMap;

    public MenuController(Map<Integer, Controller> controllersMap){
        this.controllersMap = controllersMap;
    }

    public void onMenuSelection(int option){

        if (option == UserOptions.QUIT.getOption())
            return;

        controllersMap.get(option).run();
        run();
    }

}
