//package org.academiadecodigo.javabank;

import controller.LoginController;
import persistance.AccountServicePersistance;
import persistance.CustomerServicePersistance;
import persistance.H2WebServer;
import services.AccountServiceImpl;
import services.AuthServiceImpl;
import services.CustomerServiceImpl;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.SQLException;


public class App {

    public static void main(String[] args) {

        try {
            H2WebServer h2WebServer = new H2WebServer();
            h2WebServer.start();

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");

            App app = new App();
            app.bootStrap(emf);

            emf.close();
            h2WebServer.stop();
        }catch (SQLException e){
            e.printStackTrace();
        }



    }

    private void bootStrap(EntityManagerFactory emf) {

        Bootstrap bootstrap = new Bootstrap();
        bootstrap.setAuthService(new AuthServiceImpl());
        bootstrap.setAccountService(new AccountServicePersistance(emf));
        bootstrap.setCustomerService(new CustomerServicePersistance(emf));
        bootstrap.loadCustomers();

        LoginController loginController = bootstrap.wireObjects();

        // start application
        loginController.init();



    }
}
