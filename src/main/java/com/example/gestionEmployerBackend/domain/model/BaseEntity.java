package com.example.gestionEmployerBackend.domain.model;

import java.time.LocalDateTime;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass // Indique à JPA que cette classe est une classe de base pour d'autres entités
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Champs communs pour la gestion des auditeurs
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Long createdBy; // ID de l'utilisateur qui crée l'entité
    private Long updatedBy; // ID de l'utilisateur qui met à jour l'entité

    // Méthodes pour mettre à jour les champs d'audit
    public void prePersist(Long userId) {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
        createdBy = userId; // Assigner l'utilisateur qui crée l'entité
    }

    public void preUpdate(Long userId) {
        updatedAt = LocalDateTime.now();
        updatedBy = userId; // Assigner l'utilisateur qui met à jour l'entité
    }
}
