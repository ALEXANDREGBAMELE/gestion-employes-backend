package com.example.gestionEmployerBackend.application.utils;

import java.util.List;

import lombok.Data;

@Data
public class ApiResponse<T> {

    private ApiStatus statut;
    private List<T> items;
    private Pagination pagination;
}
