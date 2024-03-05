package com.proyectoredsocial.miRedSocial.servicesImpl;

import com.proyectoredsocial.miRedSocial.model.Clase;
import com.proyectoredsocial.miRedSocial.repository.ClaseRepository;
import com.proyectoredsocial.miRedSocial.services.ClaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Implementación del servicio para operaciones relacionadas con la entidad Clase.
 */
@Service
public class ClaseServiceImpl implements ClaseService {

    @Autowired
    private ClaseRepository claseRepository;

    /**
     * Obtiene todas las clases disponibles.
     *
     * @return Lista de todas las clases.
     */
    @Override
    public List<Clase> getAllClases() {
        List<Clase> clases = new ArrayList<>();
        claseRepository.findAll().forEach(clases::add);
        return clases;
    }

    /**
     * Obtiene una clase por su ID.
     *
     * @param id ID de la clase.
     * @return La clase encontrada o nulo si no existe.
     */
    @Override
    public Clase getClaseById(Long id) {
        Optional<Clase> clase = claseRepository.findById(id);
        return clase.orElse(null);
    }

    /**
     * Guarda una nueva clase.
     *
     * @param clase La clase a ser guardada.
     * @return La clase guardada.
     */
    @Override
    public Clase saveClase(Clase clase) {
        return claseRepository.save(clase);
    }

    /**
     * Elimina una clase por su ID.
     *
     * @param id ID de la clase a ser eliminada.
     * @return Mensaje indicando el resultado de la operación.
     */
    @Override
    public String deleteClase(Long id) {
        claseRepository.deleteById(id);
        return "Id " + id + " eliminado exitosamente";
    }

    /**
     * Actualiza una clase por su ID.
     *
     * @param id    ID de la clase a ser actualizada.
     * @param clase Los datos actualizados de la clase.
     * @return La clase actualizada o nulo si no se encuentra.
     */
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

