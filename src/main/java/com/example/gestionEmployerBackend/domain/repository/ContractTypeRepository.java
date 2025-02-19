package com.example.gestionEmployerBackend.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gestionEmployerBackend.domain.model.ContractType;

public interface ContractTypeRepository extends JpaRepository<ContractType, Long> {

}
