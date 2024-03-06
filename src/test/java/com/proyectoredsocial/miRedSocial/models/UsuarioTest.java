package com.proyectoredsocial.miRedSocial.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.proyectoredsocial.miRedSocial.model.Usuario;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

/**
 * Clase de prueba unitaria para la clase Usuario.
 */
public class UsuarioTest {

    private static Validator validator;

    /**
     * Configura el validador antes de ejecutar las pruebas.
     */
    @BeforeAll
    public static void setUpValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    /**
     * Prueba para un objeto Usuario válido.
     */
    @Test
    void testUsuario_Valid() {
        Usuario usuario = new Usuario();
        usuario.setNombre("Ricardo");
        usuario.setApellidos("Fernandez");
        usuario.setEmail("ricardo@example.com");
        usuario.setContrasena("1234");

        Set<ConstraintViolation<Usuario>> violations = validator.validate(usuario);

        assertTrue(violations.isEmpty());
    }

    /**
     * Prueba para un objeto Usuario con nombre no válido.
     */
    @Test
    void testUsuario_InvalidNombre() {
        Usuario usuario = new Usuario();
        usuario.setNombre("");
        usuario.setApellidos("Fernandez");
        usuario.setEmail("ricardo@example.com");
        usuario.setContrasena("1234");

        Set<ConstraintViolation<Usuario>> violations = validator.validate(usuario);

        assertEquals(1, violations.size());
        ConstraintViolation<Usuario> violation = violations.iterator().next();
        assertEquals("El nombre no puede estar en blanco", violation.getMessage());
    }

    /**
     * Prueba para un objeto Usuario con apellidos no válidos.
     */
    @Test
    void testUsuario_InvalidApellido() {
        Usuario usuario = new Usuario();
        usuario.setNombre("Ricardo");
        usuario.setApellidos("");
        usuario.setEmail("ricardo@example.com");
        usuario.setContrasena("1234");

        Set<ConstraintViolation<Usuario>> violations = validator.validate(usuario);

        assertEquals(1, violations.size());
        ConstraintViolation<Usuario> violation = violations.iterator().next();
        assertEquals("Los apellidos no pueden estar en blanco", violation.getMessage());
    }

    /**
     * Prueba para un objeto Usuario con dirección de correo electrónico no válida.
     */
    @Test
    void testUsuario_InvalidEmail() {
        Usuario usuario = new Usuario();
        usuario.setNombre("Ricardo");
        usuario.setApellidos("Fernandez");
        usuario.setEmail("textoAleatorio");
        usuario.setContrasena("1234");

        Set<ConstraintViolation<Usuario>> violations = validator.validate(usuario);

        assertEquals(1, violations.size());
        ConstraintViolation<Usuario> violation = violations.iterator().next();
        assertEquals("La dirección de correo electrónico debe ser válida", violation.getMessage());
    }

    /**
     * Prueba para un objeto Usuario con contraseña no válida.
     */
    @Test
    void testUsuario_InvalidContrasena() {
        Usuario usuario = new Usuario();
        usuario.setNombre("Ricardo");
        usuario.setApellidos("Fernandez");
        usuario.setEmail("ricardo@example.com");
        usuario.setContrasena("");

        Set<ConstraintViolation<Usuario>> violations = validator.validate(usuario);

        assertEquals(1, violations.size());
        ConstraintViolation<Usuario> violation = violations.iterator().next();
        assertEquals("La contraseña no puede estar en blanco", violation.getMessage());
    }
}
