package org.academiadecodigo.javabank.persistence.dao.jpa;

import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.persistence.dao.AccountDAO;
import org.academiadecodigo.javabank.persistence.managers.SessionManager;

public class JpaAccountDao extends JpaGenericDao<Account> implements AccountDAO {

    public JpaAccountDao(SessionManager sessionManager) {
        super(sessionManager, Account.class);
    }
}
