package com.example.gestionEmployerBackend.infrastructure.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.pattern.PathPatternParser;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Value("${app.api.prefix}")
    private String apiPrefix;

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.setPatternParser(new PathPatternParser());
        configurer.addPathPrefix(apiPrefix, c -> true);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Applique CORS à toutes les routes
                .allowedOriginPatterns("*") // Autorise toutes les origines avec allowCredentials
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "PATCH") // Méthodes autorisées
                .allowedHeaders("*") // Autorise tous les en-têtes
                .allowCredentials(true); // Permet l'envoi d'informations d'authentification
    }

}
