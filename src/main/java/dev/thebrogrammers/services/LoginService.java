package dev.thebrogrammers.services;

import dev.thebrogrammers.dtos.LoginCredentials;
import dev.thebrogrammers.dtos.TokenAndRole;

public interface LoginService {

    TokenAndRole authenticateUser(LoginCredentials loginCredentials);
}
