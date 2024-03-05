package com.proyectoredsocial.miRedSocial.services;

import com.proyectoredsocial.miRedSocial.dtos.request.LoginRequest;
import com.proyectoredsocial.miRedSocial.dtos.request.RegistroRequest;
import com.proyectoredsocial.miRedSocial.dtos.response.JwtAuthenticationResponse;

/**
 * Interfaz que define los métodos para la autenticación de usuarios.
 */
public interface AuthenticationService {

    /**
     * Registra a un nuevo usuario y genera una respuesta de autenticación JWT.
     *
     * @param request La información del usuario a registrar.
     * @return La respuesta de autenticación JWT.
     */
    JwtAuthenticationResponse signup(RegistroRequest request);

    /**
     * Autentica a un usuario existente y genera una respuesta de autenticación JWT.
     *
     * @param request La información del usuario para iniciar sesión.
     * @return La respuesta de autenticación JWT.
     */
    JwtAuthenticationResponse signin(LoginRequest request);
}
