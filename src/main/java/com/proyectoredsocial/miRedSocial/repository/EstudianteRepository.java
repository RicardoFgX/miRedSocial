package com.proyectoredsocial.miRedSocial.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyectoredsocial.miRedSocial.model.Estudiante;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
	Optional<Estudiante> findByMatricula(String matricula);

}
