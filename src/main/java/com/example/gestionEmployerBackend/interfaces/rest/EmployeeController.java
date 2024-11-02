package com.example.gestionEmployerBackend.interfaces.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
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

import com.example.gestionEmployerBackend.application.dto.EmployeeDto;
import com.example.gestionEmployerBackend.application.service.IEmployeeService;
import com.example.gestionEmployerBackend.domain.model.Employee;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/get")
    public List<EmployeeDto> getEmployees(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "asc") String sortDir,
            @RequestParam(defaultValue = "id") String sort) {

        List<Employee> employees = employeeService.getEmployeesList(page, size, sortDir, sort);
        return employees.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeDto createEmployee(@RequestBody EmployeeDto employeeDto) {
        Employee employee = convertToEntity(employeeDto);
        Employee createdEmployee = employeeService.createEmployee(employee);
        return convertToDto(createdEmployee);
    }

    @GetMapping(value = "/getById/{id}")
    public EmployeeDto getEmployee(@PathVariable("id") Long id) {
        Employee employee = employeeService.getEmployeeById(id);
        return convertToDto(employee);
    }

    @PutMapping(value = "/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateEmployee(@PathVariable("id") Long id, @RequestBody EmployeeDto employeeDto) {
        Employee employee = convertToEntity(employeeDto);
        employee.setId(id); // Make sure to set the ID for the update
        employeeService.updateEmployee(employee);
    }

    @DeleteMapping(value = "/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
    }

    private EmployeeDto convertToDto(Employee employee) {
        return modelMapper.map(employee, EmployeeDto.class);
    }

    private Employee convertToEntity(EmployeeDto employeeDto) {
        return modelMapper.map(employeeDto, Employee.class);
    }
}