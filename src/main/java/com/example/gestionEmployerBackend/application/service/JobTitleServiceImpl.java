package com.example.gestionEmployerBackend.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.gestionEmployerBackend.application.dtos.JobTitleDto;
import com.example.gestionEmployerBackend.domain.repository.JobTitleRepository;
import com.example.gestionEmployerBackend.interfaces.mapper.GenericMapper;

@Service
public class JobTitleServiceImpl implements IJobTitleService {

    @Autowired
    private JobTitleRepository jobTitleRepository;

    @Autowired
    private GenericMapper mapper;

    @Override
    public Page<JobTitleDto> getAll(int page, int size, String sortDir, String sort) {
        Sort.Direction direction = sortDir.equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;
        Pageable pageable = sort.isEmpty() ? PageRequest.of(page, size) : PageRequest.of(page, size, direction, sort);

        return jobTitleRepository.findAll(pageable)
                .map(jobTitle -> mapper.convertToDto(jobTitle, JobTitleDto.class));
    }

    @Override
    public JobTitleDto create(JobTitleDto jobTitleDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public JobTitleDto getById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public JobTitleDto update(JobTitleDto jobTitleDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
