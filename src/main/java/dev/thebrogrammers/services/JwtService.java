package dev.thebrogrammers.services;

public interface JwtService
{
    String createJWTWithUsernameAndRole(String username, String role);

    boolean validateJWT(String jwt);
}
