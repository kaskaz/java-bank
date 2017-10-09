package org.academiadecodigo.javabank.view;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;

public class MenuView {

    private Prompt prompt;
    private MenuInputScanner mainMenu;

    public MenuView() {
        prompt = new Prompt(System.in, System.out);
    }
}
