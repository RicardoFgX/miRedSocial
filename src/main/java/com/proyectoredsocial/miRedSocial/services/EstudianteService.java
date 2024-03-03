package com.proyectoredsocial.miRedSocial.services;

import java.util.List;

import com.proyectoredsocial.miRedSocial.model.Estudiante;

public interface EstudianteService {
	
	List<Estudiante> getAllEstudiantes();
	Estudiante getEstudianteById(Long id);
	Estudiante saveEstudiante(Estudiante estudiante);
	String deleteEstudiante(Long id);
	Estudiante updateEstudiante(Long id, Estudiante estudiante);
	

}
