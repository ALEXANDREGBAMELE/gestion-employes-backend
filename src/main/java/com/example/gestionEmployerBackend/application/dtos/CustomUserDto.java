package com.example.gestionEmployerBackend.application.dtos;

import java.util.Collection;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CustomUserDto {

    private Long id;

    private String username;
    private String email;
    private String password;
    private Collection<String> roles;
}
