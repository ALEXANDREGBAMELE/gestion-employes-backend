package com.example.gestionEmployerBackend.application.utils;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

public abstract class BaseController<T, DTO> {

    protected final IBaseService<T, DTO> service;

    protected BaseController(IBaseService<T, DTO> service) {
        this.service = service;
    }

    @GetMapping("/get")
    public Page<DTO> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "ASC") String sortDir,
            @RequestParam(defaultValue = "id") String sort) {
        return service.getAll(page, size, sortDir, sort);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public DTO create(@RequestBody DTO dto) {
        return service.create(dto);
    }

    @GetMapping("/getById/{id}")
    public DTO getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DTO update(@PathVariable Long id, @RequestBody DTO dto) {
        return service.update(dto);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
