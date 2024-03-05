package com.proyectoredsocial.miRedSocial.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.proyectoredsocial.miRedSocial.exceptions.EstudianteNoEncontradoException;
import com.proyectoredsocial.miRedSocial.model.Estudiante;
import com.proyectoredsocial.miRedSocial.repository.EstudianteRepository;
import com.proyectoredsocial.miRedSocial.services.EstudianteService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EstudianteServiceImpl implements EstudianteService {

    @Autowired
    EstudianteRepository estudianteRepository;

    @Override
    public Estudiante saveEstudiante(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    @Override
    public Optional<Estudiante> getEstudianteById(Long id) {
    	return estudianteRepository.findById(id);
    }

    @Override
    public Page<Estudiante> getAllEstudiantes(Pageable pageable) {
        return estudianteRepository.findAll(pageable);

    }

    @Override
    public Estudiante updateEstudiante(Long id, Estudiante estudiante) {
        Optional<Estudiante> estudianteById = estudianteRepository.findById(id);

        if (estudianteById.isPresent()) {
            Estudiante updatedEstudiante = estudianteById.get();

            updatedEstudiante.setId(estudiante.getId());
            updatedEstudiante.setNombre(estudiante.getNombre());
            updatedEstudiante.setApellido(estudiante.getApellido());
            updatedEstudiante.setMatricula(estudiante.getMatricula());

            return estudianteRepository.save(updatedEstudiante);
        } 
        
        return null;
        

    }

    public Boolean deleteEstudiante(Long id) {
        if (estudianteRepository.existsById(id)) {
            estudianteRepository.deleteById(id);
            return true; // Si se eliminó con éxito
        } else {
            return false; // Si no se encontró el estudiante
        }
    }

}
