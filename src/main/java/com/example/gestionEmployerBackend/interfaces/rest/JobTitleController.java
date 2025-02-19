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

import com.example.gestionEmployerBackend.application.dtos.JobTitleDto;
import com.example.gestionEmployerBackend.application.service.serviceImpl.JobTitleServiceImpl;
import com.example.gestionEmployerBackend.interfaces.mapper.GenericMapper;

@RestController
@RequestMapping("/jobTitle")
@Validated
public class JobTitleController {

    private static final Logger logger = LoggerFactory.getLogger(JobTitleController.class);

    private final JobTitleServiceImpl jobTitleService;
    private final GenericMapper mapper;

    public JobTitleController(JobTitleServiceImpl jobTitleService, GenericMapper mapper) {
        this.jobTitleService = jobTitleService;
        this.mapper = mapper;
    }

    @GetMapping("/getAll")
    public Page<JobTitleDto> getJobTitles(
            @RequestParam(required = false, defaultValue = "0", name = "page") Integer page,
            @RequestParam(required = false, defaultValue = "5", name = "size") Integer size,
            @RequestParam(required = false, defaultValue = "ASC", name = "sortDir") String sortDir,
            @RequestParam(required = false, defaultValue = "id", name = "sort") String sort) {

        return jobTitleService.getAll(page, size, sortDir, sort);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public JobTitleDto createJobTitle(@Validated @RequestBody JobTitleDto jobTitleDto) {
        return jobTitleService.create(jobTitleDto);
    }

    @GetMapping(value = "/getById/{id}")
    public JobTitleDto getJobTitleById(@PathVariable("id") Long id) {
        return jobTitleService.getById(id);
    }

    @PutMapping(value = "/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public JobTitleDto updateJobTitle(@PathVariable("id") Long id, @RequestBody JobTitleDto jobTitleDto) {
        jobTitleDto.setId(id);
        return jobTitleService.update(jobTitleDto);
    }

    @DeleteMapping(value = "/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteJobTitle(Long id) {
        jobTitleService.delete(id);
        return;
    }
}
