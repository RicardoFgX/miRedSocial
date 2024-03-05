package com.proyectoredsocial.miRedSocial.dtos;

/**
 * DTO (Data Transfer Object) que representa un usuario.
 * Se utiliza para transferir información entre capas de la aplicación.
 */
public class UsuarioDTO {
    private String nombre;
    private String apellidos;
    private String email;
    private String rol;

    /**
     * Constructor por defecto.
     */
    public UsuarioDTO() {

    }

    /**
     * Constructor que toma los atributos del usuario.
     *
     * @param nombre    El nombre del usuario.
     * @param apellidos Los apellidos del usuario.
     * @param email     El correo electrónico del usuario.
     * @param rol       El rol del usuario.
     */
    public UsuarioDTO(String nombre, String apellidos, String email, String rol) {
        super();
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.rol = rol;
    }

    /**
     * Obtiene el nombre del usuario.
     *
     * @return El nombre del usuario.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del usuario.
     *
     * @param nombre El nombre del usuario.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene los apellidos del usuario.
     *
     * @return Los apellidos del usuario.
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Establece los apellidos del usuario.
     *
     * @param apellidos Los apellidos del usuario.
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * Obtiene el correo electrónico del usuario.
     *
     * @return El correo electrónico del usuario.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece el correo electrónico del usuario.
     *
     * @param email El correo electrónico del usuario.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtiene el rol del usuario.
     *
     * @return El rol del usuario.
     */
    public String getRol() {
        return rol;
    }

    /**
     * Establece el rol del usuario.
     *
     * @param rol El rol del usuario.
     */
    public void setRol(String rol) {
        this.rol = rol;
    }
}
