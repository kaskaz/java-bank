package services;

import model.Customer;

import java.util.List;
import java.util.Set;

public interface CustomerService {

    Customer add(Customer customer);

    Customer findById(Integer id);

    List<Customer> findAll();

    Set<Integer> getCustomerIds();

    double getBalance(int customerId);

    Set<Integer> getCustomerAccountNumbers(Integer id);

}
