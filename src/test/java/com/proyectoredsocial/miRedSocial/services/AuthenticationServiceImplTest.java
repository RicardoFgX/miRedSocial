package com.proyectoredsocial.miRedSocial.services;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.proyectoredsocial.miRedSocial.dtos.request.LoginRequest;
import com.proyectoredsocial.miRedSocial.dtos.request.RegistroRequest;
import com.proyectoredsocial.miRedSocial.repository.UsuarioRepository;
import com.proyectoredsocial.miRedSocial.servicesImpl.AuthenticationServiceImpl;

/**
 * Clase de pruebas para la implementación del servicio de autenticación {@link AuthenticationServiceImpl}.
 *
 */
@SpringBootTest
public class AuthenticationServiceImplTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private JwtService jwtService;

    @Mock
    private AuthenticationManager authenticationManager;

    @InjectMocks
    private AuthenticationServiceImpl authenticationService;

    /**
     * Configuración que se ejecuta antes de cada prueba para inicializar los mocks.
     */
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Prueba la funcionalidad de registro cuando el correo electrónico ya existe en el sistema.
     *
     * @throws IllegalArgumentException Si el correo electrónico ya existe.
     */
    @Test
    public void testSignup_EmailExistente() {
        // Configuración de datos de prueba
        RegistroRequest request = new RegistroRequest("Ricardo", "Fernandez", "ricardo@example.com", "1234");

        // Simulación de que el correo electrónico ya existe
        when(usuarioRepository.existsByEmail(request.getEmail())).thenReturn(true);

        // Verifica que se lance la excepción esperada y que no se guarda el usuario
        assertThrows(IllegalArgumentException.class, () -> authenticationService.signup(request));

        verify(usuarioRepository, never()).save(any());
    }

    /**
     * Prueba la funcionalidad de inicio de sesión con credenciales inválidas.
     *
     * @throws IllegalArgumentException Si las credenciales son inválidas.
     */
    @Test
    public void testSignin_CredencialesInvalidas() {
        // Configuración de datos de prueba
        LoginRequest request = new LoginRequest("ricardo@example.com", "1234");

        // Simulación de autenticación fallida y usuario no encontrado
        when(authenticationManager.authenticate(any())).thenThrow(new IllegalArgumentException());
        when(usuarioRepository.findByEmail(request.getEmail())).thenReturn(Optional.empty());

        // Verifica que se lance la excepción esperada
        assertThrows(IllegalArgumentException.class, () -> authenticationService.signin(request));
    }
}
