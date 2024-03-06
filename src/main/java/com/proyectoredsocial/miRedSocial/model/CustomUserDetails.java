package com.proyectoredsocial.miRedSocial.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * La clase CustomUserDetails implementa la interfaz UserDetails de Spring Security
 * para proporcionar detalles específicos de un usuario personalizado.
 */
public class CustomUserDetails implements UserDetails {

    private static final long serialVersionUID = 1L;

    /**
     * Parametro nombre de usuario
     */
    private String username;
    
    /**
     * Parametro contrasena de usuario
     */
    private String password;

    /**
     * Constructor de la clase CustomUserDetails.
     *
     * @param username Nombre de usuario del usuario.
     * @param password Contraseña del usuario.
     */
    public CustomUserDetails(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Devuelve una colección de autoridades concedidas al usuario.
     *
     * @return Colección de autoridades del usuario.
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // En este caso, se devuelve null ya que no se están gestionando las autoridades.
        return null;
    }

    /**
     * Devuelve la contraseña del usuario.
     *
     * @return Contraseña del usuario.
     */
    @Override
    public String getPassword() {
        return password;
    }

    /**
     * Devuelve el nombre de usuario del usuario.
     *
     * @return Nombre de usuario del usuario.
     */
    @Override
    public String getUsername() {
        return username;
    }

    /**
     * Indica si la cuenta del usuario ha expirado.
     *
     * @return true si la cuenta no ha expirado, false en caso contrario.
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * Indica si la cuenta del usuario está bloqueada.
     *
     * @return true si la cuenta no está bloqueada, false en caso contrario.
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * Indica si las credenciales del usuario han expirado.
     *
     * @return true si las credenciales no han expirado, false en caso contrario.
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * Indica si el usuario está habilitado.
     *
     * @return true si el usuario está habilitado, false en caso contrario.
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}
