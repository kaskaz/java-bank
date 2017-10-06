package org.academiadecodigo.javabank.ui;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.javabank.domain.Bank;
import org.academiadecodigo.javabank.ui.operations.*;

import java.util.Set;

public class BankUserInterface {

    private Bank bank;

    private CustomerTerminal customerTerminal;
    private Set<Operation> operations;

    public BankUserInterface(Bank bank){

        this.bank = bank;

        createOperations();
        customerTerminal = new CustomerTerminal(operations);

    }

    private void createOperations(){

        OpenAccount openAccount = new OpenAccount(bank.getAccountManager());
        operations.add(openAccount);

        CustomerBalance customerBalance = new CustomerBalance();
        operations.add(customerBalance);

        Deposit deposit = new Deposit(bank.getAccountManager());
        operations.add(deposit);

        Withdraw withdraw = new Withdraw(bank.getAccountManager());
        operations.add(withdraw);

        Transfer transfer = new Transfer(bank.getAccountManager());
        operations.add(transfer);

    }

    public boolean run(){

        while( customerTerminal.run() )
            ;

        return true;

    }


}
