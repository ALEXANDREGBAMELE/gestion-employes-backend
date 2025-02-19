package com.example.gestionEmployerBackend.interfaces.rest;

import java.util.HashMap;
import java.util.Map;

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

import com.example.gestionEmployerBackend.application.dtos.ContractTypeDto;
import com.example.gestionEmployerBackend.application.service.serviceImpl.ContractTypeServiceImpl;

@RestController
@RequestMapping("/contractType")
public class ContractTypeController {
    private static final Logger logger = LoggerFactory.getLogger(ContractTypeController.class);

    private final ContractTypeServiceImpl contractTypeService;

    public ContractTypeController(ContractTypeServiceImpl contractTypeService) {
        this.contractTypeService = contractTypeService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<Page<ContractTypeDto>> getContractTypes(
            @RequestParam(required = false, defaultValue = "0", name = "page") Integer page,
            @RequestParam(required = false, defaultValue = "5", name = "size") Integer size,
            @RequestParam(required = false, defaultValue = "ASC", name = "sortDir") String sortDir,
            @RequestParam(required = false, defaultValue = "id", name = "sort") String sort) {

        logger.info("Fetching all contract types with pagination and sorting");
        Page<ContractTypeDto> contractTypes = contractTypeService.getAll(page, size, sortDir, sort);
        return ResponseEntity.ok(contractTypes);
    }

    @GetMapping("/myGet")
    public ResponseEntity<Map<String, String>> get() {
        logger.info("Start get test for ContractTypeController");
        Map<String, String> response = new HashMap<>();
        response.put("message", "This is a test endpoint for ContractTypeController");
        return ResponseEntity.ok(response);
    }

    @PostMapping("/create")
    public ResponseEntity<ContractTypeDto> createContractType(@RequestBody ContractTypeDto contractTypeDto) {
        logger.info("Creating a new contract type");
        ContractTypeDto createdContractType = contractTypeService.create(contractTypeDto);
        return ResponseEntity.status(201).body(createdContractType); // 201 for created resource
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<ContractTypeDto> getContractType(@PathVariable("id") Long id) {
        logger.info("Fetching contract type with ID: {}", id);
        ContractTypeDto contractTypeDto = contractTypeService.getById(id);
        if (contractTypeDto != null) {
            return ResponseEntity.ok(contractTypeDto);
        } else {
            logger.warn("Contract type with ID {} not found", id);
            return ResponseEntity.notFound().build(); // 404 if contract type not found
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ContractTypeDto> updateContractType(@PathVariable("id") Long id,
            @RequestBody ContractTypeDto contractTypeDto) {
        logger.info("Updating contract type with ID: {}", id);
        if (!id.equals(contractTypeDto.getId())) {
            logger.warn("ID mismatch in update request for contract type");
            return ResponseEntity.badRequest().build(); // 400 for ID mismatch
        }
        ContractTypeDto updatedContractTypeDto = contractTypeService.update(contractTypeDto);
        return ResponseEntity.ok(updatedContractTypeDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteContractType(@PathVariable("id") Long id) {
        logger.info("Deleting contract type with ID: {}", id);
        try {
            contractTypeService.delete(id);
            return ResponseEntity.noContent().build(); // 204 for successful deletion
        } catch (Exception e) {
            logger.error("Error deleting contract type with ID {}: {}", id, e.getMessage());
            return ResponseEntity.notFound().build(); // 404 if contract type not found
        }
    }
}