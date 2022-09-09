package dev.thebrogrammers.controllers;

import dev.thebrogrammers.dtos.LoginCredentials;
import dev.thebrogrammers.dtos.TokenAndRole;
import dev.thebrogrammers.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping("/login")
    public TokenAndRole login(@RequestBody LoginCredentials loginCredentials)
    {
        return loginService.authenticateUser(loginCredentials);
    }
}
