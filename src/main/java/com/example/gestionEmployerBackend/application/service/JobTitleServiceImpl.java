package com.example.gestionEmployerBackend.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.gestionEmployerBackend.domain.model.JobTitle;
import com.example.gestionEmployerBackend.domain.repository.JobTitleRepository;

@Service
public class JobTitleServiceImpl implements IJobTitleService {

    @Autowired
    private JobTitleRepository jobTitleRepository;

    @Override
    public List<JobTitle> getJobTitlesList(int page, int size, String sortDir, String sort) {
        Sort sortDirection = "desc".equalsIgnoreCase(sortDir) ? Sort.by(sort).descending() : Sort.by(sort).ascending();
        PageRequest pageRequest = PageRequest.of(page, size, sortDirection);
        return jobTitleRepository.findAll(pageRequest).getContent();
    }

    @Override
    public JobTitle createJobTitle(JobTitle jobTitle) {
        return jobTitleRepository.save(jobTitle);
    }

    @Override
    public JobTitle getJobTitleById(Long id) {
        return jobTitleRepository.findById(id).orElseThrow(() -> new RuntimeException("Job Title not found"));
    }

    @Override
    public void updateJobTitle(JobTitle jobTitle) {
        jobTitleRepository.save(jobTitle);
    }

    @Override
    public void deleteJobTitle(Long id) {
        jobTitleRepository.deleteById(id);
    }
}
