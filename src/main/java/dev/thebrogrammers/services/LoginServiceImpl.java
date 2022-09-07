package dev.thebrogrammers.services;

import dev.thebrogrammers.dtos.LoginCredentials;
import dev.thebrogrammers.entities.AppUser;
import dev.thebrogrammers.exceptions.PasswordMismatchException;
import dev.thebrogrammers.repos.AppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.security.util.Password;

@Service
public class LoginServiceImpl implements  LoginService{

    @Autowired
    JwtService jwtService;

    @Autowired
    AppUserRepo appUserRepo;
    @Override
    public String authenticateUser(LoginCredentials loginCredentials)
    {
        AppUser user = appUserRepo.findByUsername(loginCredentials.getUsername());

        if (!user.getPassword().equals(loginCredentials.getPassword()))
        {
            throw new PasswordMismatchException();
        }

        return jwtService.createJWTWithUsernameAndRole(user.getUsername(), user.getRole());
    }
}
