package com.example.gestionEmployerBackend.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.gestionEmployerBackend.application.dtos.ContractDto;
import com.example.gestionEmployerBackend.domain.model.Contract;
import com.example.gestionEmployerBackend.domain.repository.ContractRepository;
import com.example.gestionEmployerBackend.interfaces.mapper.GenericMapper;

@Service
public class ContractServiceImpl implements IContractService {

    @Autowired
    private ContractRepository contractRepository;

    @Override
    public Contract createContract(Contract contract) {
        return contractRepository.save(contract);
    }

    @Autowired
    private GenericMapper mapper;

    @Override
    public ContractDto getContractById(Long id) {
        return mapper.convertToDto(contractRepository.findById(id), ContractDto.class);
        // contractRepository.findById(id)
        // .orElseThrow(() -> new RuntimeException("Contract not found with id: " +
        // id));
    }

    @Override
    public Contract updateContract(Contract contract) {
        if (!contractRepository.existsById(contract.getId())) {
            throw new RuntimeException("Contract not found with id: " + contract.getId());
        }
        return contractRepository.save(contract);
    }

    @Override
    public void deleteContractById(Long id) {
        if (!contractRepository.existsById(id)) {
            throw new RuntimeException("Contract not found with id: " + id);
        }
        contractRepository.deleteById(id);
    }

    @Override
    public List<Contract> getContractsList() {
        return contractRepository.findAll();
    }

    @Override
    public Page<ContractDto> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Contract> contractPage = contractRepository.findAll(pageable);

        Page<ContractDto> contractDtoPage = contractPage
                .map(contract -> mapper.convertToDto(contract, ContractDto.class));

        return contractDtoPage;
    }

}
