package com.example.gestionEmployerBackend.interfaces.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    /**
     * private final AuthService authService;
     * 
     * public AuthController(AuthService authService) {
     * this.authService = authService;
     * }
     * 
     * @PostMapping("/login")
     * public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto
     * loginRequest) {
     * String token = authService.authenticate(loginRequest);
     * LoginResponseDto response = new LoginResponseDto();
     * response.setToken(token);
     * response.setUsername(loginRequest.getUsername());
     * return ResponseEntity.ok(response);
     * }
     **/
}
