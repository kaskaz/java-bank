package org.academiadecodigo.javabank.services;

import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.persistence.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Autowired
    private CustomerService customerService;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Transactional
    @Override
    public Integer add(Account account) {
        return accountDao.saveOrUpdate(account).getId();
    }

    @Transactional
    @Override
    public void remove(Integer id) {

        /**
         * Edited: remove account from customer before delete account
         */
        Account account = accountDao.findById(id);
        Customer customer = account.getCustomer();

        customer.removeAccount(account);
        customerService.add(customer);
        /**********/

        accountDao.delete(id);
    }

    @Transactional
    @Override
    public void deposit(Integer id, double amount) {

        Account account = accountDao.findById(id);

        if (account == null) {
            throw new IllegalArgumentException("invalid account id");
        }

        account.credit(amount);

        accountDao.saveOrUpdate(account);
    }

    @Transactional
    @Override
    public void withdraw(Integer id, double amount) {

        Account account = accountDao.findById(id);

        if (account == null) {
            throw new IllegalArgumentException("invalid account id");
        }

        account.debit(amount);

        accountDao.saveOrUpdate(account);

    }

    @Transactional
    @Override
    public void transfer(Integer srcId, Integer dstId, double amount) {

        Account srcAccount = accountDao.findById(srcId);
        Account dstAccount = accountDao.findById(dstId);

        if (srcAccount == null || dstAccount == null) {
            throw new IllegalArgumentException("invalid account id");
        }

        // make sure transaction can be performed
        if (srcAccount.canDebit(amount) && dstAccount.canCredit(amount)) {
            srcAccount.debit(amount);
            dstAccount.credit(amount);
        }

        accountDao.saveOrUpdate(srcAccount);
        accountDao.saveOrUpdate(dstAccount);

    }

    @Override
    public List<Account> getAccounts(){

        List<Account> accounts = accountDao.findAll();

        if (accounts == null) {
            throw new IllegalArgumentException("No accounts.");
        }

        return accounts;
    }

    @Override
    public Account getAccount(Integer id) {

        Account account = accountDao.findById(id);

        if (account == null) {
            throw new IllegalArgumentException("No account with ID " + id);
        }

        return account;
    }
}


