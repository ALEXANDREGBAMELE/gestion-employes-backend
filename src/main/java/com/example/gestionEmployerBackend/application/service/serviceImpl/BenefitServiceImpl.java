package com.example.gestionEmployerBackend.application.service.serviceImpl;

import org.springframework.stereotype.Service;

import com.example.gestionEmployerBackend.application.dtos.BenefitDto;
import com.example.gestionEmployerBackend.application.service.iService.IBenefitService;
import com.example.gestionEmployerBackend.application.utils.BaseServiceImpl;
import com.example.gestionEmployerBackend.domain.model.Benefit;
import com.example.gestionEmployerBackend.domain.repository.BenefitRepository;
import com.example.gestionEmployerBackend.interfaces.mapper.GenericMapper;

@Service
public class BenefitServiceImpl extends BaseServiceImpl<Benefit, BenefitDto> implements IBenefitService {

    public BenefitServiceImpl(BenefitRepository benefitRepository, GenericMapper mapper) {
        super(benefitRepository, mapper, Benefit.class, BenefitDto.class);
    }

}
