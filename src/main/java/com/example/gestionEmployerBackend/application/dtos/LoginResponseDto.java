package com.example.gestionEmployerBackend.application.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
// public class LoginResponseDto {
// private String token;
// private String username;
// // Getters and Setters
// }
public class LoginResponseDto {
    private String token;
    private String username;

    // Constructor
    public LoginResponseDto(String token, String username) {
        this.token = token;
        this.username = username;
    }

    // Getters and setters
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
