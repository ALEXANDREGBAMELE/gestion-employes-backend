package com.example.gestionEmployerBackend.application.service;

import java.util.List;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.gestionEmployerBackend.application.dtos.LoginRequestDto;
import com.example.gestionEmployerBackend.application.dtos.LoginResponseDto;
import com.example.gestionEmployerBackend.domain.model.CustomUser;
import com.example.gestionEmployerBackend.domain.model.CustomUserDetails;
import com.example.gestionEmployerBackend.domain.model.Role;
import com.example.gestionEmployerBackend.domain.repository.UserRepository;
import com.example.gestionEmployerBackend.infrastructure.security.JwtUtils;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j // Pour la journalisation (logs)
public class AuthService {
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtil;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    /**
     * Encode un mot de passe en clair.
     *
     * @param rawPassword Mot de passe en clair.
     * @return Mot de passe haché.
     */
    public String encodePassword(String rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }

    /**
     * Authentifie un utilisateur et génère un token JWT.
     *
     * @param loginRequestDto DTO contenant les informations de connexion.
     * @return LoginResponseDto contenant le token JWT et le nom d'utilisateur.
     * @throws RuntimeException Si l'authentification échoue ou si l'utilisateur
     *                          n'est pas trouvé.
     */
    public LoginResponseDto authenticate(LoginRequestDto loginRequestDto) {
        // Validation des entrées
        if (loginRequestDto.getUsername() == null || loginRequestDto.getPassword() == null) {
            log.error("Username or password is null");
            throw new IllegalArgumentException("Username and password must not be null");
        }

        try {
            // Tentative d'authentification
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequestDto.getUsername(),
                            loginRequestDto.getPassword()));
        } catch (BadCredentialsException e) {
            log.error("Invalid credentials for user: {}", loginRequestDto.getUsername(), e);
            throw new RuntimeException("Invalid username or password", e);
        } catch (Exception e) {
            log.error("Authentication failed for user: {}", loginRequestDto.getUsername(), e);
            throw new RuntimeException("Authentication failed", e);
        }

        try {
            // Récupération de l'utilisateur depuis la base de données
            CustomUser user = userRepository.findByUsername(loginRequestDto.getUsername())
                    .orElseThrow(() -> {
                        log.error("User not found: {}", loginRequestDto.getUsername());
                        return new RuntimeException("User not found");
                    });

            // Création des UserDetails à partir de l'entité utilisateur
            UserDetails userDetails = CustomUserDetails.fromUserEntityToCustomUserDetails(user);

            // Génération du token JWT
            String token = jwtUtil.generateToken(userDetails);

            // Retour de la réponse de connexion
            return new LoginResponseDto(token, userDetails.getUsername());
        } catch (RuntimeException e) {
            log.error("Error during authentication process for user: {}", loginRequestDto.getUsername(), e);
            throw new RuntimeException("Error during authentication process", e);
        }
    }

    /**
     * Enregistre un nouvel utilisateur.
     *
     * @param registerRequest DTO contenant les informations d'enregistrement.
     * @return CustomUser L'utilisateur enregistré.
     * @throws RuntimeException Si l'enregistrement échoue.
     */
    public CustomUser register(CustomUser registerRequest) {
        // Validation des entrées
        if (registerRequest.getUsername() == null || registerRequest.getPassword() == null) {
            log.error("Username or password is null");
            throw new IllegalArgumentException("Username and password must not be null");
        }

        try {
            // Création d'un nouvel utilisateur
            CustomUser user = new CustomUser();
            user.setUsername(registerRequest.getUsername());
            user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));

            // Conversion des noms des rôles en objets Role
            List<Role> roles = List.of(new Role("USER"));

            user.setRoles(roles);

            // Enregistrement de l'utilisateur dans la base de données
            return userRepository.save(user);
        } catch (Exception e) {
            log.error("Error during user registration for username: {}", registerRequest.getUsername(), e);
            throw new RuntimeException("Error during user registration", e);
        }
    }
}