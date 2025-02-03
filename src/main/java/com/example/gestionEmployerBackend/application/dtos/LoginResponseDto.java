package com.example.gestionEmployerBackend.application.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginResponseDto {
    private String token;
    private String username;
    // Getters and Setters
}
