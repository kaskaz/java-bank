package org.academiadecodigo.javabank.controllers;

import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(method = RequestMethod.GET, value = "/customers")
    public String Customers(Model model){

        List<Customer> customers = customerService.getCustomers();
        model.addAttribute("customers", customers);

        return "customers";

    }

    @RequestMapping(method = RequestMethod.GET, path = "/customerview/{id}")
    public String customerView(Model model, @PathVariable int id){

        Customer customer = customerService.findById(id);

        model.addAttribute("customer", customer);

        return "customer";

    }

    @RequestMapping(method = RequestMethod.GET, path = "/customerdelete/{id}")
    public String customerDelete(Model model, @PathVariable int id){


        Customer customer = customerService.findById(id);
        // eliminar

     /*   List<Customer> customers = customerService.getCustomers();
        model.addAttribute("customers", customers);
*/
        return "redirect:/customers";

    }

}
