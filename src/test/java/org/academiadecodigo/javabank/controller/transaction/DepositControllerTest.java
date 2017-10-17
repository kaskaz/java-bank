package org.academiadecodigo.javabank.controller.transaction;

import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.services.AccountImpl;
import org.academiadecodigo.javabank.services.AuthServiceImpl;
import org.academiadecodigo.javabank.services.CustomerImpl;
import org.academiadecodigo.javabank.view.View;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class DepositControllerTest {

    private DepositController depositController;
    private AuthServiceImpl authServiceImpl;
    private AccountImpl accountService;
    private CustomerImpl customerService;
    private View view;

    @Before
    public void setup() {

        view = mock(View.class);
        authServiceImpl = mock(AuthServiceImpl.class);
        accountService = mock(AccountImpl.class);
        customerService = mock(CustomerImpl.class);

        depositController = new DepositController();
        depositController.setCustomerService(customerService);
        depositController.setAccountService(accountService);
        depositController.setAuthServiceImpl(authServiceImpl);
        depositController.setView(view);

    }

    @Test
    public void initTest() {

        depositController.init();
        verify(view).show();

    }

    @Test
    public void getAccountIdsTest() {

        // fake customer
        int fakeId = 998;
        Set<Integer> fakeAccountIds = new HashSet<>();
        Customer customer = mock(Customer.class);
        when(authServiceImpl.getAccessingCustomer()).thenReturn(customer);
        when(customer.getId()).thenReturn(fakeId);
        when(customerService.getCustomerAccountIds(fakeId)).thenReturn(fakeAccountIds);

        assertEquals(depositController.getAccountIds(), fakeAccountIds);

    }

    @Test
    public void submitTransactionTest() {

        int fakeId = 999;
        double fakeAmount = 10.5;

        depositController.submitTransaction(fakeId, fakeAmount);

        verify(accountService).deposit(fakeId, fakeAmount);

    }
}
