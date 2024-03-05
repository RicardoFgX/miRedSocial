package com.proyectoredsocial.miRedSocial.services;

import com.proyectoredsocial.miRedSocial.model.Clase;

import java.util.List;

/**
 * Interfaz que define los métodos para el servicio de gestión de clases.
 */
public interface ClaseService {

    /**
     * Obtiene una lista de todas las clases.
     *
     * @return Lista de todas las clases.
     */
    List<Clase> getAllClases();

    /**
     * Obtiene una clase por su identificador.
     *
     * @param id El identificador de la clase.
     * @return La clase encontrada.
     */
    Clase getClaseById(Long id);

    /**
     * Guarda una nueva clase.
     *
     * @param clase La clase a ser guardada.
     * @return La clase guardada.
     */
    Clase saveClase(Clase clase);

    /**
     * Borra una clase por su identificador.
     *
     * @param id El identificador de la clase a borrar.
     * @return Mensaje indicando el resultado de la operación.
     */
    String deleteClase(Long id);

    /**
     * Actualiza una clase existente por su identificador.
     *
     * @param id    El identificador de la clase a actualizar.
     * @param clase Los datos actualizados de la clase.
     * @return La clase actualizada.
     */
    Clase updateClase(Long id, Clase clase);
}
