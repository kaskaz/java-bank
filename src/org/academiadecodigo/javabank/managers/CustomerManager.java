package org.academiadecodigo.javabank.managers;

import org.academiadecodigo.javabank.domain.Customer;

import java.util.HashMap;
import java.util.Map;

public class CustomerManager {

    private Map<Integer,Customer> customerMap;

    public CustomerManager(){
        customerMap = new HashMap<>();
    }

    public void addCustomer(Customer customer){
        customerMap.put( customer.getCustomerId(), customer);
    }

    public Customer getCustomer(int id){
        return customerMap.get(id);
    }
}
