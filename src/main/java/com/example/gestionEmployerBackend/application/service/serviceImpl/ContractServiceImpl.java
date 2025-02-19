package com.example.gestionEmployerBackend.application.service.serviceImpl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.gestionEmployerBackend.application.dtos.ContractCreateDto;
import com.example.gestionEmployerBackend.application.dtos.ContractDto;
import com.example.gestionEmployerBackend.application.exception.BadRequestException;
import com.example.gestionEmployerBackend.application.utils.BaseServiceImpl;
import com.example.gestionEmployerBackend.domain.model.Contract;
import com.example.gestionEmployerBackend.domain.model.ContractType;
import com.example.gestionEmployerBackend.domain.model.Employee;
import com.example.gestionEmployerBackend.domain.model.Employer;
import com.example.gestionEmployerBackend.domain.repository.ContractRepository;
import com.example.gestionEmployerBackend.domain.repository.ContractTypeRepository;
import com.example.gestionEmployerBackend.domain.repository.EmployeeRepository;
import com.example.gestionEmployerBackend.domain.repository.EmployerRepository;
import com.example.gestionEmployerBackend.interfaces.mapper.GenericMapper;

@Service
public class ContractServiceImpl extends BaseServiceImpl<Contract, ContractDto> {

    private final ContractRepository contractRepository;
    private final EmployeeRepository employeeRepository;
    private final EmployerRepository employerRepository;
    private final ContractTypeRepository contractTypeRepository;

    public ContractServiceImpl(
            ContractRepository contractRepository,
            EmployeeRepository employeeRepository,
            EmployerRepository employerRepository,
            ContractTypeRepository contractTypeRepository,
            GenericMapper mapper) {
        super(contractRepository, mapper, Contract.class, ContractDto.class);
        this.contractRepository = contractRepository;
        this.employeeRepository = employeeRepository;
        this.employerRepository = employerRepository;
        this.contractTypeRepository = contractTypeRepository;
    }

    @Transactional
    public ContractDto createContract(ContractCreateDto contractCreateDto) {
        // Vérification des doublons
        if (contractRepository.existsByEmployeeIdAndEmployerIdAndContractTypeId(
                contractCreateDto.getEmployeeId(),
                contractCreateDto.getEmployerId(),
                contractCreateDto.getContractTypeId())) {
            throw new BadRequestException("Un contrat avec ces informations existe déjà.");
        }

        // Récupérer les entités
        Employee employee = employeeRepository.findById(contractCreateDto.getEmployeeId())
                .orElseThrow(() -> new RuntimeException("Employé non trouvé"));

        Employer employer = employerRepository.findById(contractCreateDto.getEmployerId())
                .orElseThrow(() -> new RuntimeException("Employeur non trouvé"));

        ContractType contractType = contractTypeRepository.findById(contractCreateDto.getContractTypeId())
                .orElseThrow(() -> new RuntimeException("Type de contrat non trouvé"));

        // Création et sauvegarde du contrat
        Contract contract = new Contract();
        contract.setReference(contractCreateDto.getReference());
        contract.setStartDate(contractCreateDto.getStartDate());
        contract.setEndDate(contractCreateDto.getEndDate());
        contract.setEmployee(employee);
        contract.setEmployer(employer);
        contract.setContractType(contractType);

        Contract savedContract = contractRepository.save(contract);

        return mapper.convertToDto(savedContract, ContractDto.class);
    }

    @Override
    public boolean existsByUniqueField(ContractDto dto) {
        return contractRepository.existsByEmployeeIdAndEmployerIdAndContractTypeId(
                dto.getEmployee().getId(),
                dto.getEmployer().getId(),
                dto.getContractType().getId());
    }
}
