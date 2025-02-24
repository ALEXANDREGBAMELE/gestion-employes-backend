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
import com.example.gestionEmployerBackend.application.service.serviceImpl.UserServiceImpl;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    // GET all users
    @GetMapping("/getAll")
    public ResponseEntity<Page<CustomUserDto>> getAllUsers(
            @RequestParam(required = false, defaultValue = "0", name = "page") Integer page,
            @RequestParam(required = false, defaultValue = "5", name = "size") Integer size,
            @RequestParam(required = false, defaultValue = "ASC", name = "sortDir") String sortDir,
            @RequestParam(required = false, defaultValue = "id", name = "sort") String sort) {
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
    @PostMapping("/create")
    public ResponseEntity<CustomUserDto> createUser(@RequestBody CustomUserDto userDto) {
        CustomUserDto createdUser = userService.create(userDto);
        return ResponseEntity.status(201).body(createdUser); // 201 for created resource
    }

    // PUT to update an existing user
    @PutMapping("/update/{id}")
    public ResponseEntity<CustomUserDto> updateUser(@PathVariable Long id, @RequestBody CustomUserDto userDto) {
        userDto.setId(id); // Setting the user ID for update
        CustomUserDto updatedUser = userService.update(userDto);
        return ResponseEntity.ok(updatedUser);
    }

    // DELETE a user
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build(); // 204 for successful deletion
    }

    // @PostConstruct
    // public void init() {
    // System.out.println("Je m'exécute tout seul...");
    // userService.updatePassword("alex.gbamele", "frais100");
    // }

    // @PostMapping("/first-login")
    // public ResponseEntity<String> firstLogin(@RequestBody FirstLoginRequest
    // request) {
    // userService.setFirstPassword(request.getEmail(), request.getNewPassword());
    // return ResponseEntity.ok("Mot de passe créé avec succès !");
    // }

    // @PostMapping("/forgot-password")
    // public ResponseEntity<String> forgotPassword(@RequestBody
    // ForgotPasswordRequest request) {
    // userService.sendPasswordResetToken(request.getEmail());
    // return ResponseEntity.ok("Un email avec un lien de réinitialisation a été
    // envoyé.");
    // }

    // @PostMapping("/reset-password")
    // public ResponseEntity<String> resetPassword(@RequestBody ResetPasswordRequest
    // request) {
    // userService.resetPassword(request.getToken(), request.getNewPassword());
    // return ResponseEntity.ok("Mot de passe réinitialisé avec succès !");
    // }
}
