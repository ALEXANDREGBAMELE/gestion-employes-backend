package com.example.gestionEmployerBackend.application.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class EmployeeJobTitleDto {
    private Long id;
    private Long employeeId;
    private Long jobTitleId;
    private LocalDate startDate;
    private LocalDate endDate;
    private String department;
}
