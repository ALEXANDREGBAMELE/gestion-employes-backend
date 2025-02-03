package com.example.gestionEmployerBackend.interfaces.rest;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.gestionEmployerBackend.application.dtos.CustomUserDto;
import com.example.gestionEmployerBackend.application.service.IUserService;

@RestController
@RequestMapping("/users")
public class UserController {

    private final IUserService userService;

    // Constructor-based dependency injection
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    // GET all users
    @GetMapping("/getAll")
    public ResponseEntity<Page<CustomUserDto>> getAllUsers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "ASC") String sortDir,
            @RequestParam(defaultValue = "id") String sort) {
        // Call service with pagination parameters
        Page<CustomUserDto> users = userService.getAll(page, size, sortDir, sort);
        return ResponseEntity.ok(users);
    }

    // GET a specific user by ID
    @GetMapping("/getByID/{id}")
    public ResponseEntity<CustomUserDto> getUserById(@PathVariable Long id) {
        CustomUserDto userDto = userService.getById(id);
        return ResponseEntity.ok(userDto);
    }

    // POST to create a new user
    @PostMapping("/register")
    public ResponseEntity<CustomUserDto> createUser(@RequestBody CustomUserDto userDto) {
        CustomUserDto createdUser = userService.create(userDto);
        return ResponseEntity.status(201).body(createdUser); // 201 for created resource
    }

    // PUT to update an existing user
    @PutMapping("/{id}")
    public ResponseEntity<CustomUserDto> updateUser(@PathVariable Long id, @RequestBody CustomUserDto userDto) {
        userDto.setId(id); // Setting the user ID for update
        CustomUserDto updatedUser = userService.update(userDto);
        return ResponseEntity.ok(updatedUser);
    }

    // DELETE a user
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build(); // 204 for successful deletion
    }
}
