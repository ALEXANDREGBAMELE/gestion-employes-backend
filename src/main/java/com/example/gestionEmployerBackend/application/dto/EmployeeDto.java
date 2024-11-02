package com.example.gestionEmployerBackend.application.dto;

import lombok.Data;

@Data
public class EmployeeDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String socialSecurityNumber;
    private String position;
    private String email;
    private String phoneNumber;
}