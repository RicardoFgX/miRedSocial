package com.proyectoredsocial.miRedSocial.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.proyectoredsocial.miRedSocial.model.Estudiante;

import java.util.Optional;

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

    /**
     * Filtra estudiantes por nombre, apellido y/o clase.
     *
     * @param nombre   El nombre a filtrar.
     * @param apellido El apellido a filtrar.
     * @param claseId  El ID de la clase a la que pertenecen los estudiantes.
     * @param pageable Configuración de paginación.
     * @return Página de estudiantes filtrados por nombre, apellido y/o clase.
     */
    Page<Estudiante> filtrarEstudiantes(String nombre, String apellido, Long claseId, Pageable pageable);
}
