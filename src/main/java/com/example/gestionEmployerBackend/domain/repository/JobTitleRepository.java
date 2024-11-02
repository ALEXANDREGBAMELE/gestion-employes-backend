package com.example.gestionEmployerBackend.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gestionEmployerBackend.domain.model.JobTitle;

@Repository
public interface JobTitleRepository extends JpaRepository<JobTitle, Long> {
    // Additional query methods can be defined here if needed
}
