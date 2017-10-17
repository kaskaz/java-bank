package org.academiadecodigo.javabank.persistence.managers;

import javax.persistence.EntityManager;

public interface SessionManager<T> {

    void startSession();
    void stopSession();
    T getCurrentSession();

}
