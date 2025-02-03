package com.example.gestionEmployerBackend.application.exception;

/**
 * Exception personnalisée pour les erreurs liées à l'utilisateur.
 */
public class UserException extends RuntimeException {
    public UserException(String message) {
        super(message);
    }
}
