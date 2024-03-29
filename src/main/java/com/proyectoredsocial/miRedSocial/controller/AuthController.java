package com.proyectoredsocial.miRedSocial.controller;

import com.proyectoredsocial.miRedSocial.dtos.request.LoginRequest;
import com.proyectoredsocial.miRedSocial.dtos.request.RegistroRequest;
import com.proyectoredsocial.miRedSocial.dtos.response.JwtAuthenticationResponse;

import com.proyectoredsocial.miRedSocial.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

/**
 * Controlador REST que gestiona las operaciones de autenticación y registro de usuarios.
 * Proporciona endpoints para registrar nuevos usuarios y para iniciar sesión.
 */
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    /**
     * Inyección del servicio de autenticación.
     */
    @Autowired
	public
    AuthenticationService authenticationService;

    /**
     * Registra un nuevo usuario en el sistema.
     *
     * @param request Datos de registro del nuevo usuario.
     * @return ResponseEntity que contiene la respuesta de autenticación con el token JWT.
     */
    @PostMapping("/signup")
    public ResponseEntity<JwtAuthenticationResponse> signup(@RequestBody RegistroRequest request) {
        JwtAuthenticationResponse response = authenticationService.signup(request);
        return ResponseEntity.ok(response);
    }

    /**
     * Inicia sesión para un usuario existente en el sistema.
     *
     * @param request Datos de inicio de sesión del usuario.
     * @return ResponseEntity que contiene la respuesta de autenticación con el token JWT.
     */
    @PostMapping("/signin")
    public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody LoginRequest request) {
        JwtAuthenticationResponse response = authenticationService.signin(request);
        return ResponseEntity.ok(response);
    }
}
