package com.proyectoredsocial.miRedSocial.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Entidad que representa a un estudiante en el sistema.
 * Cada estudiante pertenece a una clase.
 */
@Entity
@Table(name = "estudiantes")
public class Estudiante {

    /**
     * Identificador único del estudiante.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre del estudiante.
     */
    @Column(nullable = false)
    private String nombre;

    /**
     * Apellido del estudiante.
     */
    @Column(nullable = false)
    private String apellido;

    /**
     * Matrícula única del estudiante.
     */
    @Column(nullable = false, unique = true)
    private String matricula;

    /**
     * Edad del estudiante.
     */
    @Column(nullable = false)
    private int edad;

    /**
     * Ciudad de residencia del estudiante.
     */
    @Column(nullable = false)
    private String ciudad;

    /**
     * Clase a la que pertenece el estudiante.
     */
    @ManyToOne
    @JoinColumn(name = "clase_id")
    private Clase clase;

    /**
     * Obtiene el identificador único del estudiante.
     *
     * @return Identificador único del estudiante.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador único del estudiante.
     *
     * @param id Identificador único del estudiante.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del estudiante.
     *
     * @return Nombre del estudiante.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del estudiante.
     *
     * @param nombre Nombre del estudiante.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el apellido del estudiante.
     *
     * @return Apellido del estudiante.
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Establece el apellido del estudiante.
     *
     * @param apellido Apellido del estudiante.
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Obtiene la matrícula única del estudiante.
     *
     * @return Matrícula única del estudiante.
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * Establece la matrícula única del estudiante.
     *
     * @param matricula Matrícula única del estudiante.
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * Obtiene la edad del estudiante.
     *
     * @return Edad del estudiante.
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Establece la edad del estudiante.
     *
     * @param edad Edad del estudiante.
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * Obtiene la ciudad de residencia del estudiante.
     *
     * @return Ciudad de residencia del estudiante.
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * Establece la ciudad de residencia del estudiante.
     *
     * @param ciudad Ciudad de residencia del estudiante.
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * Obtiene la clase a la que pertenece el estudiante.
     *
     * @return Clase a la que pertenece el estudiante.
     */
    public Clase getClase() {
        return clase;
    }

    /**
     * Establece la clase a la que pertenece el estudiante.
     *
     * @param clase Clase a la que pertenece el estudiante.
     */
    public void setClase(Clase clase) {
        this.clase = clase;
    }
}
