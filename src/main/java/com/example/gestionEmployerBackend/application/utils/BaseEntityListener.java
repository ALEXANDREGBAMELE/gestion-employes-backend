package com.example.gestionEmployerBackend.application.utils;

import java.time.LocalDateTime;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

public class BaseEntityListener {

    // Méthode appelée avant la persistance d'une nouvelle entité
    @PrePersist
    public void prePersist(BaseEntity entity) {
        entity.setCreatedAt(LocalDateTime.now());
        entity.setUpdatedAt(LocalDateTime.now());
        // Remplacez '1L' par l'ID de l'utilisateur actuel en production
        entity.setCreatedBy(1L); // Utilisateur fictif pour l'exemple
    }

    // Méthode appelée avant la mise à jour d'une entité existante
    @PreUpdate
    public void preUpdate(BaseEntity entity) {
        entity.setUpdatedAt(LocalDateTime.now());
        // Remplacez '1L' par l'ID de l'utilisateur actuel en production
        entity.setUpdatedBy(1L); // Utilisateur fictif pour l'exemple
    }
}
