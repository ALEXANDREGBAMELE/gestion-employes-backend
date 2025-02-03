package com.example.gestionEmployerBackend.application.service;

import org.springframework.stereotype.Service;

import com.example.gestionEmployerBackend.application.dtos.CustomUserDto;
import com.example.gestionEmployerBackend.application.utils.BaseService;
import com.example.gestionEmployerBackend.domain.model.CustomUser;
import com.example.gestionEmployerBackend.domain.repository.UserRepository;
import com.example.gestionEmployerBackend.interfaces.mapper.GenericMapper;

@Service
public class UserServiceImpl extends BaseService<CustomUser, CustomUserDto> implements IUserService {

    public UserServiceImpl(UserRepository userRepository, GenericMapper mapper) {
        super(userRepository, mapper, CustomUser.class, CustomUserDto.class);
    }
}
