package com.example.gestionEmployerBackend.application.service;

import org.springframework.data.domain.Page;

import com.example.gestionEmployerBackend.application.dtos.EmployeeDto;

public interface IEmployeeService {
    Page<EmployeeDto> getAll(int page, int size, String sortDir, String sort);

    EmployeeDto create(EmployeeDto employeeDto);

    EmployeeDto getById(Long id);

    EmployeeDto update(EmployeeDto employeeDto);

    void deleteEmployee(Long id);
}