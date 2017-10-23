package org.academiadecodigo.javabank.services.mock;

import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.model.account.AccountType;
import org.academiadecodigo.javabank.services.AccountService;

import java.util.List;

public class MockAccountService extends AbstractMockService<Account> implements AccountService {

    @Override
    public Integer add(Account account) {

        if (account.getId() == null) {
            account.setId(getNextId());
        }

        modelMap.put(account.getId(), account);

        return account.getId();

    }

    @Override
    public void remove(Integer id) {

    }

    public void deposit(Integer id, double amount) {
        modelMap.get(id).credit(amount);
    }

    public void withdraw(Integer id, double amount) {

        Account account = modelMap.get(id);
        if (account.getAccountType() == AccountType.SAVINGS) {
            return;
        }

        modelMap.get(id).debit(amount);
    }

    public void transfer(Integer srcId, Integer dstId, double amount) {

        Account srcAccount = modelMap.get(srcId);
        Account dstAccount = modelMap.get(dstId);

        // make sure transaction can be performed
        if (srcAccount.canDebit(amount) && dstAccount.canCredit(amount)) {
            srcAccount.debit(amount);
            dstAccount.credit(amount);
        }
    }

    @Override
    public List<Account> getAccounts() {
        return null;
    }

    @Override
    public Account getAccount(Integer id) {
        return null;
    }
}
