package com.example.gestionEmployerBackend.interfaces.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.gestionEmployerBackend.application.dto.JobTitleDto;
import com.example.gestionEmployerBackend.application.service.IJobTitleService;
import com.example.gestionEmployerBackend.domain.model.JobTitle;

@RestController
@RequestMapping("/jobTitle")
public class JobTitleRestController {

    @Autowired
    private IJobTitleService jobTitleService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/get")
    public List<JobTitleDto> getJobTitles(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "asc") String sortDir,
            @RequestParam(defaultValue = "id") String sort) {

        List<JobTitle> jobTitles = jobTitleService.getJobTitlesList(page, size, sortDir, sort);
        return jobTitles.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public JobTitleDto createJobTitle(@RequestBody JobTitleDto jobTitleDto) {
        JobTitle jobTitle = convertToEntity(jobTitleDto);
        JobTitle createdJobTitle = jobTitleService.createJobTitle(jobTitle);
        return convertToDto(createdJobTitle);
    }

    @GetMapping(value = "/getById/{id}")
    public JobTitleDto getJobTitle(@PathVariable("id") Long id) {
        JobTitle jobTitle = jobTitleService.getJobTitleById(id);
        return convertToDto(jobTitle);
    }

    @PutMapping(value = "/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateJobTitle(@PathVariable("id") Long id, @RequestBody JobTitleDto jobTitleDto) {
        JobTitle jobTitle = convertToEntity(jobTitleDto);
        jobTitle.setId(id); // Make sure to set the ID for the update
        jobTitleService.updateJobTitle(jobTitle);
    }

    // Convert Entity to DTO
    private JobTitleDto convertToDto(JobTitle jobTitle) {
        return modelMapper.map(jobTitle, JobTitleDto.class);
    }

    // Convert DTO to Entity
    private JobTitle convertToEntity(JobTitleDto jobTitleDto) {
        return modelMapper.map(jobTitleDto, JobTitle.class);
    }

    // Exception handler
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
    }
}
