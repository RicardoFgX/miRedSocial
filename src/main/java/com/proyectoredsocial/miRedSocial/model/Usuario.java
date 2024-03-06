package com.proyectoredsocial.miRedSocial.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

/**
 * Clase que representa la entidad Usuario en la base de datos.
 */
@Entity
public class Usuario implements UserDetails {
	
    private static final long serialVersionUID = 1L;

    /**
     * Identificador único del usuario en la base de datos.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Campo nombre de usuario
     */
    @NotBlank(message = "El nombre no puede estar en blanco")
    private String nombre;

    /**
     * Campo apellidos del usuario
     */
    @NotBlank(message = "Los apellidos no pueden estar en blanco")
    private String apellidos;

    /**
     * Email del usuario
     */
    @Column(unique = true)
    @Email(message = "La dirección de correo electrónico debe ser válida")
    private String email;

    /**
     * Contrasena del usuario
     */
    @NotBlank(message = "La contraseña no puede estar en blanco")
    private String contrasena;

    /**
     * Rol del usuario
     */
    @ElementCollection(fetch = FetchType.EAGER, targetClass = Roles.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "usuario_rol")
    @Column(name = "Roles")
    private Set<Roles> roles = new HashSet<>();

    /**
     * Devuelve la colección de roles asignados al usuario.
     *
     * @return Colección de roles.
     */
    @Transactional
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        roles.size();
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.name())).collect(Collectors.toList());
    }

    /**
     * Devuelve el nombre de usuario del usuario (en este caso, su dirección de correo electrónico).
     *
     * @return Dirección de correo electrónico del usuario.
     */
    @Override
    public String getUsername() {
        return email;
    }

    /**
     * Indica si la cuenta del usuario ha caducado.
     *
     * @return Siempre devuelve true (la cuenta no expira).
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * Indica si la cuenta del usuario está bloqueada.
     *
     * @return Siempre devuelve true (la cuenta no está bloqueada).
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * Indica si las credenciales del usuario han caducado.
     *
     * @return Siempre devuelve true (las credenciales no caducan).
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * Indica si el usuario está habilitado.
     *
     * @return Siempre devuelve true (el usuario está habilitado).
     */
    @Override
    public boolean isEnabled() {
        return true;
    }

    /**
     * Devuelve la contraseña del usuario.
     *
     * @return Contraseña del usuario.
     */
    @Override
    public String getPassword() {
        return contrasena;
    }

    /**
     * Devuelve el nombre del usuario.
     *
     * @return Nombre del usuario.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del usuario.
     *
     * @param nombre Nuevo nombre del usuario.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve los apellidos del usuario.
     *
     * @return Apellidos del usuario.
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Establece los apellidos del usuario.
     *
     * @param apellidos Nuevos apellidos del usuario.
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * Devuelve la dirección de correo electrónico del usuario.
     *
     * @return Dirección de correo electrónico del usuario.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece la dirección de correo electrónico del usuario.
     *
     * @param email Nueva dirección de correo electrónico del usuario.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Devuelve la contraseña del usuario.
     *
     * @return Contraseña del usuario.
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * Establece la contraseña del usuario.
     *
     * @param contrasena Nueva contraseña del usuario.
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * Devuelve la colección de roles asignados al usuario.
     *
     * @return Colección de roles.
     */
    public Set<Roles> getRoles() {
        return roles;
    }

    /**
     * Establece la colección de roles asignados al usuario.
     *
     * @param roles Nueva colección de roles del usuario.
     */
    public void setRoles(Set<Roles> roles) {
        this.roles = roles;
    }

    /**
     * Devuelve el identificador único del usuario.
     *
     * @return Identificador único del usuario.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador único del usuario.
     *
     * @param id Nuevo identificador único del usuario.
     */
    public void setId(Long id) {
        this.id = id;
    }
}
