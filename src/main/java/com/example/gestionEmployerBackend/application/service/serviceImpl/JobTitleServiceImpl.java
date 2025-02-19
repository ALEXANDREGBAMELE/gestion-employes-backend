package com.example.gestionEmployerBackend.application.service.serviceImpl;

import org.springframework.stereotype.Service;

import com.example.gestionEmployerBackend.application.dtos.JobTitleDto;
import com.example.gestionEmployerBackend.application.service.iService.IJobTitleService;
import com.example.gestionEmployerBackend.application.utils.BaseServiceImpl;
import com.example.gestionEmployerBackend.domain.model.JobTitle;
import com.example.gestionEmployerBackend.domain.repository.JobTitleRepository;
import com.example.gestionEmployerBackend.interfaces.mapper.GenericMapper;

@Service
public class JobTitleServiceImpl extends BaseServiceImpl<JobTitle, JobTitleDto> implements IJobTitleService {

    public JobTitleServiceImpl(JobTitleRepository jobTitleRepository, GenericMapper mapper) {
        super(jobTitleRepository, mapper, JobTitle.class, JobTitleDto.class);
    }

}
