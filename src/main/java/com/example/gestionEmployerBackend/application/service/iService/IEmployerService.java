package com.example.gestionEmployerBackend.application.service.iService;

import org.springframework.data.domain.Page;

import com.example.gestionEmployerBackend.application.dtos.EmployerDto;

public interface IEmployerService {
    Page<EmployerDto> getAll(int page, int size, String sortDir, String sort);

    EmployerDto create(EmployerDto employerDto);

    EmployerDto getById(Long id);

    EmployerDto update(EmployerDto employerDto);

    void delete(Long id);
}
