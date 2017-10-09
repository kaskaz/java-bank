package org.academiadecodigo.javabank.controller;

import java.util.Map;

public class MenuController extends AbstractController {

    private Map<Integer, Controller> controllersMap;

    public MenuController(Map<Integer, Controller> controllersMap){
        this.controllersMap = controllersMap;
    }

    public void onMenuSelection(int option){
        controllersMap.get(option).run();
    }

}
