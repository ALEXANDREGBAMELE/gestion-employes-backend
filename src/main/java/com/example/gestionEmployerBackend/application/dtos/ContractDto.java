package com.example.gestionEmployerBackend.application.dtos;

import java.util.List;

import lombok.Data;

@Data
public class ContractDto {
    private Long id;
    private String reference;
    private String startDate;
    private String endDate;
    private EmployeeDto employee;
    private EmployerDto employer;
    private ContractTypeDto contractType;
    private List<ClauseDto> clauses;
    private List<BenefitDto> benefits;
}