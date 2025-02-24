package com.example.gestionEmployerBackend.domain.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.example.gestionEmployerBackend.application.utils.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "custom_user")
public class CustomUser extends BaseEntity {

    private String username;
    private String email;
    private String password;
    private boolean firstLogin;

    // // Roles (for example: USER, ADMIN)
    // @ElementCollection(fetch = FetchType.EAGER)
    // private Collection<String> roles;

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

    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles; // Liste des rôles attribués à cet utilisateur

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
}
