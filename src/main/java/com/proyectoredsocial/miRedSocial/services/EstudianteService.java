package com.proyectoredsocial.miRedSocial.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.proyectoredsocial.miRedSocial.model.Estudiante;

public interface EstudianteService {
	
	Page<Estudiante> getAllEstudiantes(Pageable pageable);
	Optional<Estudiante> getEstudianteById(Long id);
	Estudiante saveEstudiante(Estudiante estudiante);
	Boolean deleteEstudiante(Long id);
	Estudiante updateEstudiante(Long id, Estudiante estudiante);
	
}
