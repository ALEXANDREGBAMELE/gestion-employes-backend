package com.example.gestionEmployerBackend.infrastructure.security.jwt;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {
    /**
     * private final String SECRET_KEY = "secret"; // Remplacez par votre clé
     * secrète
     * private final long EXPIRATION_TIME = 1000 * 60 * 60; // 1 heure
     * 
     * public String generateToken(String username) {
     * Map<String, Object> claims = new HashMap<>();
     * return createToken(claims, username);
     * }
     * 
     * private String createToken(Map<String, Object> claims, String subject) {
     * return Jwts.builder()
     * .setClaims(claims)
     * .setSubject(subject)
     * .setIssuedAt(new Date(System.currentTimeMillis()))
     * .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
     * .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
     * .compact();
     * }
     * 
     * public String extractUsername(String token) {
     * return extractAllClaims(token).getSubject();
     * }
     * 
     * private Claims extractAllClaims(String token) {
     * return
     * Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
     * }
     * 
     * public boolean validateToken(String token, UserDetails userDetails) {
     * final String username = extractUsername(token);
     * return (username.equals(userDetails.getUsername()) &&
     * !isTokenExpired(token));
     * }
     * 
     * private boolean isTokenExpired(String token) {
     * return extractAllClaims(token).getExpiration().before(new Date());
     * }
     **/
}
