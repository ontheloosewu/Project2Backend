package dev.thebrogrammers.services;

import dev.thebrogrammers.dtos.LoginCredentials;
import dev.thebrogrammers.entities.AppUser;
import dev.thebrogrammers.exceptions.PasswordMismatchException;
import dev.thebrogrammers.repos.AppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import sun.security.util.Password;

import java.time.LocalDateTime;

@Service
public class LoginServiceImpl implements  LoginService{

    @Autowired
    JwtService jwtService;

    @Autowired
    AppUserRepo appUserRepo;

    @Autowired
    JmsTemplate jmsTemplate;

    @Override
    public String authenticateUser(LoginCredentials loginCredentials)
    {
        AppUser user = appUserRepo.findByUsername(loginCredentials.getUsername());

        if (!user.getPassword().equals(loginCredentials.getPassword()))
        {
            throw new PasswordMismatchException();
        }

        String message = "Login " + loginCredentials.getUsername() + " " + LocalDateTime.now();
        jmsTemplate.convertAndSend("message-queue",message);

        return jwtService.createJWTWithUsernameAndRole(user.getUsername(), user.getRole());
    }
}
