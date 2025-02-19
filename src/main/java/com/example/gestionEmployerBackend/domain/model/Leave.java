package com.example.gestionEmployerBackend.domain.model;

import java.time.LocalDate;

import com.example.gestionEmployerBackend.application.utils.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "leave_request")
public class Leave extends BaseEntity {

    private String leaveType; // Example: ANNUAL, SICK, UNPAID, etc.
    private LocalDate startDate;
    private LocalDate endDate;
    private String status; // Example: PENDING, APPROVED, REJECTED
    private String reason;

    @ManyToOne(fetch = FetchType.LAZY)
    private CustomUser user;
}
