package com.example.gestionEmployerBackend.domain.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;

import com.example.gestionEmployerBackend.application.utils.BaseEntity;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "custom_user")
public class CustomUser extends BaseEntity {

    private String username;
    private String email;
    private String password;

    // Roles (for example: USER, ADMIN)
    @ElementCollection(fetch = FetchType.EAGER)
    private Collection<String> roles;

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
}
