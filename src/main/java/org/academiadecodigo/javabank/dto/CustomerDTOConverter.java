package org.academiadecodigo.javabank.dto;

import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.services.CustomerService;

public class CustomerDTOConverter {

    public CustomerDTO convertToDto(Customer customer){

        CustomerDTO customerDTO = new CustomerDTO();

        customerDTO.setFirstName( customer.getFirstName() );
        customerDTO.setLastName( customer.getLastName() );
        customerDTO.setEmail( customer.getEmail() );
        customerDTO.setPhone( customer.getPhone() );
        customerDTO.setId( customer.getId() );

        return customerDTO;

    }

    public Customer convertFromDto(CustomerDTO customerDTO, Customer customer){

        customer.setId( customerDTO.getId() );
        customer.setFirstName( customerDTO.getFirstName() );
        customer.setLastName( customerDTO.getLastName() );
        customer.setEmail( customerDTO.getEmail() );
        customer.setPhone( customerDTO.getPhone() );

        return customer;

    }
}
