package com.proyectoredsocial.miRedSocial.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyectoredsocial.miRedSocial.model.Estudiante;

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

}
