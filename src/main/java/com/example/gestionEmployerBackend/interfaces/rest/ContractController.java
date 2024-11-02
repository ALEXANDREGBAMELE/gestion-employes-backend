package com.example.gestionEmployerBackend.interfaces.rest;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.gestionEmployerBackend.application.dto.ContractDto;
import com.example.gestionEmployerBackend.application.service.IContractService;
import com.example.gestionEmployerBackend.application.service.IUserService;
import com.example.gestionEmployerBackend.domain.model.Contract;

@RestController
@RequestMapping("/contract")
class ContractRestController {
    private static final Logger logger = LoggerFactory.getLogger(ContractRestController.class);
    @Autowired
    private IContractService contractService;

    @Autowired
    private IUserService userService;

    @Autowired
    private ModelMapper modelMapper;

    // @ResponseBody
    @GetMapping("/get")
    public List<ContractDto> getContracts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "asc") String sortDir, @RequestParam(defaultValue = "id") String sort) {
        List<Contract> contracts = contractService.getContractsList(page, size,
                sortDir, sort);
        return contracts.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());

    }

    private ContractDto convertToDto(Contract contract) {
        return modelMapper.map(contract, ContractDto.class);
    }

    private Contract convertToEntity(ContractDto contractDto) {
        return modelMapper.map(contractDto, Contract.class);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ContractDto createContract(@RequestBody ContractDto contractDto) {
        Contract contract = convertToEntity(contractDto);
        Contract contractCreated = contractService.createContract(contract);
        return convertToDto(contractCreated);

    }

    @GetMapping(value = "/getById/{id}")
    @ResponseBody
    public ContractDto getContract(@PathVariable("id") Long id) {
        return convertToDto(contractService.getContractById(id));
    }

    @PutMapping(value = "/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateContract(@PathVariable("id") Long id, @RequestBody ContractDto contractDto) {
        if (!Objects.equals(id, contractDto.getId())) {
            throw new IllegalArgumentException("IDs don't match");
        }
        Contract contract = convertToEntity(contractDto);
        contractService.updateContract(contract);
    }

    @DeleteMapping(value = "/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteContract(@PathVariable("id") Long id) {
        contractService.deleteContractById(id);
    }

    @GetMapping(value = "/gets")
    public String get() {
        return "Hello world je change un instant";
    }
}