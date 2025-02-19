package com.example.gestionEmployerBackend.application.service.iService;

import org.springframework.data.domain.Page;

import com.example.gestionEmployerBackend.application.dtos.ContractTypeDto;

public interface IContractTypeService {
    // Créer un nouveau contrat
    ContractTypeDto create(ContractTypeDto contractTypeDto);

    // Obtenir un contrat par ID
    ContractTypeDto getById(Long id);

    // Mettre à jour un contrat
    ContractTypeDto update(ContractTypeDto contractTypeDto);

    // Supprimer un contrat par ID
    void delete(Long id);

    Page<ContractTypeDto> getAll(int size, int page, String sortDir, String sort);
}
