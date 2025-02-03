package com.example.gestionEmployerBackend.application.exception;

/**
 * Exception personnalisée pour les ressources introuvables.
 */
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
