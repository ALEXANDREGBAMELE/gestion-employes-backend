package com.example.gestionEmployerBackend.application.utils;

import org.springframework.data.domain.Page;

public interface IBaseService<T, DTO> {

    DTO create(DTO dto);

    DTO getById(Long id);

    DTO update(DTO dto);

    void delete(Long id);

    Page<DTO> getAll(int page, int size, String sortDir, String sort);
}
