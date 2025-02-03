package com.example.gestionEmployerBackend.application.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class DepartmentDto {

    private Long id;

    @NotNull
    @Size(min = 1, max = 100)
    private String name;

    @Size(max = 255)
    private String description;

    // Constructor, Getters, Setters, and toString() as before...
}
