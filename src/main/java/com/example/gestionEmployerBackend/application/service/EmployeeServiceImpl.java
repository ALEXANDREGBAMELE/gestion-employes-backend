package com.example.gestionEmployerBackend.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.gestionEmployerBackend.domain.model.Employee;
import com.example.gestionEmployerBackend.domain.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getEmployeesList(int page, int size, String sortDir, String sort) {
        Sort sortDirection = "desc".equalsIgnoreCase(sortDir) ? Sort.by(sort).descending() : Sort.by(sort).ascending();
        PageRequest pageRequest = PageRequest.of(page, size, sortDirection);
        return employeeRepository.findAll(pageRequest).getContent();
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
