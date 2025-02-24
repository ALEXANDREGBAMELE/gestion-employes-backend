package com.example.gestionEmployerBackend.domain.model;

import com.example.gestionEmployerBackend.application.utils.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "contract_types")
@Setter
@Getter
public class ContractType extends BaseEntity {
    private String type;
    private String description;
    private String code;
}
