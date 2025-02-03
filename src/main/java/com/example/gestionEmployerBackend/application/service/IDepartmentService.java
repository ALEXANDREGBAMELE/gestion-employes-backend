package com.example.gestionEmployerBackend.application.service;

import org.springframework.data.domain.Page;

import com.example.gestionEmployerBackend.application.dtos.DepartmentDto;

public interface IDepartmentService {
    DepartmentDto create(DepartmentDto departmentDto);

    DepartmentDto getById(Long id);

    DepartmentDto update(DepartmentDto departmentDto);

    void delete(Long id);

    Page<DepartmentDto> getAll(int page, int size, String sortDir, String sort);
}
