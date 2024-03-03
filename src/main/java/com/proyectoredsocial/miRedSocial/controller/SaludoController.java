package com.proyectoredsocial.miRedSocial.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaludoController {

    @GetMapping("/")
    public String saludar() {
        return "Hola Mundo";
    }
}
