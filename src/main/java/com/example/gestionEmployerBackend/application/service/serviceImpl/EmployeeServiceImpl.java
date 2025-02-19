package com.example.gestionEmployerBackend.application.service.serviceImpl;

import org.springframework.stereotype.Service;

import com.example.gestionEmployerBackend.application.dtos.EmployeeDto;
import com.example.gestionEmployerBackend.application.service.iService.IEmployeeService;
import com.example.gestionEmployerBackend.application.utils.BaseServiceImpl;
import com.example.gestionEmployerBackend.domain.model.Employee;
import com.example.gestionEmployerBackend.domain.repository.EmployeeRepository;
import com.example.gestionEmployerBackend.interfaces.mapper.GenericMapper;

@Service
public class EmployeeServiceImpl extends BaseServiceImpl<Employee, EmployeeDto> implements IEmployeeService {

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, GenericMapper mapper) {
        super(employeeRepository, mapper, Employee.class, EmployeeDto.class);
    }

}
