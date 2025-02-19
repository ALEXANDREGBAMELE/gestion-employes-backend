package com.example.gestionEmployerBackend.domain.model;

import java.time.LocalDate;

import com.example.gestionEmployerBackend.application.utils.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "payrolls")
public class Payroll extends BaseEntity {

    private Double amountPaid;
    private LocalDate paymentDate;
    private String paymentMethod; // BANK_TRANSFER, CASH, etc.
    private String status; // PENDING, COMPLETED, FAILED

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "salary_id", nullable = false)
    private Salary salary;
}
