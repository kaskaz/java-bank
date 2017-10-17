package org.academiadecodigo.javabank.persistence.managers;

public interface TransactionManager {

    void beginRead();
    void beginWrite();
    void commit();
    void rollback();

}
