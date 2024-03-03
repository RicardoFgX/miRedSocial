package com.proyectoredsocial.miRedSocial.controller;

import com.proyectoredsocial.miRedSocial.model.Clase;
import com.proyectoredsocial.miRedSocial.services.ClaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clases")
public class ClaseController {

    @Autowired
    private ClaseService claseService;

    @PostMapping
    public Clase saveClase(@RequestBody Clase clase) {
        return claseService.saveClase(clase);
    }

    @GetMapping("/{id}")
    public Clase getClase(@PathVariable("id") Long id) {
        return claseService.getClaseById(id);
    }

    @GetMapping
    public List<Clase> getAllClases() {
        return claseService.getAllClases();
    }

    @PutMapping("/{id}")
    public Clase updateClase(@PathVariable("id") Long id, @RequestBody Clase clase) {
        return claseService.updateClase(id, clase);
    }

    @DeleteMapping("/{id}")
    public String deleteClase(@PathVariable("id") Long id) {
        return claseService.deleteClase(id);
    }
    
}
