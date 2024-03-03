package com.proyectoredsocial.miRedSocial.servicesImpl;

import com.proyectoredsocial.miRedSocial.model.Clase;
import com.proyectoredsocial.miRedSocial.repository.ClaseRepository;
import com.proyectoredsocial.miRedSocial.services.ClaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClaseServiceImpl implements ClaseService {

    @Autowired
    private ClaseRepository claseRepository;

    @Override
    public List<Clase> getAllClases() {
        List<Clase> clases = new ArrayList<>();
        claseRepository.findAll().forEach(clases::add);
        return clases;
    }

    @Override
    public Clase getClaseById(Long id) {
        Optional<Clase> clase = claseRepository.findById(id);
        return clase.orElse(null);
    }

    @Override
    public Clase saveClase(Clase clase) {
        return claseRepository.save(clase);
    }

    @Override
    public String deleteClase(Long id) {
        claseRepository.deleteById(id);
        return "Id " + id + " eliminado exitosamente";
    }

    @Override
    public Clase updateClase(Long id, Clase clase) {
        Optional<Clase> claseById = claseRepository.findById(id);

        if (claseById.isPresent()) {
            Clase updatedClase = claseById.get();
            updatedClase.setNombre(clase.getNombre());
            // Agrega más atributos aquí según sea necesario

            return claseRepository.save(updatedClase);
        }

        return null;
    }
}
