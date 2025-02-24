package com.example.gestionEmployerBackend.interfaces.rest;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.example.gestionEmployerBackend.application.service.serviceImpl.EmployeeServiceImpl;
import com.example.gestionEmployerBackend.domain.repository.EmployeeRepository;
import com.example.gestionEmployerBackend.interfaces.mapper.GenericMapper;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeServiceImpl employeeService;
    private final EmployeeRepository employeeRepository;
    private final GenericMapper mapper;

    public EmployeeController(EmployeeServiceImpl employeeService, EmployeeRepository employeeRepository,
            GenericMapper mapper) {
        this.employeeService = employeeService;
        this.employeeRepository = employeeRepository;
        this.mapper = mapper;
    }

    @GetMapping("/getAll")
    public ResponseEntity<Page<EmployeeDto>> getEmployees(
            @RequestParam(required = false, defaultValue = "0", name = "page") Integer page,
            @RequestParam(required = false, defaultValue = "5", name = "size") Integer size,
            @RequestParam(required = false, defaultValue = "ASC", name = "sortDir") String sortDir,
            @RequestParam(required = false, defaultValue = "id", name = "sort") String sort) {
        return ResponseEntity.ok(employeeService.getAll(page, size, sortDir, sort));
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
        employeeService.delete(id);
        return;
    }
}