package org.academiadecodigo.javabank.persistence.managers.jpa;

import org.academiadecodigo.javabank.persistence.managers.SessionManager;
import org.academiadecodigo.javabank.persistence.managers.TransactionManager;

import javax.persistence.EntityManager;

public class JpaTransactionManager implements TransactionManager {

    private SessionManager<EntityManager> sm;

    public JpaTransactionManager(SessionManager sm){
        this.sm = sm;
    }

    public void beginRead() {
        sm.startSession();
    }

    public void beginWrite() {
        sm.getCurrentSession().getTransaction().begin();
    }

    public void commit() {

        if (sm.getCurrentSession().getTransaction().isActive()) {
            sm.getCurrentSession().getTransaction().commit();
        }

        sm.stopSession();
    }

    public void rollback() {

        if (sm.getCurrentSession().getTransaction().isActive()) {
            sm.getCurrentSession().getTransaction().rollback();
        }

        sm.stopSession();
    }
}
