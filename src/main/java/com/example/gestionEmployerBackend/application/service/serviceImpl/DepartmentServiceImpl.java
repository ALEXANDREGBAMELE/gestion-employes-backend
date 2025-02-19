package com.example.gestionEmployerBackend.application.service.serviceImpl;

import org.springframework.stereotype.Service;

import com.example.gestionEmployerBackend.application.dtos.DepartmentDto;
import com.example.gestionEmployerBackend.application.service.iService.IDepartmentService;
import com.example.gestionEmployerBackend.application.utils.BaseServiceImpl;
import com.example.gestionEmployerBackend.domain.model.Department;
import com.example.gestionEmployerBackend.domain.repository.DepartmentRepository;
import com.example.gestionEmployerBackend.interfaces.mapper.GenericMapper;

@Service
public class DepartmentServiceImpl extends BaseServiceImpl<Department, DepartmentDto> implements IDepartmentService {

    public DepartmentServiceImpl(DepartmentRepository departmentRepository, GenericMapper mapper) {
        super(departmentRepository, mapper, Department.class, DepartmentDto.class);
    }
}
