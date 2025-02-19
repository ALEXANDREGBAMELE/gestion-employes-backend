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
@Table(name = "absence")
public class Absence extends BaseEntity {

    private LocalDate absenceDate;
    private String absenceReason;
    private boolean isJustified;

    @ManyToOne(fetch = FetchType.LAZY)
    private CustomUser user;
}
