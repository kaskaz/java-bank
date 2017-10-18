package org.academiadecodigo.javabank.persistence.managers;

public interface SessionManager<T> {

    void startSession();

    void stopSession();

    T getCurrentSession();

}
