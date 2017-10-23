package org.academiadecodigo.javabank.controllers;

import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(method = RequestMethod.GET, value = "/accounts")
    public String Accounts(Model model){

        List<Account> accounts = accountService.getAccounts();

        model.addAttribute("accounts", accounts);

        return "accounts";

    }

    @RequestMapping(method = RequestMethod.GET, value = "/accountview/{id}")
    public String accountView(Model model, @PathVariable int id){

        Account account = accountService.getAccount(id);

        model.addAttribute("account", account);

        return "account";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/accountdeletefromaccountslist/{id}")
    public String accountDeleteFromAccountsList(@PathVariable int id){

        Account account = accountService.getAccount(id);
        account.getCustomer().removeAccount(account);

        accountService.remove(id);

        return "redirect:/accounts";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/accountdeletefromcustomer/{id}")
    public String accountDeleteFromCustomer(@PathVariable int id){

        Account account = accountService.getAccount(id);
        Customer customer = account.getCustomer();
        customer.removeAccount(account);

        accountService.remove(id);

        return "redirect:/customerview/" + customer.getId();
    }

}
