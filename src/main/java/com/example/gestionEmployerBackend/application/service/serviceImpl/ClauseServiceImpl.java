package com.example.gestionEmployerBackend.application.service.serviceImpl;

import org.springframework.stereotype.Service;

import com.example.gestionEmployerBackend.application.dtos.ClauseDto;
import com.example.gestionEmployerBackend.application.service.iService.IClauseService;
import com.example.gestionEmployerBackend.application.utils.BaseServiceImpl;
import com.example.gestionEmployerBackend.domain.model.Clause;
import com.example.gestionEmployerBackend.domain.repository.ClauseRepository;
import com.example.gestionEmployerBackend.interfaces.mapper.GenericMapper;

@Service
public class ClauseServiceImpl extends BaseServiceImpl<Clause, ClauseDto> implements IClauseService {

    public ClauseServiceImpl(ClauseRepository clauseRepository, GenericMapper mapper) {
        super(clauseRepository, mapper, Clause.class, ClauseDto.class);
    }

}