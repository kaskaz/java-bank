package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.javabank.services.CustomerService;
import org.academiadecodigo.javabank.view.Messages;
import org.academiadecodigo.javabank.view.UserOptions;

import java.util.Map;

public class MainController extends AbstractController {

    private Map<Integer, Controller> controllerMap;
    private CustomerService customerService;

    public void setControllerMap(Map<Integer, Controller> controllerMap) {
        this.controllerMap = controllerMap;
    }

    public void onMenuSelection(int option) {

        if (option == UserOptions.QUIT.getOption()) {
            return;
        }

        if (!controllerMap.containsKey(option)) {
            throw new IllegalStateException(Messages.SYSTEM_ERROR);
        }

        controllerMap.get(option).init();
        init();

    }

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    public String getCustomerName(){
        return customerService.getLoginCustomer().getName();
    }

}
