package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.services.AuthServiceImpl;
import org.academiadecodigo.javabank.services.CustomerImpl;
import org.academiadecodigo.javabank.view.View;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class BalanceControllerTest {

    private final static double DOUBLE_DELTA = 0.1;

    private BalanceController balanceController;
    private CustomerImpl customerService;
    private AuthServiceImpl authServiceImpl;
    private Customer customer;
    private View view;

    @Before
    public void setup() {

        balanceController = new BalanceController();
        view = mock(View.class);
        customerService = mock(CustomerImpl.class);
        authServiceImpl = mock(AuthServiceImpl.class);
        customer = mock(Customer.class);

        balanceController.setView(view);
        balanceController.setCustomerService(customerService);
        balanceController.setAuthServiceImpl(authServiceImpl);

    }

    @Test
    public void initTest() {

        balanceController.init();
        verify(view).show();

    }

    @Test
    public void getCustomerBalanceTest() {

        // fake accessing customer
        Integer fakeId = 999;
        double fakeBalance = 20.5;

        when(authServiceImpl.getAccessingCustomer()).thenReturn(customer);
        when(customer.getId()).thenReturn(fakeId);
        when(customerService.getBalance(fakeId)).thenReturn(fakeBalance);

        assertEquals(balanceController.getCustomerBalance(), fakeBalance, DOUBLE_DELTA);

    }

    @Test
    public void getCustomerTest() {

        // fake accessing customer
        when(authServiceImpl.getAccessingCustomer()).thenReturn(customer);

        Customer bCustomer = balanceController.getCustomer();
        assertEquals(bCustomer, customer);
    }
}
