package com.example.gestionEmployerBackend.application.service;

import org.springframework.stereotype.Service;

@Service
public class AuthService {
    /**
     * private final CustomUserRepository customUserRepository;
     * private final PasswordEncoder passwordEncoder;
     * 
     * @Value("${jwt.secret}")
     * private String jwtSecret;
     * 
     * @Value("${jwt.expiration.ms}")
     * private Long jwtExpirationMs;
     * 
     * public AuthService(CustomUserRepository customUserRepository, PasswordEncoder
     * passwordEncoder) {
     * this.customUserRepository = customUserRepository;
     * this.passwordEncoder = passwordEncoder;
     * }
     * 
     * public String authenticate(LoginRequestDto loginRequest) {
     * CustomUser user =
     * customUserRepository.findByUsername(loginRequest.getUsername())
     * .orElseThrow(() -> new RuntimeException("User not found"));
     * 
     * if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword()))
     * {
     * throw new RuntimeException("Invalid password");
     * }
     * 
     * return generateToken(user);
     * }
     * 
     * private String generateToken(CustomUser user) {
     * return Jwts.builder()
     * .setSubject(user.getUsername())
     * .setIssuedAt(new Date())
     * .setExpiration(new Date(new Date().getTime() + jwtExpirationMs))
     * .signWith(SignatureAlgorithm.HS512, jwtSecret)
     * .compact();
     * }
     **/
}
