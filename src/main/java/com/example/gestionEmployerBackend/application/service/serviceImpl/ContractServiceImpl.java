package com.example.gestionEmployerBackend.application.service.serviceImpl;

import org.springframework.stereotype.Service;

import com.example.gestionEmployerBackend.application.dtos.ContractDto;
import com.example.gestionEmployerBackend.application.service.iService.IContractService;
import com.example.gestionEmployerBackend.application.utils.BaseServiceImpl;
import com.example.gestionEmployerBackend.domain.model.Contract;
import com.example.gestionEmployerBackend.domain.repository.ContractRepository;
import com.example.gestionEmployerBackend.interfaces.mapper.GenericMapper;

@Service
public class ContractServiceImpl extends BaseServiceImpl<Contract, ContractDto> implements IContractService {

    public ContractServiceImpl(ContractRepository contractRepository, GenericMapper mapper) {
        super(contractRepository, mapper, Contract.class, ContractDto.class);
    }

}
