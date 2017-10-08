package org.academiadecodigo.javabank.ui.operations;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerSetInputScanner;
import org.academiadecodigo.bootcamp.scanners.precisiondouble.DoubleInputScanner;
import org.academiadecodigo.javabank.managers.AccountManager;
import org.academiadecodigo.javabank.managers.CustomerManager;

import java.util.Set;

public class Deposit implements Operation {

    private AccountManager accountManager;
    private CustomerManager customerManager;

    public Deposit(AccountManager accountManager, CustomerManager customerManager){
        this.accountManager = accountManager;
        this.customerManager = customerManager;
    }

    @Override
    public void run(int context) {

        Set<Integer> accounts = customerManager.getCustomer(context).getAccountIds();

        if (accounts.isEmpty()){
            System.out.println("No accounts.");
            return;
        }

        Prompt prompt = new Prompt( System.in, System.out);
        IntegerSetInputScanner scannerAccount = new IntegerSetInputScanner(accounts);
        DoubleInputScanner scannerAmount = new DoubleInputScanner();

        scannerAccount.setMessage("Introduce an account ID: ");
        int accountId = prompt.getUserInput(scannerAccount);

        scannerAmount.setMessage("Introduce an amount: ");
        double amount = prompt.getUserInput(scannerAmount);

        accountManager.deposit( accountId, amount);

    }

    @Override
    public String description() {
        return "Deposit";
    }

}
