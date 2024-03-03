package com.proyectoredsocial.miRedSocial.repository;

import java.util.Optional;

import com.proyectoredsocial.miRedSocial.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);

    Optional<Usuario> findById(Long id);

    Boolean existsByEmail(String email);
}
