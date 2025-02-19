package com.example.gestionEmployerBackend.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gestionEmployerBackend.domain.model.Employer;

public interface EmployerRepository extends JpaRepository<Employer, Long> {

}
