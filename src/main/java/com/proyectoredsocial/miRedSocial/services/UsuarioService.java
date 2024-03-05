package com.proyectoredsocial.miRedSocial.services;

import java.util.List;

import com.proyectoredsocial.miRedSocial.dtos.UsuarioDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Interfaz que define los métodos para el servicio de usuarios.
 */
public interface UsuarioService {

    /**
     * Obtiene el servicio de detalles de usuario.
     *
     * @return El servicio de detalles de usuario.
     */
    UserDetailsService userDetailsService();

    /**
     * Obtiene una lista de todos los usuarios como objetos DTO.
     *
     * @return Lista de objetos UsuarioDTO.
     */
    List<UsuarioDTO> obtenerTodos();
}
