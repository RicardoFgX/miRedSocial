package com.proyectoredsocial.miRedSocial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.proyectoredsocial.miRedSocial.model.Estudiante;
import com.proyectoredsocial.miRedSocial.services.EstudianteService;

import java.util.List;
@CrossOrigin
@RestController
public class EstudianteController {

    @Autowired
    EstudianteService estudianteService;

    @PostMapping("/estudiantes")
    public Estudiante saveEstudiante(@RequestBody Estudiante estudiante) {
        return estudianteService.saveEstudiante(estudiante);
    }

    @GetMapping("/estudiantes/{id}")
    public Estudiante getEstudiante(@PathVariable("id") Long id) {
        return estudianteService.getEstudianteById(id);
    }

    @GetMapping("/estudiantes")
    public List<Estudiante> getAllEstudiantes() {
        return estudianteService.getAllEstudiantes();
    }

    @PutMapping("/estudiantes/{id}")
    public Estudiante updateEstudiante(@PathVariable("id") Long id, @RequestBody Estudiante estudiante) {
        return estudianteService.updateEstudiante(id, estudiante);
    }

    @DeleteMapping("/estudiantes/{id}")
    public String deleteEstudiante(@PathVariable("id") Long id) {
        return estudianteService.deleteEstudiante(id);
    }
}
