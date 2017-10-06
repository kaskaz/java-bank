package org.academiadecodigo.javabank.domain.account;

public class AccountFactory {

    public Account create( int id, AccountType type){

        switch (type){
            case SAVINGS:
                return new SavingsAccount(id);

            default:
                return new CheckingAccount(id);
        }

    }

}
