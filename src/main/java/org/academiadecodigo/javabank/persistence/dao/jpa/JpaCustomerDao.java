package org.academiadecodigo.javabank.persistence.dao.jpa;

import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.persistence.dao.CustomerDAO;
import org.academiadecodigo.javabank.persistence.managers.SessionManager;

import javax.persistence.EntityManagerFactory;

public class JpaCustomerDao extends JpaGenericDao<Customer> implements CustomerDAO {

    public JpaCustomerDao(SessionManager sessionManager) {
        super(sessionManager, Customer.class);
    }

}
