package com.example.gestionEmployerBackend.application.service;

import java.util.List;

import com.example.gestionEmployerBackend.domain.model.Employee;

public interface IEmployeeService {
    List<Employee> getEmployeesList(int page, int size, String sortDir, String sort);

    Employee createEmployee(Employee employee);

    Employee getEmployeeById(Long id);

    void updateEmployee(Employee employee);

    void deleteEmployee(Long id);
}