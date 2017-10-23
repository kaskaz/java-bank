package org.academiadecodigo.javabank.services;

import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.model.account.Account;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface AccountService {

    Integer add(Account account);

    void remove(Integer id);

    void deposit(Integer id, double amount);

    void withdraw(Integer id, double amount);

    void transfer(Integer srcId, Integer dstId, double amount);

    List<Account> getAccounts();

    Account getAccount(Integer id);

}
