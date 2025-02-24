package com.example.gestionEmployerBackend.infrastructure.security;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.gestionEmployerBackend.application.service.CustomUserDetailsService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtUtils jwtUtils;
    private final CustomUserDetailsService customUserDetailsService;

    public JwtAuthenticationFilter(JwtUtils jwtUtils, CustomUserDetailsService customUserDetailsService) {
        this.jwtUtils = jwtUtils;
        this.customUserDetailsService = customUserDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        // Récupérer l'en-tête Authorization
        String authHeader = request.getHeader("Authorization");

        // Vérifier si l'en-tête commence par "Bearer "
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        // Extraire le token sans le préfixe "Bearer "
        String token = authHeader.substring(7);
        String username = jwtUtils.extractUsername(token);

        // Si le nom d'utilisateur est trouvé et que l'utilisateur n'est pas déjà
        // authentifié
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            try {
                // Charger les détails de l'utilisateur
                UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);

                // Valider le token
                if (jwtUtils.validateToken(token, userDetails)) {
                    // Créer un objet d'authentification
                    UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                            userDetails, null, userDetails.getAuthorities());
                    authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                    // Mettre l'authentification dans le contexte de sécurité
                    SecurityContextHolder.getContext().setAuthentication(authToken);
                }
            } catch (Exception e) {
                // Si une exception est levée, répondre avec une erreur 401
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().write("Token invalide ou expiré : " + e.getMessage());
                return;
            }
        }

        // Passer la requête au filtre suivant
        filterChain.doFilter(request, response);
    }
}
