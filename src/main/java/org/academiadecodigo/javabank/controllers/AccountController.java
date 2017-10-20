package org.academiadecodigo.javabank.controllers;

import org.academiadecodigo.javabank.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AccountController {

    @Autowired
    private AccountService accountService;
}
