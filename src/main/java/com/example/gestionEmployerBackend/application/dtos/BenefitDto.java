package com.example.gestionEmployerBackend.application.dtos;

import lombok.Data;

@Data
public class BenefitDto {
    private Long id;
    private String type;
    private String description;
}