package com.example.gestionEmployerBackend.domain.model;

import com.example.gestionEmployerBackend.application.utils.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "benefits")
@Data
public class Benefit extends BaseEntity {
    private String type;
    private String description;

    @ManyToOne
    @JoinColumn(name = "contract_id", nullable = false)
    private Contract contract;
}
