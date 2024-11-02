package com.example.gestionEmployerBackend.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
// import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.gestionEmployerBackend.domain.model.CustomUser;
import com.example.gestionEmployerBackend.domain.repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public CustomUser createUser(CustomUser user) {
        return userRepository.save(user);
    }

    @Override
    public CustomUser getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    @Override
    public CustomUser updateUser(CustomUser user) {
        if (!userRepository.existsById(user.getId())) {
            throw new RuntimeException("User not found with id: " + user.getId());
        }
        return userRepository.save(user);
    }

    @Override
    public void deleteUserById(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found with id: " + id);
        }
        userRepository.deleteById(id);
    }

    @Override
    public List<CustomUser> getUsersList(int page, int size, String sortDir, String sort) {
        Sort.Direction direction = Sort.Direction.fromString(sortDir);
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(direction, sort));
        return userRepository.findAll(pageRequest).getContent();
    }

}