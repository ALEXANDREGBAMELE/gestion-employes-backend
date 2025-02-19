package com.example.gestionEmployerBackend.application.dtos;

import lombok.Data;

@Data
public class EmployerDto {
    private Long id;
    private String name;
    private String address;
    private String taxIdentificationNumber;
    private String contact;

    // Champs spécifiques pour une personne physique
    private String firstName;
    private String lastName;
    private String socialSecurityNumber;

    // Champs spécifiques pour une personne morale
    private String companyName;
    private String registrationNumber;
    private String legalForm;

    // Méthode pour déterminer si l'employeur est une personne morale
    public boolean isCompany() {
        return companyName != null && !companyName.isEmpty();
    }

    // Méthode pour déterminer si l'employeur est une personne physique
    public boolean isIndividual() {
        return firstName != null && !firstName.isEmpty() && lastName != null && !lastName.isEmpty();
    }
}