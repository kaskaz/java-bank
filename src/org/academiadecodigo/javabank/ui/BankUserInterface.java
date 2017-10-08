package org.academiadecodigo.javabank.ui;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.javabank.domain.Bank;
import org.academiadecodigo.javabank.ui.operations.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BankUserInterface {

    private Bank bank;

    private CustomerTerminal customerTerminal;
    private List<Operation> operations;

    public BankUserInterface(Bank bank){

        this.bank = bank;

        createOperations();
        customerTerminal = new CustomerTerminal(operations);

    }

    private void createOperations(){

        operations = new ArrayList<>();

        operations.add( new OpenAccount(bank.getAccountManager(), bank.getCustomerManager()) );
        operations.add( new CustomerBalance(bank.getCustomerManager()) );
        operations.add( new Deposit(bank.getAccountManager()) );
        operations.add( new Withdraw(bank.getAccountManager()) );
        operations.add( new Transfer(bank.getAccountManager()) );

    }

    public boolean run(){

        while( customerTerminal.run(4) )
            ;

        return true;

    }


}
