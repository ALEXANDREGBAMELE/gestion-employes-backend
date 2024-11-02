package com.example.gestionEmployerBackend.application.service;

import java.util.List;

import com.example.gestionEmployerBackend.domain.model.CustomUser;

public interface IUserService {

    // Créer un nouvel utilisateur
    CustomUser createUser(CustomUser user);

    // Obtenir un utilisateur par ID
    CustomUser getUserById(Long id);

    // Mettre à jour un utilisateur
    CustomUser updateUser(CustomUser user);

    // Supprimer un utilisateur par ID
    void deleteUserById(Long id);

    // Obtenir une liste d'utilisateurs avec pagination et tri
    List<CustomUser> getUsersList(int page, int size, String sortDir, String sort);
}