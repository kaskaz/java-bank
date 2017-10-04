package org.academiadecodigo.javabank.domain;

public class AccountSavings extends Account{

    public AccountSavings(int id) {
        super(id);
    }

    @Override
    public AccountType getAccountType() {
        return AccountType.SAVINGS;
    }
}
