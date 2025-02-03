package com.example.gestionEmployerBackend.application.utils;

import lombok.Data;

@Data
public class ApiStatus {

    private String code; // Code du statut (ex. 200, 400, etc.)
    private String libelle; // Libellé du statut (ex. SUCCESS, ERROR)
    private String message; // Message d'information (ex. "Employees retrieved successfully")

    public ApiStatus(String code, String libelle, String message) {
        this.code = code;
        this.libelle = libelle;
        this.message = message;
    }

}
