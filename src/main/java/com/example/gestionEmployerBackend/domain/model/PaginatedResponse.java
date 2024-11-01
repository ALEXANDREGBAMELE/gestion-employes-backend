package com.example.gestionEmployerBackend.domain.model;

import java.util.List;

public class PaginatedResponse<T> {
    private List<T> content; // Les éléments paginés
    private int currentPage; // Page actuelle
    private int totalPages; // Nombre total de pages
    private long totalItems; // Nombre total d'éléments

    public PaginatedResponse(List<T> content, int currentPage, int totalPages, long totalItems) {
        this.content = content;
        this.currentPage = currentPage;
        this.totalPages = totalPages;
        this.totalItems = totalItems;
    }

    // Getters et Setters
    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public long getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(long totalItems) {
        this.totalItems = totalItems;
    }
}
