package org.academiadecodigo.javabank.ui.operations;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerInputScanner;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.javabank.domain.account.Account;
import org.academiadecodigo.javabank.domain.account.AccountType;
import org.academiadecodigo.javabank.managers.AccountManager;
import org.academiadecodigo.javabank.managers.CustomerManager;

public class OpenAccount implements Operation{

    private AccountManager accountManager;
    private CustomerManager customerManager;
    private String[] options = {"Saving", "Checking", "Cancel"};

    public OpenAccount(AccountManager accountManager, CustomerManager customerManager){
        this.accountManager = accountManager;
        this.customerManager = customerManager;
    }

    @Override
    public void run(int context) {

        AccountType type;

        Prompt prompt = new Prompt( System.in, System.out);
        MenuInputScanner scanner = new MenuInputScanner(options);

        scanner.setMessage("Choose an option:");
        int option = prompt.getUserInput(scanner);

        switch (option){
            case 1:
                type = AccountType.SAVINGS;
                break;

            case 2:
                type = AccountType.CHECKING;
                break;

            default:
                return;
        }

        int accountId = customerManager.getCustomer(context).openAccount(type);
        System.out.println("New " + type.name() + " account with ID " + accountId);

    }

    @Override
    public String description() {
        return "Open a new account";
    }

}
