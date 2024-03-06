package com.proyectoredsocial.miRedSocial.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.proyectoredsocial.miRedSocial.model.Clase;
import com.proyectoredsocial.miRedSocial.model.Estudiante;

/**
 * Clase de prueba unitaria para la clase Clase.
 */
public class ClaseTest {

    @InjectMocks
    private Clase clase;

    @Mock
    private Estudiante estudiante;

    /**
     * Configura las anotaciones de Mockito antes de cada prueba.
     */
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Prueba para el método getId().
     */
    @Test
    void getId() {
        clase.setId(1L);
        assertEquals(1L, clase.getId());
    }

    /**
     * Prueba para el método getNombre().
     */
    @Test
    void getNombre() {
        clase.setNombre("Matematicas");
        assertEquals("Matematicas", clase.getNombre());
    }
}
