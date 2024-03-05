package com.proyectoredsocial.miRedSocial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyectoredsocial.miRedSocial.model.Clase;

/**
 * Interfaz que proporciona métodos de acceso a la base de datos para la entidad Clase.
 * Utiliza Spring Data JPA y hereda de JpaRepository.
 */
public interface ClaseRepository extends JpaRepository<Clase, Long> {

    /**
     * Consulta nativa para obtener una clase al azar de la base de datos.
     *
     * @return Una Clase seleccionada al azar.
     */
    @Query(value = "SELECT * FROM clases ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Clase findRandomClass();
}
