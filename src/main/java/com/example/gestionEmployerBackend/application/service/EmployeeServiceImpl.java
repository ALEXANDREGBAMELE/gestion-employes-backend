package com.example.gestionEmployerBackend.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.gestionEmployerBackend.application.dtos.EmployeeDto;
import com.example.gestionEmployerBackend.application.exception.ResourceNotFoundException;
import com.example.gestionEmployerBackend.domain.model.Employee;
import com.example.gestionEmployerBackend.domain.repository.EmployeeRepository;
import com.example.gestionEmployerBackend.interfaces.mapper.GenericMapper;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private GenericMapper mapper;

    @Override
    public EmployeeDto create(EmployeeDto employeeDto) {
        Employee employee = mapper.convertToEntity(employeeDto, Employee.class);
        Employee savEmployee = employeeRepository.save(employee);
        return mapper.convertToDto(savEmployee, EmployeeDto.class);
    }

    @Override
    public EmployeeDto update(EmployeeDto employeeDto) {
        Employee employee = mapper.convertToEntity(employeeDto, Employee.class);
        Employee saveEmployee = employeeRepository.save(employee);
        return mapper.convertToDto(saveEmployee, EmployeeDto.class);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Page<EmployeeDto> getAll(int page, int size, String sortDir, String sort) {

        Pageable pageable = PageRequest.of(page, size);
        Page<Employee> employeePage = employeeRepository.findAll(pageable);

        Page<EmployeeDto> employeeDtoPage = employeePage
                .map(employee -> mapper.convertToDto(employee, EmployeeDto.class));

        return employeeDtoPage;
    }

    @Override
    public EmployeeDto getById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));

        return mapper.convertToDto(employee, EmployeeDto.class);
    }

}
