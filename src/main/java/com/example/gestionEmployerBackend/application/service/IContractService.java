package com.example.gestionEmployerBackend.application.service;

import java.util.List;

import com.example.gestionEmployerBackend.domain.model.Contract;

public interface IContractService {

    // public List<Contract> getContractList(int page, int size, String sortDir,
    // String sort) {
    // PageRequest pageReq = PageRequest.of(page, size,
    // Sort.Direction.fromString(sortDir), sort);

    // Page<Contract> contract = contractRepository
    // .findByUser(userService.getCurrentUser(), pageReq);
    // return posts.getContent();

    // }

    // Créer un nouveau contrat
    Contract createContract(Contract contract);

    // Obtenir un contrat par ID
    Contract getContractById(Long id);

    // Mettre à jour un contrat
    Contract updateContract(Contract contract);

    // Supprimer un contrat par ID
    void deleteContractById(Long id);

    // Obtenir une liste de contrats avec pagination et tri
    List<Contract> getContractsList(int page, int size, String sortDir, String sort);
}
