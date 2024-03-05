package com.proyectoredsocial.miRedSocial.repository;

import java.util.Optional;

import com.proyectoredsocial.miRedSocial.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interfaz que proporciona métodos de acceso a la base de datos para la entidad Usuario.
 * Utiliza Spring Data JPA y hereda de JpaRepository.
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    /**
     * Busca un usuario por su dirección de correo electrónico.
     *
     * @param email La dirección de correo electrónico del usuario a buscar.
     * @return Un Optional que puede contener el usuario con la dirección de correo electrónico proporcionada.
     */
    Optional<Usuario> findByEmail(String email);

    /**
     * Busca un usuario por su ID.
     *
     * @param id El ID del usuario a buscar.
     * @return Un Optional que puede contener el usuario con el ID proporcionado.
     */
    Optional<Usuario> findById(Long id);

    /**
     * Verifica si existe un usuario con la dirección de correo electrónico proporcionada.
     *
     * @param email La dirección de correo electrónico a verificar.
     * @return Verdadero si existe un usuario con la dirección de correo electrónico proporcionada, falso en caso contrario.
     */
    Boolean existsByEmail(String email);
}
