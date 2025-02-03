package com.example.gestionEmployerBackend.interfaces.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GenericMapper {

    @Autowired
    private ModelMapper modelMapper;

    // Méthode générique pour convertir une entité en DTO
    public <D, T> D convertToDto(T entity, Class<D> dtoClass) {
        return modelMapper.map(entity, dtoClass);
    }

    // Méthode générique pour convertir un DTO en entité
    public <D, T> T convertToEntity(D dto, Class<T> entityClass) {
        return modelMapper.map(dto, entityClass);
    }

    // Méthode générique pour convertir une liste d'entités en liste de DTOs
    public <D, T> List<D> convertToDtoList(List<T> entityList, Class<D> dtoClass) {
        return entityList.stream()
                .map(entity -> convertToDto(entity, dtoClass))
                .collect(Collectors.toList());
    }

    // Méthode générique pour convertir une liste de DTOs en liste d'entités
    public <D, T> List<T> convertToEntityList(List<D> dtoList, Class<T> entityClass) {
        return dtoList.stream()
                .map(dto -> convertToEntity(dto, entityClass))
                .collect(Collectors.toList());
    }
}
