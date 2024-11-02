package com.example.gestionEmployerBackend.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.gestionEmployerBackend.domain.model.Contract;
import com.example.gestionEmployerBackend.domain.repository.ContractRepository;

@Service
public class ContractServiceImpl implements IContractService {

    @Autowired
    private ContractRepository contractRepository;

    @Override
    public Contract createContract(Contract contract) {
        return contractRepository.save(contract);
    }

    @Override
    public Contract getContractById(Long id) {
        return contractRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contract not found with id: " + id));
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
    public List<Contract> getContractsList(int page, int size, String sortDir, String sort) {
        Sort.Direction direction = Sort.Direction.fromString(sortDir);
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(direction, sort));
        return contractRepository.findAll(pageRequest).getContent();
    }

}
