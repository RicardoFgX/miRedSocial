package com.proyectoredsocial.miRedSocial.conf;

import com.github.javafaker.Faker;
import com.proyectoredsocial.miRedSocial.model.Clase;
import com.proyectoredsocial.miRedSocial.model.Estudiante;
import com.proyectoredsocial.miRedSocial.repository.ClaseRepository;
import com.proyectoredsocial.miRedSocial.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InicializarDatos implements CommandLineRunner {

    @Autowired
    private ClaseRepository claseRepository;

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Override
    public void run(String... args) throws Exception {
    	Faker faker = new Faker();
    	
        // Crear algunas clases ficticias
        Clase clase1 = new Clase();
        clase1.setNombre("Matemáticas");
        claseRepository.save(clase1);

        Clase clase2 = new Clase();
        clase2.setNombre("Historia");
        claseRepository.save(clase2);

        for (int i = 0; i < 100; i++) {
            Estudiante estudiante = new Estudiante();
            estudiante.setNombre(faker.name().firstName());
            estudiante.setApellido(faker.name().lastName());
            estudiante.setMatricula("2021" + String.format("%03d", i + 1));
            estudiante.setEdad(faker.number().numberBetween(18, 25));
            estudiante.setCiudad(faker.address().city());
            
            // Asigna el estudiante a una clase (50% a clase1, 50% a clase2)
            if (i < 50) {
                estudiante.setClase(clase1);
            } else {
                estudiante.setClase(clase2);
            }

            estudianteRepository.save(estudiante);
        }
    }
}
