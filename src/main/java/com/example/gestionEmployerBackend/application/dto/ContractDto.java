package com.example.gestionEmployerBackend.application.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data

public class ContractDto {

    private Long id;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private Double salary;
    private String contractType;
    private String status;
    private String employeeName;

    // Constructeurs, getters et setters

    // * public ContractDto() {}
    // *
    // * public ContractDto(Long id, String description, LocalDate startDate,
    // * LocalDate endDate,
    // * Double salary, String contractType, String status, String employeeName) {
    // * this.id = id;
    // * this.description = description;
    // * this.startDate = startDate;
    // * this.endDate = endDate;
    // * this.salary = salary;
    // * this.contractType = contractType;
    // * this.status = status;
    // * this.employeeName = employeeName;
    // * }
    // *
    // * // Getters et setters
    // * // ...
    //
}
