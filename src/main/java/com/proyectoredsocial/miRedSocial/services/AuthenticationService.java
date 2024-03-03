package com.proyectoredsocial.miRedSocial.services;

import com.proyectoredsocial.miRedSocial.dtos.request.LoginRequest;
import com.proyectoredsocial.miRedSocial.dtos.request.RegistroRequest;
import com.proyectoredsocial.miRedSocial.dtos.response.JwtAuthenticationResponse;

public interface AuthenticationService {

    JwtAuthenticationResponse signup(RegistroRequest request);

    JwtAuthenticationResponse signin(LoginRequest request);
}
