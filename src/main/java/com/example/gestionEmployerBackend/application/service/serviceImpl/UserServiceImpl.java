package com.example.gestionEmployerBackend.application.service.serviceImpl;

import org.springframework.stereotype.Service;

import com.example.gestionEmployerBackend.application.dtos.CustomUserDto;
import com.example.gestionEmployerBackend.application.service.iService.IUserService;
import com.example.gestionEmployerBackend.application.utils.BaseServiceImpl;
import com.example.gestionEmployerBackend.domain.model.CustomUser;
import com.example.gestionEmployerBackend.domain.repository.UserRepository;
import com.example.gestionEmployerBackend.interfaces.mapper.GenericMapper;

@Service
public class UserServiceImpl extends BaseServiceImpl<CustomUser, CustomUserDto> implements IUserService {

    public UserServiceImpl(UserRepository userRepository, GenericMapper mapper) {
        super(userRepository, mapper, CustomUser.class, CustomUserDto.class);
    }
}
