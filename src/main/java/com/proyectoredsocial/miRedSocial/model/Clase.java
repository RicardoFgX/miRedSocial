package com.proyectoredsocial.miRedSocial.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

/**
 * Entidad que representa una clase en el sistema.
 * Cada clase puede tener varios estudiantes asociados.
 */
@Entity
@Table(name = "clases")
public class Clase {

    /**
     * Identificador único de la clase.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre de la clase.
     */
    @Column(nullable = false)
    private String nombre;

    /**
     * Lista de estudiantes asociados a la clase.
     */
    @OneToMany(mappedBy = "clase")
    private List<Estudiante> estudiantes;

    /**
     * Obtiene el identificador de la clase.
     *
     * @return Identificador único de la clase.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador de la clase.
     *
     * @param id Identificador único de la clase.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre de la clase.
     *
     * @return Nombre de la clase.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la clase.
     *
     * @param nombre Nombre de la clase.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
