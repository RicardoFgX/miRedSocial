package com.proyectoredsocial.miRedSocial.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.proyectoredsocial.miRedSocial.model.Estudiante;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz que proporciona métodos de acceso a la base de datos para la entidad Estudiante.
 * Utiliza Spring Data JPA y hereda de JpaRepository.
 */
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {

    /**
     * Busca un estudiante por su matrícula.
     *
     * @param matricula La matrícula del estudiante a buscar.
     * @return Un Optional que puede contener el estudiante con la matrícula proporcionada.
     */
    Optional<Estudiante> findByMatricula(String matricula);

    /**
     * Filtra estudiantes por nombre.
     *
     * @param nombre   El nombre a filtrar.
     * @param pageable Configuración de paginación.
     * @return Página de estudiantes filtrados por nombre.
     */
    Page<Estudiante> findByNombreContainingIgnoreCase(String nombre, Pageable pageable);

    /**
     * Filtra estudiantes por apellido.
     *
     * @param apellido El apellido a filtrar.
     * @param pageable Configuración de paginación.
     * @return Página de estudiantes filtrados por apellido.
     */
    Page<Estudiante> findByApellidoContainingIgnoreCase(String apellido, Pageable pageable);

    /**
     * Filtra estudiantes por ID de clase.
     *
     * @param claseId  El ID de la clase a la que pertenecen los estudiantes.
     * @param pageable Configuración de paginación.
     * @return Página de estudiantes filtrados por clase.
     */
    Page<Estudiante> findByClaseId(Long claseId, Pageable pageable);

    // Puedes agregar más métodos de filtrado según sea necesario
}
