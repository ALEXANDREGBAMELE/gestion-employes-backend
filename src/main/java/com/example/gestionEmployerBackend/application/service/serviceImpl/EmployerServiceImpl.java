package com.example.gestionEmployerBackend.application.service.serviceImpl;

import org.springframework.stereotype.Service;

import com.example.gestionEmployerBackend.application.dtos.EmployerDto;
import com.example.gestionEmployerBackend.application.service.iService.IEmployerService;
import com.example.gestionEmployerBackend.application.utils.BaseServiceImpl;
import com.example.gestionEmployerBackend.domain.model.Employer;
import com.example.gestionEmployerBackend.domain.repository.EmployerRepository;
import com.example.gestionEmployerBackend.interfaces.mapper.GenericMapper;

@Service
public class EmployerServiceImpl extends BaseServiceImpl<Employer, EmployerDto> implements IEmployerService {

    public EmployerServiceImpl(EmployerRepository employerRepository, GenericMapper mapper) {
        super(employerRepository, mapper, Employer.class, EmployerDto.class);
    }

}