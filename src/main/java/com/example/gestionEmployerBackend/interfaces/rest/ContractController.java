package com.example.gestionEmployerBackend.interfaces.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.gestionEmployerBackend.application.dtos.ContractCreateDto;
import com.example.gestionEmployerBackend.application.dtos.ContractDto;
import com.example.gestionEmployerBackend.application.service.serviceImpl.ContractServiceImpl;

@RestController
@RequestMapping("/contract")
public class ContractController {
    private static final Logger logger = LoggerFactory.getLogger(ContractController.class);

    private final ContractServiceImpl contractService;

    public ContractController(ContractServiceImpl contractService) {
        this.contractService = contractService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<Page<ContractDto>> getContracts(
            @RequestParam(required = false, defaultValue = "0", name = "page") Integer page,
            @RequestParam(required = false, defaultValue = "5", name = "size") Integer size,
            @RequestParam(required = false, defaultValue = "ASC", name = "sortDir") String sortDir,
            @RequestParam(required = false, defaultValue = "id", name = "sort") String sort) {

        // Utilisez les paramètres de requête pour appeler le service
        Page<ContractDto> contracts = contractService.getAll(page, size, sortDir, sort);
        return ResponseEntity.ok(contracts);
    }

    // POST to create a new contract
    @PostMapping("/create")
    public ResponseEntity<ContractDto> createContract(@RequestBody ContractCreateDto contractCreateDto) {
        ContractDto contractCreated = contractService.createContract(contractCreateDto);
        return ResponseEntity.status(201).body(contractCreated); // 201 for created resource
    }

    // GET a specific contract by ID
    @GetMapping("/getById/{id}")
    public ResponseEntity<ContractDto> getContract(@PathVariable("id") Long id) {
        ContractDto contractDto = contractService.getById(id);
        if (contractDto != null) {
            return ResponseEntity.ok(contractDto);
        } else {
            return ResponseEntity.notFound().build(); // 404 if contract not found
        }
    }

    // PUT to update an existing contract
    @PutMapping("/update/{id}")
    public ResponseEntity<ContractDto> updateContract(@PathVariable("id") Long id,
            @RequestBody ContractDto contractDto) {
        if (!id.equals(contractDto.getId())) {
            return ResponseEntity.badRequest().build(); // 400 for ID mismatch
        }
        ContractDto updatedContractDto = contractService.update(contractDto);
        return ResponseEntity.ok(updatedContractDto);
    }

    // DELETE a contract
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteContract(@PathVariable("id") Long id) {
        try {
            contractService.delete(id);
            return ResponseEntity.noContent().build(); // 204 for successful deletion
        } catch (Exception e) {
            return ResponseEntity.notFound().build(); // 404 if contract not found
        }
    }

}
