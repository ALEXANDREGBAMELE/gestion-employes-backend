package com.example.gestionEmployerBackend.domain.model;

import java.util.List;

import com.example.gestionEmployerBackend.application.utils.BaseEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "employee")
public class Employee extends BaseEntity {

    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // private Long id;

    private String firstName;
    private String lastName;
    private String address;
    private String socialSecurityNumber;
    private String email;
    private String phoneNumber;

    @ManyToOne // Une relation ManyToOne avec JobTitle
    @JoinColumn(name = "job_title_id", nullable = false) // Colonne pour la clé étrangère
    private JobTitle jobTitle; // Référence à l'intitulé de poste

    // Un employé peut avoir plusieurs contrats
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Contract> contracts;
}
