package com.example.gestionEmployerBackend.domain.model;

public class ApiStatus {

    private String code; // Code du statut (ex. 200, 400, etc.)
    private String libelle; // Libellé du statut (ex. SUCCESS, ERROR)
    private String message; // Message d'information (ex. "Employees retrieved successfully")

    public ApiStatus(String code, String libelle, String message) {
        this.code = code;
        this.libelle = libelle;
        this.message = message;
    }

    // Getters et Setters
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
