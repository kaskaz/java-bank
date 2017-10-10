package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.javabank.services.AuthService;
import org.academiadecodigo.javabank.services.CustomerService;
import org.academiadecodigo.javabank.view.LoginView;

import java.util.Set;

public class LoginController extends AbstractController {

    private Controller nextController;
    private AuthService authService;

    public void onLogin(int id) {

        if (authService.auth(id))
            nextController.init();
        else{
            ((LoginView)view).showLoginError();
            init();
        }

    }

    public void setNextController(Controller nextController) {
        this.nextController = nextController;
    }

    public void setAuthService(AuthService authService) {
        this.authService = authService;
    }

}
