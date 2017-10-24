package org.academiadecodigo.javabank.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.academiadecodigo.javabank.command.CustomerForm;
import org.academiadecodigo.javabank.converters.CustomerFormToCustomer;
import org.academiadecodigo.javabank.converters.CustomerToCustomerForm;
import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/api/customer")
@ResponseBody
public class RestCustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerFormToCustomer customerFormToCustomer;

    @Autowired
    private CustomerToCustomerForm customerToCustomerForm;

    @RequestMapping(method = RequestMethod.GET, path = {"/list", "/", ""})

    public ResponseEntity<List<CustomerForm>> listCustomers() {

        List<Customer> list = customerService.list();

        if(list == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        List<CustomerForm> customerFormList = new ArrayList<>();

        for (Customer customer : list) {
            customerFormList.add( customerToCustomerForm.convert(customer) );
        }

        return new ResponseEntity<>( customerFormList, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/add")
    public ResponseEntity<Customer> addCustomer(@Valid @RequestBody CustomerForm customerForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Customer customer = customerFormToCustomer.convert(customerForm);

        return new ResponseEntity<>( customer, HttpStatus.OK);

    }
    /*
        @RequestMapping(method = RequestMethod.GET, path = "/edit/{id}")
        public String editCustomer(@PathVariable Integer id, Model model) {
            model.addAttribute("customer", customerToCustomerForm.convert(customerService.get(id)));
            return "customer/add-update";
        }
    */
    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    @ResponseBody
    public ResponseEntity<CustomerForm> showCustomer(@PathVariable Integer id) {

        Customer customer = customerService.get(id);

        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>( customerToCustomerForm.convert(customer), HttpStatus.OK);

    }
/*
    @RequestMapping(method = RequestMethod.POST, path = {"/", ""})
    public String saveCustomer(@Valid @ModelAttribute("customer") CustomerForm customerForm, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            return "customer/add-update";
        }

        Customer savedCustomer = customerService.save(customerFormToCustomer.convert(customerForm));

        redirectAttributes.addFlashAttribute("lastAction", "Saved " + savedCustomer.getFirstName() + " " + savedCustomer.getLastName());
        return "redirect:/customer/";

    }

    @RequestMapping(method = RequestMethod.GET, path = "/delete/{id}")
    public String deleteCustomer(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        Customer customer = customerService.get(id);
        customerService.delete(id);
        redirectAttributes.addFlashAttribute("lastAction", "Deleted " + customer.getFirstName() + " " + customer.getLastName());
        return "redirect:/customer";
    }

    @ExceptionHandler(Exception.class)
    public void handleAllException(Exception ex) {
        ex.printStackTrace();
    }*/

}
