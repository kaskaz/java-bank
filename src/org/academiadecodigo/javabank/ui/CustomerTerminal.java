package org.academiadecodigo.javabank.ui;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.javabank.ui.operations.Operation;

import java.util.List;
import java.util.Set;

public class CustomerTerminal {

    private List<Operation> operations;
    private Operation operation;
    private Prompt prompt;
    private MenuInputScanner scanner;

    public CustomerTerminal(List<Operation> operations){

        this.operations = operations;

        prompt = new Prompt( System.in, System.out);

    }

    public void setOperation(Operation operation){
        this.operation = operation;
    }

    public void doOperation(int context){
        operation.run(context);
    }

    public boolean run(int context){

        int option;

        scanner = new MenuInputScanner( getOptions() );
        scanner.setMessage("Choose an option:");

        option = prompt.getUserInput(scanner)-1;

        if (option == operations.size())
            return false;

        

        // if option == quit return false

        // setOperation(option)
        // doOperation();

        return true;
    }

    private String[] getOptions(){

        int i=0;
        String[] options = new String[operations.size()+1];

        for (Operation operation1 : operations) {
            options[i++] = operation1.description();
        }

        options[i] = "Exit";

        return options;
    }

}
