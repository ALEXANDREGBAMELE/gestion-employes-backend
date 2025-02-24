package com.example.gestionEmployerBackend.interfaces.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gestionEmployerBackend.application.dtos.CustomUserDto;
import com.example.gestionEmployerBackend.application.dtos.LoginRequestDto;
import com.example.gestionEmployerBackend.application.dtos.LoginResponseDto;
import com.example.gestionEmployerBackend.application.service.AuthService;
import com.example.gestionEmployerBackend.application.service.serviceImpl.UserServiceImpl;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    private final UserServiceImpl userService;

    public AuthController(AuthService authService, UserServiceImpl userService) {
        this.authService = authService;
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequest) {
        return ResponseEntity.ok(authService.authenticate(loginRequest));
    }

    // @PostMapping("/register")
    // public ResponseEntity<CustomUserDto> register(@RequestBody CustomUserDto
    // registerRequest) {
    // CustomUserDto createdUser = userService.create(registerRequest);
    // return ResponseEntity.status(201).body(createdUser);
    // }

    // POST to create a new user
    @PostMapping("/register")
    public ResponseEntity<CustomUserDto> createUser(@RequestBody CustomUserDto userDto) {
        CustomUserDto createdUser = userService.create(userDto);
        return ResponseEntity.status(201).body(createdUser);
    }
}
