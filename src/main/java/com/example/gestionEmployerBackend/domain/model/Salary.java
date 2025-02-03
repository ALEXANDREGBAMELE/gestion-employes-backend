package com.example.gestionEmployerBackend.domain.model;

import com.example.gestionEmployerBackend.application.utils.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "salaries")
public class Salary extends BaseEntity {
    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // private Long id;
    private Double baseSalary;
    private Double bonus;
    private Double deductions;
    private Double netSalary;
    private String devise;
    private String frequence;

    @OneToOne
    @JoinColumn(name = "contract_id", nullable = false)
    private Contract contract;

    // Méthode pour calculer le salaire net si besoin
    // public Double getNetSalary() {
    // return (baseSalary + (bonus != null ? bonus : 0)) - (deductions != null ?
    // deductions : 0);
    // }

}
