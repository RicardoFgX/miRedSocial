package com.proyectoredsocial.miRedSocial.servicesImpl;

import java.util.List;
import java.util.stream.Collectors;

import com.proyectoredsocial.miRedSocial.dtos.UsuarioDTO;
import com.proyectoredsocial.miRedSocial.repository.UsuarioRepository;
import com.proyectoredsocial.miRedSocial.services.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import lombok.RequiredArgsConstructor;

/**
 * Implementación del servicio de usuario que proporciona operaciones relacionadas con usuarios.
 */
@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    /**
     * Inyección del repositorio de usuario.
     */
    @Autowired
    private UsuarioRepository usuarioRepository;

    /**
     * Retorna un objeto UserDetailsService que carga los detalles de usuario por nombre de usuario.
     *
     * @return Un objeto UserDetailsService para cargar los detalles de usuario.
     */
    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {

            @Override
            public UserDetails loadUserByUsername(String nombre) {
                return usuarioRepository.findByEmail(nombre)
                        .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
            }
        };
    }

    /**
     * Obtiene todos los usuarios y los convierte en una lista de objetos UsuarioDTO.
     *
     * @return Una lista de todos los usuarios convertidos en objetos UsuarioDTO.
     */
    @Override
    public List<UsuarioDTO> obtenerTodos() {
        List<UsuarioDTO> usuarios = usuarioRepository.findAll().stream()
                .map(usuario -> new UsuarioDTO(usuario.getNombre(), usuario.getApellidos(), usuario.getEmail(),
                        usuario.getRoles().toString()))
                .collect(Collectors.toList());
        return usuarios;
    }
}

