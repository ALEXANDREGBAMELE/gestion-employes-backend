package com.example.gestionEmployerBackend.application.exception;

/**
 * Représentation des erreurs pour les réponses.
 */
public class CustomErrorResponse {
    private int statusCode;
    private String message;

    public CustomErrorResponse(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
