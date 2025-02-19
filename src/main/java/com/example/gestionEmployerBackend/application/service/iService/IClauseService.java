package com.example.gestionEmployerBackend.application.service.iService;

import org.springframework.data.domain.Page;

import com.example.gestionEmployerBackend.application.dtos.ClauseDto;

public interface IClauseService {
    Page<ClauseDto> getAll(int page, int size, String sortDir, String sort);

    ClauseDto create(ClauseDto clauseDto);

    ClauseDto getById(Long id);

    ClauseDto update(ClauseDto clauseDto);

    void delete(Long id);
}
