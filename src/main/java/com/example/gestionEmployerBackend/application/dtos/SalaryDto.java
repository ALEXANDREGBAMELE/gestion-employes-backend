package com.example.gestionEmployerBackend.application.dtos;

import lombok.Data;

@Data
public class SalaryDto {
    private Long id;
    private double montant;
    private String devise;
    private String frequence;
}