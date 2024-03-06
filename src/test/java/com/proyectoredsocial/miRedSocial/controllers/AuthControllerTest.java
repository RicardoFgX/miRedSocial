package com.proyectoredsocial.miRedSocial.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.proyectoredsocial.miRedSocial.controller.AuthController;
import com.proyectoredsocial.miRedSocial.dtos.request.LoginRequest;
import com.proyectoredsocial.miRedSocial.dtos.request.RegistroRequest;
import com.proyectoredsocial.miRedSocial.dtos.response.JwtAuthenticationResponse;
import com.proyectoredsocial.miRedSocial.services.AuthenticationService;

public class AuthControllerTest {

    @Test
    void testRegistro_Exitoso() {
        AuthenticationService authenticationService = mock(AuthenticationService.class);
        RegistroRequest request = new RegistroRequest("Ricardo", "Fernandez", "ricardo@example.com", "1234");
        JwtAuthenticationResponse expectedResponse = new JwtAuthenticationResponse("jwtToken");
        when(authenticationService.signup(request)).thenReturn(expectedResponse);

        AuthController controller = new AuthController();
        controller.authenticationService = authenticationService;

        ResponseEntity<JwtAuthenticationResponse> responseEntity = controller.signup(request);

        verify(authenticationService).signup(request);
        assertSame(expectedResponse, responseEntity.getBody());
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    void testLogin_Exitoso() {
        AuthenticationService authenticationService = mock(AuthenticationService.class);
        LoginRequest request = new LoginRequest("ricardo@example.com", "1234");
        JwtAuthenticationResponse expectedResponse = new JwtAuthenticationResponse("jwtToken");
        when(authenticationService.signin(request)).thenReturn(expectedResponse);

        AuthController controller = new AuthController();
        controller.authenticationService = authenticationService;

        ResponseEntity<JwtAuthenticationResponse> responseEntity = controller.signin(request);

        verify(authenticationService).signin(request);
        assertSame(expectedResponse, responseEntity.getBody());
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }
}
