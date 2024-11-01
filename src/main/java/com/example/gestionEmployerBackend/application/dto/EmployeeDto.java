package com.example.gestionEmployerBackend.application.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmployeeDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String department;
    private LocalDate hireDate;

}
