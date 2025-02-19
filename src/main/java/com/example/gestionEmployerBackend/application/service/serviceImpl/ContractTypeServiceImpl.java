package com.example.gestionEmployerBackend.application.service.serviceImpl;

import org.springframework.stereotype.Service;

import com.example.gestionEmployerBackend.application.dtos.ContractTypeDto;
import com.example.gestionEmployerBackend.application.service.iService.IContractTypeService;
import com.example.gestionEmployerBackend.application.utils.BaseServiceImpl;
import com.example.gestionEmployerBackend.domain.model.ContractType;
import com.example.gestionEmployerBackend.domain.repository.ContractTypeRepository;
import com.example.gestionEmployerBackend.interfaces.mapper.GenericMapper;

@Service
public class ContractTypeServiceImpl extends BaseServiceImpl<ContractType, ContractTypeDto>
        implements IContractTypeService {

    public ContractTypeServiceImpl(ContractTypeRepository contractTypeRepository, GenericMapper mapper) {
        super(contractTypeRepository, mapper, ContractType.class, ContractTypeDto.class);
    }

}