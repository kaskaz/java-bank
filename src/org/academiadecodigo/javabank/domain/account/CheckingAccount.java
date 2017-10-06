package org.academiadecodigo.javabank.domain.account;

public class CheckingAccount extends Account {

    public CheckingAccount(int id) {
        super(id);
    }

    public CheckingAccount CheckingAccountFactory(int id){
        return new CheckingAccount(id);
    }

    @Override
    public AccountType getAccountType() {
        return AccountType.CHECKING;
    }
}
