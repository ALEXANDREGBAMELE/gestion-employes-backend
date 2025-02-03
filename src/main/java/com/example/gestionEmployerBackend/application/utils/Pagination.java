package com.example.gestionEmployerBackend.application.utils;

import lombok.Data;

@Data
public class Pagination {
    private int page;
    private int size;
    private long totalItems;
    private int totalPages;

}
