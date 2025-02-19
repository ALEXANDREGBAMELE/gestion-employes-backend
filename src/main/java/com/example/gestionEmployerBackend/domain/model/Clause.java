package com.example.gestionEmployerBackend.domain.model;

import com.example.gestionEmployerBackend.application.utils.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "clauses")
public class Clause extends BaseEntity {
    private String type;
    private String description;

    @ManyToOne
    @JoinColumn(name = "contract_id", nullable = false)
    private Contract contract;
}
