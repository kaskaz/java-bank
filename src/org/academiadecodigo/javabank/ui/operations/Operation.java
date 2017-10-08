package org.academiadecodigo.javabank.ui.operations;

public interface Operation {

    void run(int context);
    String description();

}
