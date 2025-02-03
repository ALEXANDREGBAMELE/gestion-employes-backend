package com.example.gestionEmployerBackend.application.dtos;

import lombok.Data;

@Data
public class ContractTypeDto {
    private Long id;
    private String type;
    private String description;
}
