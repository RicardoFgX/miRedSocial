package com.proyectoredsocial.miRedSocial.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.proyectoredsocial.miRedSocial.model.Estudiante;

/**
 * Interfaz que define los métodos para el servicio de gestión de estudiantes.
 */
public interface EstudianteService {

    /**
     * Obtiene una página de estudiantes paginados.
     *
     * @param pageable Configuración de paginación.
     * @return Página de estudiantes.
     */
    Page<Estudiante> getAllEstudiantes(Pageable pageable);

    /**
     * Obtiene un estudiante por su identificador.
     *
     * @param id El identificador del estudiante.
     * @return El estudiante encontrado.
     */
    Optional<Estudiante> getEstudianteById(Long id);

    /**
     * Guarda un nuevo estudiante.
     *
     * @param estudiante El estudiante a ser guardado.
     * @return El estudiante guardado.
     */
    Estudiante saveEstudiante(Estudiante estudiante);

    /**
     * Borra un estudiante por su identificador.
     *
     * @param id El identificador del estudiante a borrar.
     * @return Verdadero si se borra correctamente, falso en caso contrario.
     */
    Boolean deleteEstudiante(Long id);

    /**
     * Actualiza un estudiante existente por su identificador.
     *
     * @param id         El identificador del estudiante a actualizar.
     * @param estudiante Los datos actualizados del estudiante.
     * @return El estudiante actualizado.
     */
    Estudiante updateEstudiante(Long id, Estudiante estudiante);
}
