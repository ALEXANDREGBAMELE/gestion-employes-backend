package com.example.gestionEmployerBackend.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.gestionEmployerBackend.domain.model.Employee;
import com.example.gestionEmployerBackend.domain.model.PaginatedResponse;
import com.example.gestionEmployerBackend.domain.repository.EmployeeRepository;
import com.example.gestionEmployerBackend.interfaces.mapper.EmployeeMapper;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     * @param employeeDto
     * @return
     */
    /**
     * public EmployeeDto save(EmployeeDto employeeDto) {
     * Employee employee = employeeMapper.toEntity(employeeDto);
     * employee = employeeRepository.save(employee);
     * return employeeMapper.toDto(employee);
     * }
     **/

    public PaginatedResponse<Employee> getAllEmployees(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Employee> employeePage = employeeRepository.findAll(pageable);

        List<Employee> employee = employeePage.getContent();

        return new PaginatedResponse<>(
                employee, // Liste des employés (contenu)
                employeePage.getNumber(), // Page actuelle
                employeePage.getTotalPages(), // Nombre total de pages
                employeePage.getTotalElements() // Nombre total d'éléments
        );
    }

    /**
     * @param id
     * @return
     */
    /**
     * public EmployeeDto getEmployeeById(Long id) {
     * return employeeRepository.findById(id)
     * .map(employeeMapper::toDto)
     * .orElseThrow(() -> new RuntimeException("Employee not found"));
     * }
     **/

    /**
     * @param id
     * @param employeeDto
     * @return
     */
    /**
     * public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto) {
     * Employee employee = employeeRepository.findById(id)
     * .orElseThrow(() -> new RuntimeException("Employee not found"));
     * 
     * employee.setFirstName(employeeDto.getFirstName());
     * employee.setLastName(employeeDto.getLastName());
     * employee.setEmail(employeeDto.getEmail());
     * employee.setDepartment(employeeDto.getDepartment());
     * employee.setHireDate(employeeDto.getHireDate());
     * 
     * employeeRepository.save(employee);
     * return employeeMapper.toDto(employee);
     * }
     **/

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
