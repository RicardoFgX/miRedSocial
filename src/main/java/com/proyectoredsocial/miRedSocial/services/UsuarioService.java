package com.proyectoredsocial.miRedSocial.services;

import java.util.List;

import com.proyectoredsocial.miRedSocial.dtos.UsuarioDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UsuarioService {
    UserDetailsService userDetailsService();

    List<UsuarioDTO> obtenerTodos();
}
