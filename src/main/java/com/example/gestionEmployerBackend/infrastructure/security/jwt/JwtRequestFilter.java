package com.example.gestionEmployerBackend.infrastructure.security.jwt;

import org.springframework.stereotype.Component;

@Component
// public class JwtRequestFilter extends OncePerRequestFilter {
public class JwtRequestFilter {
    /**
     * @Autowired
     *            JwtUtil jwtUtil;
     *            UserDetailsService userDetailsService;
     * 
     * @Override
     *           protected void doFilterInternal(HttpServletRequest request,
     *           HttpServletResponse response, FilterChain chain)
     *           throws ServletException, IOException {
     *           final String authorizationHeader =
     *           request.getHeader("Authorization");
     * 
     *           String username = null;
     *           String jwt = null;
     * 
     *           // Vérifier si le jeton commence par "Bearer "
     *           if (authorizationHeader != null &&
     *           authorizationHeader.startsWith("Bearer ")) {
     *           jwt = authorizationHeader.substring(7); // Retirer "Bearer "
     *           username = jwtUtil.extractUsername(jwt); // Extraire le nom
     *           d'utilisateur du jeton
     *           }
     * 
     *           // Valider le jeton et configurer le contexte de sécurité
     *           if (username != null &&
     *           SecurityContextHolder.getContext().getAuthentication() == null) {
     *           UserDetails userDetails =
     *           userDetailsService.loadUserByUsername(username);
     * 
     *           if (jwtUtil.validateToken(jwt, userDetails)) {
     *           // Créer l'authentification
     *           UsernamePasswordAuthenticationToken authenticationToken =
     *           new UsernamePasswordAuthenticationToken(userDetails, null,
     *           userDetails.getAuthorities());
     *           authenticationToken.setDetails(new
     *           WebAuthenticationDetailsSource().buildDetails(request));
     * 
     *           // Mettre à jour le contexte de sécurité
     *           SecurityContextHolder.getContext().setAuthentication(authenticationToken);
     *           }
     *           }
     * 
     *           // Continuer avec le filtre de chaîne
     *           chain.doFilter(request, response);
     *           }
     **/
}
