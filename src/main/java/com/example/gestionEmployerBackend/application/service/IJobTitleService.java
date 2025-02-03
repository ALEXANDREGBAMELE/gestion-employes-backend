package com.example.gestionEmployerBackend.application.service;

import org.springframework.data.domain.Page;

import com.example.gestionEmployerBackend.application.dtos.JobTitleDto;

public interface IJobTitleService {
    Page<JobTitleDto> getAll(int page, int size, String sortDir, String sort);

    JobTitleDto create(JobTitleDto jobTitleDto);

    JobTitleDto getById(Long id);

    JobTitleDto update(JobTitleDto jobTitleDto);

    void delete(Long id);
}