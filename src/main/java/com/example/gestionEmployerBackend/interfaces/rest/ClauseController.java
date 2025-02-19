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

import com.example.gestionEmployerBackend.application.dtos.ClauseDto;
import com.example.gestionEmployerBackend.application.service.serviceImpl.ClauseServiceImpl;
import com.example.gestionEmployerBackend.interfaces.mapper.GenericMapper;

@RestController
@RequestMapping("/clauses")
@Validated
public class ClauseController {

    private static final Logger logger = LoggerFactory.getLogger(ClauseController.class);

    private final ClauseServiceImpl clauseService;
    private final GenericMapper mapper;

    public ClauseController(ClauseServiceImpl clauseService, GenericMapper mapper) {
        this.clauseService = clauseService;
        this.mapper = mapper;
    }

    @GetMapping("/getAll")
    public Page<ClauseDto> getClauses(
            @RequestParam(required = false, defaultValue = "0", name = "page") Integer page,
            @RequestParam(required = false, defaultValue = "5", name = "size") Integer size,
            @RequestParam(required = false, defaultValue = "ASC", name = "sortDir") String sortDir,
            @RequestParam(required = false, defaultValue = "id", name = "sort") String sort) {

        return clauseService.getAll(page, size, sortDir, sort);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ClauseDto createClause(@Validated @RequestBody ClauseDto clauseDto) {
        return clauseService.create(clauseDto);
    }

    @GetMapping(value = "/getById/{id}")
    public ClauseDto getClauseById(@PathVariable("id") Long id) {
        return clauseService.getById(id);
    }

    @PutMapping(value = "/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClauseDto updateClause(@PathVariable("id") Long id, @RequestBody ClauseDto clauseDto) {
        clauseDto.setId(id);
        return clauseService.update(clauseDto);
    }

    @DeleteMapping(value = "/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteClause(@PathVariable("id") Long id) {
        clauseService.delete(id);
    }
}