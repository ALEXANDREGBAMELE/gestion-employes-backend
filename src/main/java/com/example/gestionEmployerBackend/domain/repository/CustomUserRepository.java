package com.example.gestionEmployerBackend.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gestionEmployerBackend.domain.model.CustomUser;

@Repository
public interface CustomUserRepository extends JpaRepository<CustomUser, Long> {

    // Recherche un utilisateur par son username
    Optional<CustomUser> findByUsername(String username);

    // Recherche un utilisateur par son email
    Optional<CustomUser> findByEmail(String email);

    // Vérifie si un utilisateur existe par son username
    boolean existsByUsername(String username);

    // Vérifie si un utilisateur existe par son email
    boolean existsByEmail(String email);
}
