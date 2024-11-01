package com.example.gestionEmployerBackend.infrastructure.config;

import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
// @EnableWebSecurity
public class SecurityConfig {

    /**
     * 
     * @Bean
     *       public JwtRequestFilter jwtRequestFilter() {
     *       return new JwtRequestFilter();
     *       }
     * 
     *       // Configuration du SecurityFilterChain
     * @Bean
     *       public SecurityFilterChain securityFilterChain(HttpSecurity http)
     *       throws Exception {
     *       http
     *       .csrf(AbstractHttpConfigurer::disable)
     *       .authorizeHttpRequests((requests) -> requests
     *       .requestMatchers(HttpMethod.POST, "/api/v1/users/register",
     *       "/api/v1/user/login", "/api/v1/public/**").permitAll() // Permet
     *       l'accès public
     *       .anyRequest().authenticated() // Exige une authentification pour les
     *       autres requêtes
     *       )
     *       .addFilterBefore(jwtRequestFilter(),
     *       UsernamePasswordAuthenticationFilter.class); // Ajoute le filtre JWT
     *       return http.build();
     *       }
     * 
     *       // Utilisation de AuthenticationConfiguration pour la configuration
     *       d'AuthenticationManager
     * @Bean
     *       public AuthenticationManager
     *       authenticationManager(AuthenticationConfiguration
     *       authenticationConfiguration) throws Exception {
     *       return authenticationConfiguration.getAuthenticationManager();
     *       }
     * 
     *       // Configuration de l'utilisateur en mémoire
     * @Bean
     *       public UserDetailsService userDetailsService(PasswordEncoder
     *       passwordEncoder) {
     *       UserDetails user = User.withUsername("user")
     *       .password(passwordEncoder.encode("password"))
     *       .roles("USER")
     *       .build();
     * 
     *       UserDetails admin = User.withUsername("admin")
     *       .password(passwordEncoder.encode("adminpassword"))
     *       .roles("ADMIN")
     *       .build();
     * 
     *       return new InMemoryUserDetailsManager(user, admin); // Crée un
     *       gestionnaire d'utilisateurs en mémoire
     *       }
     * 
     *       // Bean pour encoder les mots de passe
     * @Bean
     *       public PasswordEncoder passwordEncoder() {
     *       return new BCryptPasswordEncoder(); // Utilise BCrypt pour le hachage
     *       des mots de passe
     *       }
     *
     * @return
     */
}