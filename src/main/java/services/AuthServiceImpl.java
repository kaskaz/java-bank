package services;

import model.Customer;

public class AuthServiceImpl implements AuthService {

    private Customer accesingCustomer;
    private CustomerService customerService;

    @Override
    public boolean authenticate(Integer id) {

        accesingCustomer = customerService.findById(id);
        return accesingCustomer != null;
    }

    @Override
    public Customer getAccessingCustomer() {
        return customerService.findById(accesingCustomer.getId());
    }

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }
}
