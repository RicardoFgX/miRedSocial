package com.proyectoredsocial.miRedSocial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyectoredsocial.miRedSocial.model.Clase;

public interface ClaseRepository extends JpaRepository<Clase, Long> {
	@Query(value = "SELECT * FROM clases ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Clase findRandomClass();
}
