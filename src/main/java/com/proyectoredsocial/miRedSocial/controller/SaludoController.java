package com.proyectoredsocial.miRedSocial.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador REST base con el que se ha partido para probar funcionalidad de la API inicialmente.
 * Este controlador proporciona un endpoint para obtener un saludo simple.
 */
@RestController
public class SaludoController {

    /**
     * Maneja las solicitudes GET en la ruta "/" y devuelve un saludo.
     *
     * @return Cadena que representa el saludo.
     */
    @GetMapping("/")
    public String saludar() {
        return "Hola a todos";
    }
}
