package com.proyectoredsocial.miRedSocial.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Estudiante getEstudianteById(Long id) {
        Optional<Estudiante> estudiante = estudianteRepository.findById(id);
        return estudiante.orElse(null);
    }

    @Override
    public List<Estudiante> getAllEstudiantes() {
        return estudianteRepository.findAll();

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

            // Añadir lógica para otras propiedades según sea necesario

            return estudianteRepository.save(updatedEstudiante);
        }

        return null;
    }

    @Override
    public String deleteEstudiante(Long id) {
        estudianteRepository.deleteById(id);
        return "id " + id + " is deleted successfully";
    }

}
