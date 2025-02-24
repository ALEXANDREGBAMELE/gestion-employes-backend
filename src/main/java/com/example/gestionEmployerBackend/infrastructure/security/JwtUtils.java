package com.example.gestionEmployerBackend.infrastructure.security;

import java.security.Key;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtils {

    // Injection de la clé secrète depuis application.yml
    @Value("${app.secret-key}")
    private String secret_key;

    // Injection du temps d'expiration depuis application.yml (en millisecondes)
    @Value("${app.expiration-time}")
    private long expirationTime;

    // La clé est générée à partir de la clé secrète
    private Key key;

    // Initialisation de la clé secrète
    public JwtUtils() {
        this.key = Keys.hmacShaKeyFor(secret_key.getBytes());
    }

    public String generateToken(UserDetails userDetails) {
        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime)) // Utilisation de l'expiration
                                                                                      // depuis config
                .signWith(key) // Utilisation de la clé secrète
                .compact();
    }

    public String extractUsername(String token) {
        return extractClaims(token).getSubject();
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        return extractUsername(token).equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractClaims(token).getExpiration().before(new Date());
    }

    private Claims extractClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
