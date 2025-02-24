package com.example.gestionEmployerBackend.domain.model;

import java.util.List;

import com.example.gestionEmployerBackend.application.utils.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "job_titles")
@EqualsAndHashCode(callSuper = false)
public class JobTitle extends BaseEntity {

    private String name;
    private String description;

    // Relation avec les employés qui occupent ce poste
    @OneToMany(mappedBy = "jobTitle")
    private List<EmployeeJobTitle> employees;
}