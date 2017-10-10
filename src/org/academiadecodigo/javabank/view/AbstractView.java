package org.academiadecodigo.javabank.view;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerSetInputScanner;
import org.academiadecodigo.bootcamp.scanners.precisiondouble.DoubleInputScanner;
import org.academiadecodigo.javabank.application.Messages;
import org.academiadecodigo.javabank.domain.Bank;
import org.academiadecodigo.javabank.domain.Customer;

import java.text.DecimalFormat;

public abstract class AbstractView implements View{

    protected Prompt prompt;
    protected Bank bank;

    DecimalFormat df = new DecimalFormat("#.##");

    public AbstractView() {
        prompt = new Prompt( System.in, System.out);
    }

    public void setBank(Bank bank){
        this.bank = bank;
    }

    protected int scanAccount() {

        Customer customer = bank.getCustomer( bank.getAcessingCustomerId() );

        IntegerSetInputScanner scanner = new IntegerSetInputScanner(customer.getAccountIds());
        scanner.setMessage(Messages.CHOOSE_ACCOUNT);
        scanner.setError(Messages.ERROR_INVALID_ACCOUNT);

        return prompt.getUserInput(scanner);

    }

    protected double scanAmount() {
        DoubleInputScanner scanner = new DoubleInputScanner();
        scanner.setMessage(Messages.CHOOSE_AMOUNT);
        scanner.setError(Messages.ERROR_INVALID_AMOUNT);

        return prompt.getUserInput(scanner);
    }

    protected boolean hasAccounts() {
        return !bank.getCustomer( bank.getAcessingCustomerId() ).getAccountIds().isEmpty();
    }

}
