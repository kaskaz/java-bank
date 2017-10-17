package org.academiadecodigo.javabank;

import org.academiadecodigo.javabank.controller.Controller;
import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.persistence.H2WebServer;
import org.academiadecodigo.javabank.persistence.dao.AccountDAO;
import org.academiadecodigo.javabank.persistence.dao.CustomerDAO;
import org.academiadecodigo.javabank.persistence.dao.jpa.JpaAccountDao;
import org.academiadecodigo.javabank.persistence.dao.jpa.JpaCustomerDao;
import org.academiadecodigo.javabank.persistence.managers.SessionManager;
import org.academiadecodigo.javabank.persistence.managers.TransactionManager;
import org.academiadecodigo.javabank.persistence.managers.jpa.JpaSessionManager;
import org.academiadecodigo.javabank.persistence.managers.jpa.JpaTransactionManager;
import org.academiadecodigo.javabank.services.AccountService;
import org.academiadecodigo.javabank.services.CustomerService;
import org.academiadecodigo.javabank.services.AuthService;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.SQLException;

public class App {

    public static void main(String[] args) {

        try {


            H2WebServer h2WebServer = new H2WebServer();
            h2WebServer.start();

            EntityManagerFactory emf = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT);

            App app = new App();
            app.bootStrap(emf);

            emf.close();
            h2WebServer.stop();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void bootStrap(EntityManagerFactory emf) {

        Bootstrap bootstrap = new Bootstrap();

        // setup session manager
        SessionManager sessionManager = new JpaSessionManager(emf);

        // setup transaction manager
        TransactionManager transactionManager = new JpaTransactionManager(sessionManager);

        // setup DAOs
        AccountDAO accountDAO = new JpaAccountDao(sessionManager);
        CustomerDAO customerDAO = new JpaCustomerDao(sessionManager);

        // setup customers
        createCustomers(transactionManager,customerDAO);


        bootstrap.setAuthService(new AuthService());
        bootstrap.setAccountService(new AccountService(transactionManager,accountDAO));
        bootstrap.setCustomerService(new CustomerService(transactionManager,customerDAO));

        Controller controller = bootstrap.wireObjects();

        // start application
        controller.init();

    }

    private void createCustomers(TransactionManager transactionManager, CustomerDAO customerDAO) {

        Customer customer = new Customer();
        customer.setName("Nuno");

        Customer customer1 = new Customer();
        customer1.setName("Cascalho");

        transactionManager.beginWrite();
        customerDAO.saveOrUpdate(customer);
        customerDAO.saveOrUpdate(customer1);
        transactionManager.commit();

    }
}
