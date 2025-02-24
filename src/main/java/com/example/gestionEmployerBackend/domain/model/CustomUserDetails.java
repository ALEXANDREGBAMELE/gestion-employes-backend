package com.example.gestionEmployerBackend.domain.model;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails implements UserDetails {

    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;
    private boolean firstLogin = true;

    // Constructeur
    public CustomUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    // Création d'une méthode statique pour transformer un utilisateur de type
    // `UserEntity` en `CustomUserDetails`
    public static CustomUserDetails fromUserEntityToCustomUserDetails(CustomUser user) {
        List<GrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
        return new CustomUserDetails(user.getUsername(), user.getPassword(), authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // On considère l'account valide
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Aucun verrouillage de compte
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Les credentials ne sont pas expirés
    }

    @Override
    public boolean isEnabled() {
        return true; // L'utilisateur est activé
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @param authorities the authorities to set
     */
    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    /**
     * @return boolean return the firstLogin
     */
    public boolean isFirstLogin() {
        return firstLogin;
    }

    /**
     * @param firstLogin the firstLogin to set
     */
    public void setFirstLogin(boolean firstLogin) {
        this.firstLogin = firstLogin;
    }

}
