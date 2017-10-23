package org.academiadecodigo.javabank.controllers;

import org.academiadecodigo.javabank.dto.CustomerDTO;
import org.academiadecodigo.javabank.dto.CustomerDTOConverter;
import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
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

        customerService.remove(id);

        return "redirect:/customers";

    }

    @RequestMapping(method = RequestMethod.GET, path = "/customeradd")
    public String customerAdd(Model model){

        CustomerDTO customer = new CustomerDTO();
        model.addAttribute("customer",customer);

        return "customerform";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/customeredit/{id}")
    public String customerEdit(Model model, @PathVariable int id){

        Customer customer = customerService.findById(id);

        CustomerDTOConverter customerDTOConverter = new CustomerDTOConverter();
        CustomerDTO customerDTO = customerDTOConverter.convertToDto(customer);

        model.addAttribute("customer",customerDTO);

        return "customerform";
    }

    @RequestMapping(method = RequestMethod.POST, path = "/customersave")
    public String customerSave(@Valid @ModelAttribute("customer") CustomerDTO customerDTO, BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            return "customerform";
        }

        Customer customer = customerService.findById( customerDTO.getId() );

        CustomerDTOConverter customerDTOConverter = new CustomerDTOConverter();
        customerDTOConverter.convertFromDto( customerDTO, customer);

        customerService.add(customer);

        return "redirect:/customers";
    }

}
