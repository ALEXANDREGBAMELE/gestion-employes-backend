package com.example.gestionEmployerBackend.application.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.gestionEmployerBackend.application.dtos.ContractDto;
import com.example.gestionEmployerBackend.domain.model.Contract;

public interface IContractService {

    // Créer un nouveau contrat
    Contract createContract(Contract contract);

    // Obtenir un contrat par ID
    ContractDto getContractById(Long id);

    // Mettre à jour un contrat
    Contract updateContract(Contract contract);

    // Supprimer un contrat par ID
    void deleteContractById(Long id);

    // Obtenir une liste de contrats avec pagination et tri
    List<Contract> getContractsList();

    Page<ContractDto> getAll(int size, int page);
}
