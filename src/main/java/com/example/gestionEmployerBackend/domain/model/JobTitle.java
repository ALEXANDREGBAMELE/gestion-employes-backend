package com.example.gestionEmployerBackend.domain.model;

import com.example.gestionEmployerBackend.application.utils.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "job_titles")
public class JobTitle extends BaseEntity {

    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // private Long id;

    private String name; // E.g., "Sales Assistant", "Program Analyst", "Manager"
    private String description; // E.g., "Responsible for assisting in sales operations", etc.
}