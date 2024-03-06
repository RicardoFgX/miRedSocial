package com.proyectoredsocial.miRedSocial.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.proyectoredsocial.miRedSocial.model.Clase;
import com.proyectoredsocial.miRedSocial.model.Estudiante;

/**
 * Clase de prueba unitaria para la clase Estudiante.
 */
public class EstudianteTest {

    @InjectMocks
    private Estudiante estudiante;

    @Mock
    private Clase clase;

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
    void testGetId() {
        estudiante.setId(1L);
        assertEquals(1L, estudiante.getId());
    }

    /**
     * Prueba para el método getNombre().
     */
    @Test
    void testGetNombre() {
        estudiante.setNombre("Ricardo");
        assertEquals("Ricardo", estudiante.getNombre());
    }

    /**
     * Prueba para el método getApellido().
     */
    @Test
    void testGetApellido() {
        estudiante.setApellido("Fernandez");
        assertEquals("Fernandez", estudiante.getApellido());
    }

    /**
     * Prueba para el método getMatricula().
     */
    @Test
    void testGetMatricula() {
        estudiante.setMatricula("123456");
        assertEquals("123456", estudiante.getMatricula());
    }

    /**
     * Prueba para el método getEdad().
     */
    @Test
    void testGetEdad() {
        estudiante.setEdad(23);
        assertEquals(23, estudiante.getEdad());
    }

    /**
     * Prueba para el método getCiudad().
     */
    @Test
    void testGetCiudad() {
        estudiante.setCiudad("Sevilla");
        assertEquals("Sevilla", estudiante.getCiudad());
    }

    /**
     * Prueba para el método getClase().
     */
    @Test
    void testGetClase() {
        when(clase.getNombre()).thenReturn("Matematicas");
        estudiante.setClase(clase);
        assertNotNull(estudiante.getClase());
        assertEquals("Matematicas", estudiante.getClase().getNombre());
    }
}
