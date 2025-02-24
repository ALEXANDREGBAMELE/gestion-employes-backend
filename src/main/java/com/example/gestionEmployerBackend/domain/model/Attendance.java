package com.example.gestionEmployerBackend.domain.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.example.gestionEmployerBackend.application.utils.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name = "attendance")
public class Attendance extends BaseEntity {

    private LocalDate attendanceDate;
    private LocalDateTime checkInTime;
    private LocalDateTime checkOutTime;
    private boolean isPresent;

    @ManyToOne(fetch = FetchType.LAZY)
    private CustomUser user;
}
