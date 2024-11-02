package com.example.gestionEmployerBackend.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "employers")
@Data
public class Employer extends BaseEntity {
    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // private Long id;

    private String name;
    private String address;
    private String taxIdentificationNumber;
    private String contact;
}
