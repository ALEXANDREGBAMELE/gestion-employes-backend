package com.example.gestionEmployerBackend.application.dto;

import lombok.Data;

@Data
public class BenefitDto {
    private Long id;
    private String type;
    private String description;
}