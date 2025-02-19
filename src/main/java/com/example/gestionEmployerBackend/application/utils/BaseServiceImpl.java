package com.example.gestionEmployerBackend.application.utils;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gestionEmployerBackend.application.exception.BadRequestException;
import com.example.gestionEmployerBackend.application.exception.ResourceNotFoundException;
import com.example.gestionEmployerBackend.interfaces.mapper.GenericMapper;

public abstract class BaseServiceImpl<T, D> {

    protected final JpaRepository<T, Long> repository;
    protected final GenericMapper mapper;
    private final Class<D> dtoClass;
    private final Class<T> entityClass;

    protected BaseServiceImpl(JpaRepository<T, Long> repository, GenericMapper mapper, Class<T> entityClass,
            Class<D> dtoClass) {
        this.repository = repository;
        this.mapper = mapper;
        this.entityClass = entityClass;
        this.dtoClass = dtoClass;
    }

    public D create(D dto) {
        if (dto == null) {
            throw new BadRequestException("Invalid data provided for creation.");
        }
        T entity = mapper.convertToEntity(dto, entityClass);
        T savedEntity = repository.save(entity);
        return mapper.convertToDto(savedEntity, dtoClass);
    }

    public D update(D dto) {
        if (dto == null) {
            throw new BadRequestException("Invalid data provided for update.");
        }
        T entity = mapper.convertToEntity(dto, entityClass);
        T savedEntity = repository.save(entity);
        return mapper.convertToDto(savedEntity, dtoClass);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Entity not found with id: " + id);
        }
        repository.deleteById(id);
    }

    public Page<D> getAll(int page, int size, String sortDir, String sort) {
        Sort.Direction direction = sortDir.equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;
        Pageable pageable = sort.isEmpty() ? PageRequest.of(page, size) : PageRequest.of(page, size, direction, sort);

        Page<T> entityPage = repository.findAll(pageable);
        List<D> dtoList = entityPage.getContent().stream()
                .map(entity -> mapper.convertToDto(entity, dtoClass))
                .collect(Collectors.toList());

        return new PageImpl<>(dtoList, pageable, entityPage.getTotalElements());
    }

    public D getById(Long id) {
        T entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Entity 444 not found with id: " + id));
        return mapper.convertToDto(entity, dtoClass);
    }
}
