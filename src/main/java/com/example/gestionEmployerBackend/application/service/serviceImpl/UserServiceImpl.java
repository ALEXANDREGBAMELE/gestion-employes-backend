package com.example.gestionEmployerBackend.application.service.serviceImpl;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.gestionEmployerBackend.application.dtos.CustomUserDto;
import com.example.gestionEmployerBackend.application.service.PasswordGeneratorService;
import com.example.gestionEmployerBackend.application.service.iService.IUserService;
import com.example.gestionEmployerBackend.application.utils.BaseServiceImpl;
import com.example.gestionEmployerBackend.domain.model.CustomUser;
import com.example.gestionEmployerBackend.domain.model.Role;
import com.example.gestionEmployerBackend.domain.repository.RoleRepository;
import com.example.gestionEmployerBackend.domain.repository.UserRepository;
import com.example.gestionEmployerBackend.interfaces.mapper.GenericMapper;

@Service
public class UserServiceImpl extends BaseServiceImpl<CustomUser, CustomUserDto> implements IUserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordGeneratorService passwordGeneratorService;
    private final BCryptPasswordEncoder passwordEncoder;
    private final GenericMapper mapper;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository,
            GenericMapper mapper, PasswordGeneratorService passwordGeneratorService) {
        super(userRepository, mapper, CustomUser.class, CustomUserDto.class);
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordGeneratorService = passwordGeneratorService;
        this.passwordEncoder = new BCryptPasswordEncoder();
        this.mapper = mapper;
    }

    @Transactional
    public CustomUserDto createUser(CustomUserDto userDto) {
        validateUserUniqueness(userDto);

        // Générer et encoder un mot de passe sécurisé
        String rawPassword = passwordGeneratorService.generateRandomPassword();
        String encodedPassword = passwordEncoder.encode(rawPassword);

        // Assigner les rôles à l'utilisateur
        Set<Role> roles = assignRoles(userDto);

        // Construire et enregistrer l'utilisateur
        CustomUser user = mapper.convertToEntity(userDto, CustomUser.class);
        user.setPassword(encodedPassword);
        user.setIsActive(true);
        user.setRoles(roles.stream().toList());

        CustomUser savedUser = userRepository.save(user);
        CustomUserDto savedUserDto = mapper.convertToDto(savedUser, CustomUserDto.class);

        // Envoyer l'email avec le mot de passe généré (à implémenter)
        System.out.println("Mot de passe généré pour " + user.getEmail() + " : " + rawPassword);

        return savedUserDto;
    }

    private void validateUserUniqueness(CustomUserDto userDto) {
        if (userRepository.existsByEmail(userDto.getEmail())) {
            throw new IllegalArgumentException("L'email est déjà utilisé !");
        }
        if (userRepository.existsByUsername(userDto.getUsername())) {
            throw new IllegalArgumentException("Le nom d'utilisateur est déjà pris !");
        }
    }

    private Set<Role> assignRoles(CustomUserDto userDto) {
        Set<Role> roles = new HashSet<>();

        if (userDto.getRoles() == null || userDto.getRoles().isEmpty()) {
            roles.add(findOrCreateRole("USER"));
            this.logger.info("Aucun rôle fourni, attribution du rôle par défaut: USER");
        } else {
            userDto.getRoles().stream()
                    .map(role -> role.getName() != null ? role.getName() : "USER") // Évite Optional
                    .map(this::findOrCreateRole)
                    .forEach(roles::add);
        }

        this.logger.info("Rôles attribués: " + roles);
        return roles;
    }

    private Role findOrCreateRole(String roleName) {
        return roleRepository.findByName(roleName)
                .orElseGet(() -> {
                    Role newRole = new Role();
                    newRole.setName(roleName);
                    return roleRepository.save(newRole);
                });
    }

    @Transactional
    public void updatePassword(String username, String rawPassword) {
        String encodedPassword = passwordEncoder.encode(rawPassword);

        CustomUser user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));

        user.setPassword(encodedPassword);
        userRepository.save(user);

        System.out.println("Mot de passe mis à jour avec succès !");
    }

    /*
     * public void setFirstPassword(String email, String newPassword) {
     * Optional<User> optionalUser = userRepository.findByEmail(email);
     * if (optionalUser.isEmpty()) {
     * throw new RuntimeException("Utilisateur non trouvé.");
     * }
     * 
     * User user = optionalUser.get();
     * 
     * if (!user.isFirstLogin()) {
     * throw new RuntimeException("Mot de passe déjà défini.");
     * }
     * 
     * user.setPassword(passwordEncoder.encode(newPassword));
     * user.setFirstLogin(false);
     * userRepository.save(user);
     * }
     */

    /*
     * @Value("${app.frontend.reset-password-url}")
     * private String resetPasswordUrl;
     * 
     * public void sendPasswordResetToken(String email) {
     * Optional<User> optionalUser = userRepository.findByEmail(email);
     * if (optionalUser.isEmpty()) {
     * throw new RuntimeException("Aucun utilisateur trouvé avec cet email.");
     * }
     * 
     * User user = optionalUser.get();
     * 
     * // Générer un token unique
     * String token = UUID.randomUUID().toString();
     * user.setResetToken(token);
     * userRepository.save(user);
     * 
     * // Construire le lien de réinitialisation
     * String resetLink = resetPasswordUrl + "?token=" + token;
     * 
     * // Envoyer l'email
     * emailService.sendEmail(user.getEmail(), "Réinitialisation de mot de passe",
     * "Cliquez sur le lien suivant pour réinitialiser votre mot de passe : " +
     * resetLink);
     * }
     */

    /*
     * public void resetPassword(String token, String newPassword) {
     * Optional<User> optionalUser = userRepository.findByResetToken(token);
     * if (optionalUser.isEmpty()) {
     * throw new RuntimeException("Token invalide ou expiré.");
     * }
     * 
     * User user = optionalUser.get();
     * user.setPassword(passwordEncoder.encode(newPassword));
     * user.setResetToken(null); // Supprimer le token après utilisation
     * userRepository.save(user);
     * }
     */
}
