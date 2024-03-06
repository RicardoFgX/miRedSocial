package com.proyectoredsocial.miRedSocial.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;

import com.proyectoredsocial.miRedSocial.model.CustomUserDetails;
import com.proyectoredsocial.miRedSocial.servicesImpl.JwtServiceImpl;

/**
 * Clase de pruebas para la implementación del servicio JWT.
 */
@SpringBootTest
public class JwtServiceImplTest {

    @Autowired
    private JwtServiceImpl jwtService = new JwtServiceImpl();

    /**
     * Prueba la generación de un token JWT para un usuario válido.
     * Verifica que el token generado no sea nulo.
     */
    @Test
    public void testGenerarToken() {
        // Configuración de datos de prueba
        UserDetails userDetails = new CustomUserDetails("Ricardo", "1234");

        // Genera el token y verifica que no sea nulo
        String token = jwtService.generateToken(userDetails);
        assertNotNull(token);
    }

    /**
     * Prueba la validación de un token JWT válido para un usuario específico.
     * Verifica que el método devuelve true.
     */
    @Test
    public void testEsValidoToken_TokenValido() {
        // Configuración de datos de prueba
        UserDetails userDetails = new CustomUserDetails("Ricardo", "1234");

        // Genera el token y verifica que sea válido para el usuario especificado
        String token = jwtService.generateToken(userDetails);
        boolean isValid = jwtService.isTokenValid(token, userDetails);
        assertTrue(isValid);
    }

    /**
     * Prueba la validación de un token JWT para un usuario diferente al especificado durante la generación.
     * Verifica que el método devuelve false.
     */
    @Test
    public void testIsTokenValid_UsuarioIncorrecto() {
        // Configuración de datos de prueba
        UserDetails userDetails = new CustomUserDetails("Ricardo", "1234");
        UserDetails invalidUserDetails = new CustomUserDetails("Pedro", "1234");

        // Genera el token y verifica que no sea válido para el usuario incorrecto
        String token = jwtService.generateToken(userDetails);
        boolean isValid = jwtService.isTokenValid(token, invalidUserDetails);
        assertFalse(isValid);
    }
}
