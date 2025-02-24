package com.example.gestionEmployerBackend.infrastructure.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.gestionEmployerBackend.application.service.CustomUserDetailsService;
import com.example.gestionEmployerBackend.infrastructure.security.JwtAuthenticationFilter;
import com.example.gestionEmployerBackend.infrastructure.security.JwtUtils;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private static final Logger logger = LoggerFactory.getLogger(SecurityConfig.class);

    private final CustomUserDetailsService customUserDetailsService;
    private final JwtUtils jwtUtils;

    // private final JwtAuthenticationFilter jwtAuthenticationFilter;

    // public SecurityConfig(JwtAuthenticationFilter jwtAuthenticationFilter,
    // CustomUserDetailsService customUserDetailsService) {
    // this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    // this.customUserDetailsService = customUserDetailsService;
    // }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http, PasswordEncoder passwordEncoder)
            throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = http
                .getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder);
        return authenticationManagerBuilder.build();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Désactiver CSRF pour l'API REST
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // Désactiver
                                                                                                              // les
                                                                                                              // sessions
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/v1/auth/**", "/swagger-ui/**")
                        .permitAll() // Permettre l'accès libre aux endpoints d'authentification
                        .requestMatchers("/admin/**").hasRole("ADMIN") // Restreindre aux administrateurs
                        .anyRequest().authenticated() // Toute autre requête nécessite une authentification
                )
                .addFilterBefore(new JwtAuthenticationFilter(
                        jwtUtils, customUserDetailsService), UsernamePasswordAuthenticationFilter.class); // Ajouter le
                                                                                                          // filtre JWT

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
