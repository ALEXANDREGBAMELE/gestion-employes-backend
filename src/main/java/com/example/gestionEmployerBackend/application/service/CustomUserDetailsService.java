package com.example.gestionEmployerBackend.application.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.gestionEmployerBackend.domain.model.CustomUser;
import com.example.gestionEmployerBackend.domain.model.CustomUserDetails;
import com.example.gestionEmployerBackend.domain.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository; // Ton repository pour récupérer les utilisateurs

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Trouver l'utilisateur dans la base de données
        CustomUser customUser = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Utilisateur non trouvé : " + username));

        // Transformer l'utilisateur en CustomUserDetails
        return CustomUserDetails.fromUserEntityToCustomUserDetails(customUser);
    }
}
