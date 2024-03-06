package com.proyectoredsocial.miRedSocial.services;

import com.proyectoredsocial.miRedSocial.exceptions.EstudianteNoEncontradoException;
import com.proyectoredsocial.miRedSocial.model.Estudiante;
import com.proyectoredsocial.miRedSocial.repository.EstudianteRepository;
import com.proyectoredsocial.miRedSocial.servicesImpl.EstudianteServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Esta clase contiene pruebas para evaluar el funcionamiento de EstudianteService 
 */
@SpringBootTest
public class EstudianteServiceImplTest {

    @Mock
    private EstudianteRepository estudianteRepository;

    @InjectMocks
    private EstudianteServiceImpl estudianteService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Prueba para verificar el correcto funcionamiento de la creación de un estudiante.
     * Se espera que el estudiante creado sea guardado correctamente en la base de datos.
     */
    @Test
    void guardarEstudiante() {
        Estudiante estudiante = new Estudiante();
        when(estudianteRepository.save(estudiante)).thenReturn(estudiante);

        Estudiante savedEstudiante = estudianteService.saveEstudiante(estudiante);

        assertNotNull(savedEstudiante);
        verify(estudianteRepository, times(1)).save(estudiante);
    }

    /**
     * Prueba para obtener un estudiante por su ID cuando existe en la base de datos.
     * Se espera que el estudiante recuperado sea igual al estudiante en la base de datos.
     */
    @Test
    void getEstudianteByIdExistente() {
        Estudiante estudiante = new Estudiante();
        when(estudianteRepository.findById(1L)).thenReturn(Optional.of(estudiante));

        Optional<Estudiante> estudianteRecuperado = estudianteService.getEstudianteById(1L);

        assertTrue(estudianteRecuperado.isPresent());
        assertEquals(estudiante, estudianteRecuperado.get());
        verify(estudianteRepository, times(1)).findById(1L);
    }

    /**
     * Prueba para obtener un estudiante por su ID cuando no existe en la base de datos.
     * Se espera que la operación devuelva un Optional vacío.
     */
    @Test
    void getEstudianteById_Inexistente() {
        when(estudianteRepository.findById(1L)).thenReturn(Optional.empty());

        Optional<Estudiante> estudianteRecuperado = estudianteService.getEstudianteById(1L);

        assertTrue(estudianteRecuperado.isEmpty());
        verify(estudianteRepository, times(1)).findById(1L);
    }

    /**
     * Prueba para obtener todos los estudiantes paginados.
     * Se espera que la lista paginada devuelta coincida con la proporcionada por el repositorio.
     */
    @Test
    void getAllEstudiantes() {
        Pageable pageable = mock(Pageable.class);
        List<Estudiante> estudiantesLista = new ArrayList<>();
        Page<Estudiante> estudiantesPagina = new PageImpl<>(estudiantesLista);
        when(estudianteRepository.findAll(pageable)).thenReturn(estudiantesPagina);

        Page<Estudiante> retrievedEstudiantes = estudianteService.getAllEstudiantes(pageable);

        assertEquals(estudiantesPagina, retrievedEstudiantes);
        verify(estudianteRepository, times(1)).findAll(pageable);
    }

    /**
     * Prueba para actualizar un estudiante existente en la base de datos.
     * Se espera que el estudiante actualizado sea guardado correctamente y devuelto.
     */
    @Test
    void actualizarEstudiante_Existente() {
        Estudiante estudianteExistente = new Estudiante();
        when(estudianteRepository.findById(1L)).thenReturn(Optional.of(estudianteExistente));

        Estudiante estudianteActualizado = new Estudiante();
        estudianteActualizado.setId(1L);

        when(estudianteRepository.save(any())).thenReturn(estudianteActualizado);

        Estudiante result = estudianteService.updateEstudiante(1L, estudianteActualizado);

        assertNotNull(result);
        assertEquals(estudianteActualizado.getId(), result.getId());
        verify(estudianteRepository, times(1)).findById(1L);
        verify(estudianteRepository, times(1)).save(any());
    }

    /**
     * Prueba para actualizar un estudiante que no existe en la base de datos.
     * Se espera que la operación devuelva null y que no se realice el guardado.
     */
    @Test
    void actualizarEstudiante_Inexistente() {
        when(estudianteRepository.findById(1L)).thenReturn(Optional.empty());

        Estudiante estudianteActualizado = new Estudiante();
        estudianteActualizado.setId(1L);

        Estudiante result = estudianteService.updateEstudiante(1L, estudianteActualizado);

        assertNull(result);
        verify(estudianteRepository, times(1)).findById(1L);
        verify(estudianteRepository, never()).save(any());
    }

    /**
     * Prueba para eliminar un estudiante existente por su ID.
     * Se espera que la operación devuelva true y que se realice la eliminación en la base de datos.
     */
    @Test
    void deleteEstudiante_Exists() {
        when(estudianteRepository.existsById(1L)).thenReturn(true);

        boolean respuesta = estudianteService.deleteEstudiante(1L);

        assertTrue(respuesta);
        verify(estudianteRepository, times(1)).existsById(1L);
        verify(estudianteRepository, times(1)).deleteById(1L);
    }

    /**
     * Prueba para eliminar un estudiante que no existe por su ID.
     * Se espera que la operación devuelva false y que no se realice la eliminación.
     */
    @Test
    void deleteEstudiante_NotExists() {
        when(estudianteRepository.existsById(1L)).thenReturn(false);

        boolean respuesta = estudianteService.deleteEstudiante(1L);

        assertFalse(respuesta);
        verify(estudianteRepository, times(1)).existsById(1L);
        verify(estudianteRepository, never()).deleteById(any());
    }

    /**
     * Prueba para filtrar estudiantes por nombre.
     * Se espera que la implementación del servicio llame al repositorio con el nombre proporcionado.
     */
    @Test
    void filtrarEstudiantes_Nombre() {
        Pageable pageable = mock(Pageable.class);
        Page<Estudiante> estudiantesPagina = mock(Page.class);
        when(estudianteRepository.findByNombreContainingIgnoreCase("Ricardo", pageable)).thenReturn(estudiantesPagina);

        Page<Estudiante> result = estudianteService.filtrarEstudiantes("Ricardo", null, null, pageable);

        assertEquals(estudiantesPagina, result);
        verify(estudianteRepository, times(1)).findByNombreContainingIgnoreCase("Ricardo", pageable);
        verify(estudianteRepository, never()).findByApellidoContainingIgnoreCase(any(), any());
        verify(estudianteRepository, never()).findByClaseId(any(), any());
    }

    /**
     * Prueba para filtrar estudiantes por apellido.
     * Se espera que la implementación del servicio llame al repositorio con el apellido proporcionado.
     */
    @Test
    void filtrarEstudiantes_Apellido() {
        // Arrange
        Pageable pageable = mock(Pageable.class);
        Page<Estudiante> estudiantesPagina = mock(Page.class);
        when(estudianteRepository.findByApellidoContainingIgnoreCase("Fernandez", pageable))
                .thenReturn(estudiantesPagina);

        Page<Estudiante> result = estudianteService.filtrarEstudiantes(null, "Fernandez", null, pageable);

        assertEquals(estudiantesPagina, result);
        verify(estudianteRepository, never()).findByNombreContainingIgnoreCase(any(), any());
        verify(estudianteRepository, times(1)).findByApellidoContainingIgnoreCase("Fernandez", pageable);
        verify(estudianteRepository, never()).findByClaseId(any(), any());
    }

    /**
     * Prueba para filtrar estudiantes por ID de clase.
     * Se espera que la implementación del servicio llame al repositorio con el ID de clase proporcionado.
     */
    @Test
    void filtrarEstudiantes_Clase() {
        Pageable pageable = mock(Pageable.class);
        Page<Estudiante> estudiantesPagina = mock(Page.class);
        when(estudianteRepository.findByClaseId(1L, pageable)).thenReturn(estudiantesPagina);

        Page<Estudiante> result = estudianteService.filtrarEstudiantes(null, null, 1L, pageable);

        assertEquals(estudiantesPagina, result);
        verify(estudianteRepository, never()).findByNombreContainingIgnoreCase(any(), any());
        verify(estudianteRepository, never()).findByApellidoContainingIgnoreCase(any(), any());
        verify(estudianteRepository, times(1)).findByClaseId(1L, pageable);
    }

    /**
     * Prueba para filtrar estudiantes con una entrada de filtro no válida.
     * Se espera que la operación lance una excepción IllegalArgumentException.
     */
    @Test
    void filtrarEstudiantes_InvalidInput() {
        Pageable pageable = mock(Pageable.class);

        assertThrows(IllegalArgumentException.class,
                () -> estudianteService.filtrarEstudiantes(null, null, null, pageable));
    }
}

