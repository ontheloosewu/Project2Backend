package dev.thebrogrammers.services;

import dev.thebrogrammers.dtos.LoginCredentials;

public interface LoginService {

    String authenticateUser(LoginCredentials loginCredentials);
}
