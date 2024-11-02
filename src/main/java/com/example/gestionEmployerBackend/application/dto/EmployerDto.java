package com.example.gestionEmployerBackend.application.dto;

import lombok.Data;

@Data
public class EmployerDto {
    private Long id;
    private String name;
    private String address;
    private String taxIdentificationNumber;
    private String contact;
}
