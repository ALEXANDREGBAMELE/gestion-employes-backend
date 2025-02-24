package com.example.gestionEmployerBackend.application.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.example.gestionEmployerBackend.domain.model.Role;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CustomUserDto {

    private Long id;
    private String username;
    private String email;
    private String password;
    private boolean firstLogin;

    // Informations personnelles
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;
    private String profilePictureUrl;
    private LocalDate dateOfBirth;
    private String gender;
    private String nationality;
    private String language;
    private String timezone;

    // Gestion du compte
    private boolean isActive;
    private boolean isVerified;

    // Sécurité et authentification
    private String passwordResetToken;
    private LocalDateTime passwordResetTokenExpiration;
    private String twoFactorAuthSecret;
    private boolean isTwoFactorEnabled;

    // Historique et traçabilité
    private String lastLoginIp;
    private LocalDateTime lastLoginAt;
    private int failedLoginAttempts;
    private LocalDateTime accountLockedUntil;

    // Liste des rôles attribués à cet utilisateur
    private List<Role> roles;
}
