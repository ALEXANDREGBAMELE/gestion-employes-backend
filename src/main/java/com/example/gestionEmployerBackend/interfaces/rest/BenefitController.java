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

import com.example.gestionEmployerBackend.application.dtos.BenefitDto;
import com.example.gestionEmployerBackend.application.service.serviceImpl.BenefitServiceImpl;
import com.example.gestionEmployerBackend.interfaces.mapper.GenericMapper;

@RestController
@RequestMapping("/benefits")
@Validated
public class BenefitController {

    private static final Logger logger = LoggerFactory.getLogger(BenefitController.class);

    private final BenefitServiceImpl benefitService;
    private final GenericMapper mapper;

    public BenefitController(BenefitServiceImpl benefitService, GenericMapper mapper) {
        this.benefitService = benefitService;
        this.mapper = mapper;
    }

    @GetMapping("/getAll")
    public Page<BenefitDto> getBenefits(
            @RequestParam(required = false, defaultValue = "0", name = "page") Integer page,
            @RequestParam(required = false, defaultValue = "5", name = "size") Integer size,
            @RequestParam(required = false, defaultValue = "ASC", name = "sortDir") String sortDir,
            @RequestParam(required = false, defaultValue = "id", name = "sort") String sort) {

        return benefitService.getAll(page, size, sortDir, sort);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public BenefitDto createBenefit(@Validated @RequestBody BenefitDto benefitDto) {
        return benefitService.create(benefitDto);
    }

    @GetMapping(value = "/getById/{id}")
    public BenefitDto getBenefitById(@PathVariable("id") Long id) {
        return benefitService.getById(id);
    }

    @PutMapping(value = "/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BenefitDto updateBenefit(@PathVariable("id") Long id, @RequestBody BenefitDto benefitDto) {
        benefitDto.setId(id);
        return benefitService.update(benefitDto);
    }

    @DeleteMapping(value = "/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteBenefit(@PathVariable("id") Long id) {
        benefitService.delete(id);
    }
}