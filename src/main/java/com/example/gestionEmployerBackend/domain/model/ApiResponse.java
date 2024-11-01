package com.example.gestionEmployerBackend.domain.model;

public class ApiResponse<T> {

    private ApiStatus statut; // Contient le code, libellé et message
    private T data; // Les données génériques (ex. les résultats paginés)

    public ApiResponse(ApiStatus statut, T data) {
        this.statut = statut;
        this.data = data;
    }

    // Getters et Setters
    public ApiStatus getStatut() {
        return statut;
    }

    public void setStatut(ApiStatus statut) {
        this.statut = statut;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
