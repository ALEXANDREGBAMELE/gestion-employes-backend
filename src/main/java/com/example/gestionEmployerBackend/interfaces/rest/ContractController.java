package com.example.gestionEmployerBackend.interfaces.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.gestionEmployerBackend.application.dto.ContractDto;
import com.example.gestionEmployerBackend.application.service.IContractService;
import com.example.gestionEmployerBackend.application.utils.GenericMapper;
import com.example.gestionEmployerBackend.domain.model.Contract;

@RestController
@RequestMapping("/contract")
class ContractRestController {
    private static final Logger logger = LoggerFactory.getLogger(ContractRestController.class);
    @Autowired
    private IContractService contractService;

    @Autowired
    private GenericMapper mapper;

    @GetMapping("/get")
    public List<ContractDto> getContracts(@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "asc") String sortDir,
            @RequestParam(defaultValue = "id") String sort) {
        List<Contract> contracts = contractService.getContractsList(page, size, sortDir, sort);
        return contracts.stream()
                .map(contract -> mapper.convertToDto(contract, ContractDto.class))
                .collect(Collectors.toList());
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ContractDto createContract(@RequestBody ContractDto contractDto) {
        Contract contract = mapper.convertToEntity(contractDto, Contract.class);
        Contract contractCreated = contractService.createContract(contract);
        return mapper.convertToDto(contractCreated, ContractDto.class);
    }

    @GetMapping("/getById/{id}")
    public ContractDto getContract(@PathVariable("id") Long id) {
        return mapper.convertToDto(contractService.getContractById(id), ContractDto.class);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateContract(@PathVariable("id") Long id, @RequestBody ContractDto contractDto) {
        if (!id.equals(contractDto.getId())) {
            throw new IllegalArgumentException("IDs don't match");
        }
        Contract contract = mapper.convertToEntity(contractDto, Contract.class);
        contractService.updateContract(contract);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteContract(@PathVariable("id") Long id) {
        contractService.deleteContractById(id);
    }

    @GetMapping(value = "/gets")
    public String get() {
        return "Hello world je change un instant";
    }
}