package com.example.gestionEmployerBackend.domain.model;

import com.example.gestionEmployerBackend.application.utils.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "salaries")
public class Salary extends BaseEntity {

    private Double baseSalary;
    private Double bonus;
    private Double deductions;
    private Double netSalary;
    private String currency; // USD, EUR, CFA, etc.
    private String frequency; // MONTHLY, WEEKLY, etc.

    @OneToOne
    @JoinColumn(name = "contract_id", nullable = false)
    private Contract contract;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    public Double calculateNetSalary() {
        return (baseSalary + (bonus != null ? bonus : 0)) - (deductions != null ? deductions : 0);
    }
}
