package com.example.gestionEmployerBackend.application.service.iService;

import org.springframework.data.domain.Page;

import com.example.gestionEmployerBackend.application.dtos.ContractDto;

public interface IContractService {

    // Créer un nouveau contrat
    ContractDto create(ContractDto contractDto);

    // Obtenir un contrat par ID
    ContractDto getById(Long id);

    // Mettre à jour un contrat
    ContractDto update(ContractDto contractDto);

    // Supprimer un contrat par ID
    void delete(Long id);

    Page<ContractDto> getAll(int size, int page, String sortDir, String sort);
}
