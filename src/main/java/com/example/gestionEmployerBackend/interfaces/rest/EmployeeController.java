package com.example.gestionEmployerBackend.interfaces.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

import com.example.gestionEmployerBackend.application.dtos.EmployeeDto;
import com.example.gestionEmployerBackend.application.service.IEmployeeService;
import com.example.gestionEmployerBackend.interfaces.mapper.GenericMapper;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private GenericMapper mapper;

    @GetMapping("/get")
    public Page<EmployeeDto> getEmployees(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "ASC") String sortDir,
            @RequestParam(defaultValue = "id") String sort) {
        return employeeService.getAll(page, size, sortDir, sort);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeDto createEmployee(@RequestBody EmployeeDto employeeDto) {
        return employeeService.create(employeeDto);
    }

    @GetMapping(value = "/getById/{id}")
    public EmployeeDto getEmployee(@PathVariable("id") Long id) {
        return employeeService.getById(id);
    }

    @PutMapping(value = "/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeDto updateEmployee(@PathVariable("id") Long id, @RequestBody EmployeeDto employeeDto) {
        employeeDto.setId(id);
        return employeeService.update(employeeDto);
    }

    @DeleteMapping(value = "/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
        return;
    }
}