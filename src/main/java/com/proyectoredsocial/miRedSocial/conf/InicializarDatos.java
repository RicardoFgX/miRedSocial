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

    	Clase clase3 = new Clase();
    	clase3.setNombre("Ciencias");
    	claseRepository.save(clase3);

    	Clase clase4 = new Clase();
    	clase4.setNombre("Literatura");
    	claseRepository.save(clase4);

    	Clase clase5 = new Clase();
    	clase5.setNombre("Arte");
    	claseRepository.save(clase5);

    	Clase clase6 = new Clase();
    	clase6.setNombre("Educación Física");
    	claseRepository.save(clase6);

    	for (int i = 0; i < 100; i++) {
    	    Estudiante estudiante = new Estudiante();
    	    estudiante.setNombre(faker.name().firstName());
    	    estudiante.setApellido(faker.name().lastName());
    	    estudiante.setMatricula("2021" + String.format("%03d", i + 1));
    	    estudiante.setEdad(faker.number().numberBetween(18, 25));
    	    estudiante.setCiudad(faker.address().city());

    	    // Asigna el estudiante a una clase de forma aleatoria
    	    int claseAleatoria = faker.number().numberBetween(1, 7);
    	    switch (claseAleatoria) {
    	        case 1:
    	            estudiante.setClase(clase1);
    	            break;
    	        case 2:
    	            estudiante.setClase(clase2);
    	            break;
    	        case 3:
    	            estudiante.setClase(clase3);
    	            break;
    	        case 4:
    	            estudiante.setClase(clase4);
    	            break;
    	        case 5:
    	            estudiante.setClase(clase5);
    	            break;
    	        case 6:
    	            estudiante.setClase(clase6);
    	            break;
    	    }

    	    estudianteRepository.save(estudiante);
    	}

    }
}
