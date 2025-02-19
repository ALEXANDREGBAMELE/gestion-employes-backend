package com.example.gestionEmployerBackend.application.service.iService;

import org.springframework.data.domain.Page;

import com.example.gestionEmployerBackend.application.dtos.CustomUserDto;

public interface IUserService {

    // Créer un nouvel utilisateur
    CustomUserDto create(CustomUserDto customerUserDto);

    // Obtenir un utilisateur par ID
    CustomUserDto getById(Long id);

    // Mettre à jour un utilisateur
    CustomUserDto update(CustomUserDto customerUserDto);

    // Supprimer un utilisateur par ID
    void delete(Long id);

    // Obtenir une liste d'utilisateurs avec pagination et tri
    Page<CustomUserDto> getAll(int page, int size, String sortDir, String sort);
}