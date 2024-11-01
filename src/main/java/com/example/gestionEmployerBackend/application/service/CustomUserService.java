package com.example.gestionEmployerBackend.application.service;

// import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserService {
    /**
     * private final CustomUserRepository customUserRepository;
     * private final PasswordEncoder passwordEncoder;
     * 
     * public CustomUserService(CustomUserRepository customUserRepository,
     * PasswordEncoder passwordEncoder) {
     * this.customUserRepository = customUserRepository;
     * this.passwordEncoder = passwordEncoder;
     * }
     * 
     * // Sauvegarder un utilisateur
     * public CustomUser saveUser(CustomUser user) {
     * user.setPassword(passwordEncoder.encode(user.getPassword()));
     * return customUserRepository.save(user);
     * }
     * 
     * // Trouver un utilisateur par son nom d'utilisateur
     * public Optional<CustomUser> findByUsername(String username) {
     * return customUserRepository.findByUsername(username);
     * }
     * 
     * // Trouver un utilisateur par son ID
     * public Optional<CustomUser> findById(Long id) {
     * return customUserRepository.findById(id);
     * }
     * 
     * // Récupérer la liste de tous les utilisateurs
     * public List<CustomUser> findAll() {
     * return customUserRepository.findAll();
     * }
     * 
     * // Mettre à jour un utilisateur
     * public CustomUser update(Long id, CustomUser user) {
     * return customUserRepository.findById(id)
     * .map(existingUser -> {
     * existingUser.setUsername(user.getUsername());
     * existingUser.setEmail(user.getEmail());
     * if (user.getPassword() != null && !user.getPassword().isEmpty()) {
     * existingUser.setPassword(passwordEncoder.encode(user.getPassword()));
     * }
     * existingUser.setRoles(user.getRoles());
     * return customUserRepository.save(existingUser);
     * })
     * .orElseThrow(() -> new RuntimeException("User not found with ID: " + id));
     * }
     * 
     * // Supprimer un utilisateur par son ID
     * public void delete(Long id) {
     * customUserRepository.deleteById(id);
     * }
     **/
}
