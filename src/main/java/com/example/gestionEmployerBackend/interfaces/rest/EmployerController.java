package com.example.gestionEmployerBackend.interfaces.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
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

import com.example.gestionEmployerBackend.application.dtos.EmployerDto;
import com.example.gestionEmployerBackend.application.service.serviceImpl.EmployerServiceImpl;
import com.example.gestionEmployerBackend.interfaces.mapper.GenericMapper;

@RestController
@RequestMapping("/employers")
@Validated
public class EmployerController {

    private static final Logger logger = LoggerFactory.getLogger(EmployerController.class);

    private final EmployerServiceImpl employerService;
    private final GenericMapper mapper;

    public EmployerController(EmployerServiceImpl employerService, GenericMapper mapper) {
        this.employerService = employerService;
        this.mapper = mapper;
    }

    @GetMapping("/getAll")
    public Page<EmployerDto> getEmployers(
            @RequestParam(required = false, defaultValue = "0", name = "page") Integer page,
            @RequestParam(required = false, defaultValue = "5", name = "size") Integer size,
            @RequestParam(required = false, defaultValue = "ASC", name = "sortDir") String sortDir,
            @RequestParam(required = false, defaultValue = "id", name = "sort") String sort) {

        return employerService.getAll(page, size, sortDir, sort);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public EmployerDto createEmployer(@Validated @RequestBody EmployerDto employerDto) {
        return employerService.create(employerDto);
    }

    @GetMapping(value = "/getById/{id}")
    public EmployerDto getEmployerById(@PathVariable("id") Long id) {
        return employerService.getById(id);
    }

    @PutMapping(value = "/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EmployerDto updateEmployer(@PathVariable("id") Long id, @RequestBody EmployerDto employerDto) {
        employerDto.setId(id);
        return employerService.update(employerDto);
    }

    @DeleteMapping(value = "/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteEmployer(@PathVariable("id") Long id) {
        employerService.delete(id);
    }
}