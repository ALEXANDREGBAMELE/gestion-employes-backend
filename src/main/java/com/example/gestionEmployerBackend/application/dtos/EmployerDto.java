package com.example.gestionEmployerBackend.application.dtos;

import lombok.Data;

@Data
public class EmployerDto {
    private Long id;
    private String name;
    private String address;
    private String taxIdentificationNumber;
    private String contact;
}
