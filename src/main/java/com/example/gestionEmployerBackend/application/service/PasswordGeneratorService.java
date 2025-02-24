package com.example.gestionEmployerBackend.application.service;

import java.security.SecureRandom;
import java.util.Random;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordGeneratorService {

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+";
    private static final int PASSWORD_LENGTH = 10; // Longueur du mot de passe généré
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // Générer un mot de passe aléatoire
    public String generateRandomPassword() {
        Random random = new SecureRandom();
        StringBuilder password = new StringBuilder(PASSWORD_LENGTH);

        for (int i = 0; i < PASSWORD_LENGTH; i++) {
            password.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }

        return password.toString();
    }

    // Générer et encoder un mot de passe
    public String generateAndEncodePassword() {
        String rawPassword = generateRandomPassword();
        return passwordEncoder.encode(rawPassword);
    }
}
