package com.example.gestionEmployerBackend.application.service.iService;

import org.springframework.data.domain.Page;

import com.example.gestionEmployerBackend.application.dtos.BenefitDto;

public interface IBenefitService {
    Page<BenefitDto> getAll(int page, int size, String sortDir, String sort);

    BenefitDto create(BenefitDto benefitDto);

    BenefitDto getById(Long id);

    BenefitDto update(BenefitDto benefitDto);

    void delete(Long id);
}
