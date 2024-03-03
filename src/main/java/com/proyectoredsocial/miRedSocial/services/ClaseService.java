package com.proyectoredsocial.miRedSocial.services;

import com.proyectoredsocial.miRedSocial.model.Clase;

import java.util.List;

public interface ClaseService {

    List<Clase> getAllClases();
    Clase getClaseById(Long id);
    Clase saveClase(Clase clase);
    String deleteClase(Long id);
    Clase updateClase(Long id, Clase clase);

}
