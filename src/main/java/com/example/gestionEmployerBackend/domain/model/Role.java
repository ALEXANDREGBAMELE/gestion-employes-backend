package com.example.gestionEmployerBackend.domain.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor // Ajout d'un constructeur sans argument pour la désérialisation
@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; // Nom du rôle, ex: ADMIN, USER, etc.

    @ManyToMany
    @JoinTable(name = "role_functionality", joinColumns = @JoinColumn(name = "role_id"), inverseJoinColumns = @JoinColumn(name = "functionality_id"))
    private List<Fonctionality> functionalities; // Liste des fonctionnalités attribuées à ce rôle

    @ManyToMany(mappedBy = "roles")
    private List<CustomUser> users; // Liste des utilisateurs associés à ce rôle

    // Constructeur avec un argument pour créer un rôle à partir d'une chaîne
    public Role(String name) {
        this.name = name;
    }
}
