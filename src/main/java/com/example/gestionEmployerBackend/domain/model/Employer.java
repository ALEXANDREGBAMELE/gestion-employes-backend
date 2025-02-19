package com.example.gestionEmployerBackend.domain.model;

import com.example.gestionEmployerBackend.application.utils.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "employers")
@Setter
@Getter
public class Employer extends BaseEntity {

    private String name;
    private String address;
    private String taxIdentificationNumber;
    private String contact;

    // Champs spécifiques pour une personne physique
    private String firstName; // Prénom de la personne physique
    private String lastName; // Nom de famille de la personne physique
    private String socialSecurityNumber; // Numéro de sécurité sociale pour une personne physique

    // Champs spécifiques pour une personne morale
    private String companyName; // Nom de l'entreprise pour une personne morale
    private String registrationNumber; // Numéro d'enregistrement de l'entreprise
    private String legalForm; // Forme juridique de l'entreprise (SARL, SA, etc.)

    // Méthode pour déterminer si l'employeur est une personne morale
    public boolean isCompany() {
        return companyName != null && !companyName.isEmpty();
    }

    // Méthode pour déterminer si l'employeur est une personne physique
    public boolean isIndividual() {
        return firstName != null && !firstName.isEmpty() && lastName != null && !lastName.isEmpty();
    }
}