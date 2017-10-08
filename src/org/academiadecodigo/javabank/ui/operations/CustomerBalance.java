package org.academiadecodigo.javabank.ui.operations;

public class CustomerBalance implements Operation {

    public CustomerBalance(){

    }

    @Override
    public void run(int context) {
        System.out.println(description());
    }

    @Override
    public String description() {
        return "Balance";
    }

}
