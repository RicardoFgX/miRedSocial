package com.proyectoredsocial.miRedSocial.controller;

import com.proyectoredsocial.miRedSocial.exceptions.EstudianteNoEncontradoException;
import com.proyectoredsocial.miRedSocial.exceptions.ListaEstudiantesVaciaException;
import com.proyectoredsocial.miRedSocial.model.Estudiante;
import com.proyectoredsocial.miRedSocial.services.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST que maneja las operaciones relacionadas con estudiantes.
 * Proporciona endpoints para realizar operaciones CRUD en la entidad Estudiante.
 */
@CrossOrigin
@RestController
public class EstudianteController {

    @Autowired
    EstudianteService estudianteService;

    /**
     * Endpoint para guardar un nuevo estudiante.
     *
     * @param estudiante El estudiante a ser guardado.
     * @return El estudiante guardado.
     */
    @PostMapping("/estudiantes")
    public ResponseEntity<?> saveEstudiante(@RequestBody Estudiante estudiante) {
        try {
            Estudiante savedEstudiante = estudianteService.saveEstudiante(estudiante);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedEstudiante);
        } catch (Exception e) {
            // Manejar otras excepciones
            System.err.println("Error inesperado al guardar el estudiante: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error inesperado al obtener el estudiante:" + e.getMessage());
        }
    }


    /**
     * Endpoint para obtener un estudiante por su ID.
     *
     * @param id ID del estudiante.
     * @return El estudiante encontrado.
     * @throws EstudianteNoEncontradoException Si no se encuentra un estudiante con el ID especificado.
     */
    @GetMapping("/estudiantes/{id}")
    public ResponseEntity<?> getEstudiante(@PathVariable("id") Long id) {
        try {
            Estudiante estudiante = estudianteService.getEstudianteById(id)
                    .orElseThrow(() -> new EstudianteNoEncontradoException("No se encuentra el estudiante con ID: " + id));
            return ResponseEntity.ok(estudiante);
        } catch (EstudianteNoEncontradoException e) {
            System.err.println("Error: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Estudiante no encontrado: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error inesperado: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error inesperado al obtener el estudiante.");
        }
    }


    /**
     * Endpoint para obtener una página de estudiantes paginados.
     *
     * @param page Número de página para paginación (opcional).
     * @param size Tamaño de la página para paginación (opcional).
     * @return Página de estudiantes.
     * @throws ListaEstudiantesVaciaException Si no hay estudiantes registrados en el sistema.
     */
    @GetMapping("/estudiantes")
    public Page<Estudiante> getAllEstudiantes(@RequestParam(required = false, defaultValue = "0") Integer page,
                                              @RequestParam(required = false, defaultValue = "10") Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Estudiante> estudiantesPage = estudianteService.getAllEstudiantes(pageable);

        if (estudiantesPage.isEmpty()) {
            throw new ListaEstudiantesVaciaException("No hay estudiantes registrados en el sistema.");
        }

        return estudiantesPage;
    }

    /**
     * Endpoint para actualizar un estudiante por su ID.
     *
     * @param id         ID del estudiante a actualizar.
     * @param estudiante Los datos actualizados del estudiante.
     * @return El estudiante actualizado.
     * @throws EstudianteNoEncontradoException Si no se encuentra un estudiante con el ID especificado.
     */
    @PutMapping("/estudiantes/{id}")
    public ResponseEntity<?> updateEstudiante(@PathVariable("id") Long id, @RequestBody Estudiante estudiante) {
        try {
            Estudiante updatedEstudiante = estudianteService.updateEstudiante(id, estudiante);
            if(updatedEstudiante != null) {
            	return ResponseEntity.ok(updatedEstudiante);
            } else {
                throw new EstudianteNoEncontradoException("No se encuentra el estudiante con ID: " + id);
            }
        } catch (EstudianteNoEncontradoException e) {
            // Manejar la excepción específica de estudiante no encontrado
            System.err.println("Error al actualizar el estudiante: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error al actualizar el estudiante: " + e.getMessage());
        } catch (Exception e) {
            // Manejar otras excepciones
            System.err.println("Error inesperado al actualizar el estudiante: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al actualizar el estudiante: " + e.getMessage());
        }
    }


    /**
     * Endpoint para borrar un estudiante por su ID.
     *
     * @param id ID del estudiante a borrar.
     * @return Mensaje indicando el resultado de la operación.
     * @throws EstudianteNoEncontradoException Si no se encuentra un estudiante con el ID especificado.
     */
    @DeleteMapping("/estudiantes/{id}")
    public ResponseEntity<String> deleteEstudiante(@PathVariable("id") Long id) {
        try {
            if (estudianteService.deleteEstudiante(id)) {
                return ResponseEntity.ok("Estudiante con ID " + id + " borrado exitosamente.");
            } else {
                throw new EstudianteNoEncontradoException("No se encuentra el estudiante con ID: " + id);
            }
        } catch (EstudianteNoEncontradoException e) {
            // Manejar la excepción específica de estudiante no encontrado
            System.err.println("Error al borrar el estudiante: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error al borrar el estudiante: " + e.getMessage());
        } catch (Exception e) {
            // Manejar otras excepciones
            System.err.println("Error inesperado al borrar el estudiante: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error inesperado al borrar el estudiante.");
        }
    }

}
