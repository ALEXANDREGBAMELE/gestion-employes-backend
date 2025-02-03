package com.example.gestionEmployerBackend.domain.model;

import java.util.Collection;

import com.example.gestionEmployerBackend.application.utils.BaseEntity;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "customUser")
public class CustomUser extends BaseEntity {

    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // private Long id;

    private String username;
    private String email;
    private String password;

    // Roles (for example: USER, ADMIN)
    @ElementCollection(fetch = FetchType.EAGER)
    private Collection<String> roles;

    // Getters and Setters

}
