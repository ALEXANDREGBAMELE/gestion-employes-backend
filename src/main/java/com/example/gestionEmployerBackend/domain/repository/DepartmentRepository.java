package com.example.gestionEmployerBackend.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.gestionEmployerBackend.domain.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Optional<Department> findByName(String name);

    @Query("SELECT d FROM Department d WHERE d.name LIKE %:keyword%")
    List<Department> searchByKeyword(String keyword);
}
