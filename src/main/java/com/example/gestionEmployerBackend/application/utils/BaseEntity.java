package com.example.gestionEmployerBackend.application.utils;

import java.time.LocalDateTime;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Data;

@Data
@MappedSuperclass // Indique à JPA que cette classe est une classe de base pour d'autres entités
@EntityListeners(BaseEntityListener.class) // Permet de suivre les événements d'entité
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Champs communs pour la gestion des auditeurs
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
    private Long createdBy;
    private Long updatedBy;
    private Long deletedBy;

    // Méthodes pour mettre à jour les champs d'audit lors de la création
    @PrePersist
    public void onPrePersist() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    // Méthodes pour mettre à jour les champs d'audit lors de la mise à jour
    @PreUpdate
    public void onPreUpdate() {
        updatedAt = LocalDateTime.now();
    }

    // Méthode pour gérer la suppression logique
    public void markAsDeleted(Long userId) {
        deletedAt = LocalDateTime.now();
        deletedBy = userId;
    }
}
