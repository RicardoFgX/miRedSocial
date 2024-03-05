package com.proyectoredsocial.miRedSocial.controller;

import com.proyectoredsocial.miRedSocial.model.Clase;
import com.proyectoredsocial.miRedSocial.services.ClaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para manejar las operaciones relacionadas con las clases.
 * Este controlador proporciona endpoints para realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre las clases.
 */
@RestController
@RequestMapping("/clases")
public class ClaseController {

    /**
     * Inyección del servicio de clase.
     */
    @Autowired
    private ClaseService claseService;

    /**
     * Maneja las solicitudes POST en la ruta "/clases" para guardar una nueva clase.
     *
     * @param clase Objeto de la clase a ser guardado.
     * @return Objeto de la clase guardado.
     */
    @PostMapping
    public Clase saveClase(@RequestBody Clase clase) {
        return claseService.saveClase(clase);
    }

    /**
     * Maneja las solicitudes GET en la ruta "/clases/{id}" para obtener una clase por su ID.
     *
     * @param id ID de la clase.
     * @return Objeto de la clase encontrado.
     */
    @GetMapping("/{id}")
    public Clase getClase(@PathVariable("id") Long id) {
        return claseService.getClaseById(id);
    }

    /**
     * Maneja las solicitudes GET en la ruta "/clases" para obtener todas las clases.
     *
     * @return Lista de objetos de la clase.
     */
    @GetMapping
    public List<Clase> getAllClases() {
        return claseService.getAllClases();
    }

    /**
     * Maneja las solicitudes PUT en la ruta "/clases/{id}" para actualizar una clase existente.
     *
     * @param id    ID de la clase a ser actualizada.
     * @param clase Objeto de la clase con los datos actualizados.
     * @return Objeto de la clase actualizado.
     */
    @PutMapping("/{id}")
    public Clase updateClase(@PathVariable("id") Long id, @RequestBody Clase clase) {
        return claseService.updateClase(id, clase);
    }

    /**
     * Maneja las solicitudes DELETE en la ruta "/clases/{id}" para eliminar una clase por su ID.
     *
     * @param id ID de la clase a ser eliminada.
     * @return Mensaje indicando que la clase fue eliminada correctamente.
     */
    @DeleteMapping("/{id}")
    public String deleteClase(@PathVariable("id") Long id) {
        return claseService.deleteClase(id);
    }

}
