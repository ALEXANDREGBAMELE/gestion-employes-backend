package com.example.gestionEmployerBackend.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gestionEmployerBackend.domain.model.Contract;

public interface ContractRepository extends JpaRepository<Contract, Long> {
    // Méthode de recherche avec pagination
    // Page<ContractDto> fi(Pageable pageable);

}
