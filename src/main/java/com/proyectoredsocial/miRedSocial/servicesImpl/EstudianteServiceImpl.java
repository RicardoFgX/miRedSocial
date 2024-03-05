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

/**
 * Implementación del servicio para operaciones relacionadas con la entidad Estudiante.
 */
@Service
public class EstudianteServiceImpl implements EstudianteService {

    @Autowired
    EstudianteRepository estudianteRepository;

    /**
     * Guarda un nuevo estudiante.
     *
     * @param estudiante El estudiante a ser guardado.
     * @return El estudiante guardado.
     */
    @Override
    public Estudiante saveEstudiante(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    /**
     * Obtiene un estudiante por su ID.
     *
     * @param id ID del estudiante.
     * @return El estudiante encontrado o un Optional vacío si no existe.
     */
    @Override
    public Optional<Estudiante> getEstudianteById(Long id) {
        return estudianteRepository.findById(id);
    }

    /**
     * Obtiene una página de estudiantes paginados.
     *
     * @param pageable Configuración de paginación.
     * @return Página de estudiantes.
     */
    @Override
    public Page<Estudiante> getAllEstudiantes(Pageable pageable) {
        return estudianteRepository.findAll(pageable);
    }

    /**
     * Actualiza un estudiante por su ID.
     *
     * @param id         ID del estudiante a actualizar.
     * @param estudiante Los datos actualizados del estudiante.
     * @return El estudiante actualizado o nulo si no se encuentra.
     */
    @Override
    public Estudiante updateEstudiante(Long id, Estudiante estudiante) {
        Optional<Estudiante> estudianteById = estudianteRepository.findById(id);

        if (estudianteById.isPresent()) {
            Estudiante updatedEstudiante = estudianteById.get();

            updatedEstudiante.setId(estudiante.getId());
            updatedEstudiante.setNombre(estudiante.getNombre());
            updatedEstudiante.setApellido(estudiante.getApellido());
            updatedEstudiante.setMatricula(estudiante.getMatricula());
            // Agrega más atributos aquí según sea necesario

            return estudianteRepository.save(updatedEstudiante);
        }

        return null;
    }

    /**
     * Elimina un estudiante por su ID.
     *
     * @param id ID del estudiante a borrar.
     * @return `true` si se eliminó con éxito, `false` si no se encontró el estudiante.
     */
    @Override
    public Boolean deleteEstudiante(Long id) {
        if (estudianteRepository.existsById(id)) {
            estudianteRepository.deleteById(id);
            return true; // Si se eliminó con éxito
        } else {
            return false; // Si no se encontró el estudiante
        }
    }
    
    /**
     * Filtra estudiantes por nombre, apellido o clase.
     *
     * @param nombre   El nombre a filtrar.
     * @param apellido El apellido a filtrar.
     * @param claseId  El ID de la clase a la que pertenecen los estudiantes.
     * @param pageable Configuración de paginación.
     * @return Página de estudiantes filtrados.
     * @throws IllegalArgumentException Si no se proporciona al menos un criterio de filtrado.
     */
    @Override
    public Page<Estudiante> filtrarEstudiantes(String nombre, String apellido, Long claseId, Pageable pageable) {
        if (nombre == null && apellido == null && claseId == null) {
            throw new IllegalArgumentException("Debe proporcionar al menos un criterio de filtrado");
        }

        if (nombre != null) {
            return filtrarPorNombre(nombre, pageable);
        } else if (apellido != null) {
            return filtrarPorApellido(apellido, pageable);
        } else {
            return filtrarPorClase(claseId, pageable);
        }
    }

    /**
     * Filtra estudiantes por nombre.
     *
     * @param nombre   El nombre a filtrar.
     * @param pageable Configuración de paginación.
     * @return Página de estudiantes filtrados por nombre.
     */
    private Page<Estudiante> filtrarPorNombre(String nombre, Pageable pageable) {
        // Lógica de filtrado por nombre
        return estudianteRepository.findByNombreContainingIgnoreCase(nombre, pageable);
    }

    /**
     * Filtra estudiantes por apellido.
     *
     * @param apellido El apellido a filtrar.
     * @param pageable Configuración de paginación.
     * @return Página de estudiantes filtrados por apellido.
     */
    private Page<Estudiante> filtrarPorApellido(String apellido, Pageable pageable) {
        // Lógica de filtrado por apellido
        return estudianteRepository.findByApellidoContainingIgnoreCase(apellido, pageable);
    }

    /**
     * Filtra estudiantes por clase.
     *
     * @param claseId  El ID de la clase a la que pertenecen los estudiantes.
     * @param pageable Configuración de paginación.
     * @return Página de estudiantes filtrados por clase.
     */
    private Page<Estudiante> filtrarPorClase(Long claseId, Pageable pageable) {
        // Lógica de filtrado por clase
        return estudianteRepository.findByClaseId(claseId, pageable);
    }
}

