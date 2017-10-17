package org.academiadecodigo.javabank.services;

import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.persistence.dao.AccountDAO;
import org.academiadecodigo.javabank.persistence.managers.TransactionManager;
import javax.persistence.RollbackException;

public class AccountService implements AccountImpl {

    private TransactionManager transactionManager;
    private AccountDAO accountDAO;

    public AccountService(TransactionManager transactionManager, AccountDAO accountDAO) {
        this.transactionManager = transactionManager;
        this.accountDAO = accountDAO;
    }

    @Override
    public void deposit(Integer id, double amount) {

        try {

            transactionManager.beginWrite();

            Account account = accountDAO.findById(id);

            if (account == null) {
                throw new IllegalArgumentException("invalid account id");
            }

            account.credit(amount);
            accountDAO.saveOrUpdate(account);

            transactionManager.commit();

        } catch (RollbackException ex) {
            transactionManager.rollback();
        }
    }

    @Override
    public void withdraw(Integer id, double amount) {

        try {

            transactionManager.beginWrite();

            Account account = accountDAO.findById(id);

            if (account == null) {
                throw new IllegalArgumentException("invalid account");
            }

            account.debit(amount);
            accountDAO.saveOrUpdate(account);

            transactionManager.commit();

        } catch (RollbackException ex) {
            transactionManager.rollback();
        }
    }

    @Override
    public void transfer(Integer srcId, Integer dstId, double amount) {

        try {

            transactionManager.beginWrite();

            Account srcAccount = accountDAO.findById(srcId);
            Account dstAccount = accountDAO.findById(dstId);

            if (srcAccount == null || dstAccount == null) {
                throw new IllegalArgumentException("invalid account id");
            }

            // make sure transaction can be performed
            if (srcAccount.canDebit(amount) && dstAccount.canCredit(amount)) {
                srcAccount.debit(amount);
                dstAccount.credit(amount);
            }

            accountDAO.saveOrUpdate(srcAccount);
            accountDAO.saveOrUpdate(dstAccount);

            transactionManager.commit();


        } catch (RollbackException ex) {
            transactionManager.rollback();
        }
    }

    @Override
    public Account createAccount(Account account) {

        transactionManager.beginWrite();

        account = accountDAO.saveOrUpdate(account);

        return account;

    }
}
