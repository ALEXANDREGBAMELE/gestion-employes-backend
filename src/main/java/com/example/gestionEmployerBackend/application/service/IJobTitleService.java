package com.example.gestionEmployerBackend.application.service;

import java.util.List;

import com.example.gestionEmployerBackend.domain.model.JobTitle;

public interface IJobTitleService {
    List<JobTitle> getJobTitlesList(int page, int size, String sortDir, String sort);

    JobTitle createJobTitle(JobTitle jobTitle);

    JobTitle getJobTitleById(Long id);

    void updateJobTitle(JobTitle jobTitle);

    void deleteJobTitle(Long id);
}