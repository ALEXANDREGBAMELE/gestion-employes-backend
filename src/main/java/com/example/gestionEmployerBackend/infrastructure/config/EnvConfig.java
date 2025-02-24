package com.example.gestionEmployerBackend.infrastructure.config;

import org.springframework.stereotype.Component;

import io.github.cdimascio.dotenv.Dotenv;

@Component
public class EnvConfig {
    private static final Dotenv dotenv = Dotenv.load();

    public static String get(String key) {
        System.out.println("EnvConfig");
        return dotenv.get(key);
    }
}
