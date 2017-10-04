package org.academiadecodigo.javabank.domain;

public class AccountCheckings extends Account{

    public AccountCheckings(int id) {
        super(id);
    }

    @Override
    public AccountType getAccountType() {
        return AccountType.CHECKING;
    }
}
