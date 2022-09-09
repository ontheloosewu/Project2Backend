package dev.thebrogrammers.dtos;

public class TokenAndRole
{
    String jwt;

    String role;

    public TokenAndRole() {
    }

    public TokenAndRole(String jwt, String role) {
        this.jwt = jwt;
        this.role = role;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "TokenAndRole{" +
                "jwt='" + jwt + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
