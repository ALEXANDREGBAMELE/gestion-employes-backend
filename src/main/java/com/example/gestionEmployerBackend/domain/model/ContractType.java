package com.example.gestionEmployerBackend.domain.model;

import com.example.gestionEmployerBackend.application.utils.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "contract_types")
@Data
public class ContractType extends BaseEntity {
    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // private Long id;

    private String type;
    private String description;
}
