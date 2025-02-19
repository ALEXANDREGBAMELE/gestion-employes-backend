package com.example.gestionEmployerBackend.application.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ContractCreateDto {
    private String reference;
    private String startDate;
    private String endDate;
    private Long employeeId;
    private Long employerId;
    private Long contractTypeId;
}
