package org.academiadecodigo.javabank.ui;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.javabank.ui.operations.Operation;

import java.util.Set;

public class CustomerTerminal {

    private Set<Operation> operations;
    private Operation operation;
    private Prompt prompt;

    public CustomerTerminal(Set<Operation> operations){

        this.operations = operations;

        prompt = new Prompt( System.in, System.out);

    }

    public void setOperation(Operation operation){
        this.operation = operation;
    }

    public void doOperation(){
        operation.run();
    }

    public boolean run(){

        int op = 1;

        System.out.println("Choose an option below:");

        // Display Menu and grab user option
        for (Operation operation1 : operations)
            System.out.println(op + " - " + operation1.description());


        return false;

        // if option == quit return false

        // setOperation(option)
        // doOperation();

       // return true;
    }

}
