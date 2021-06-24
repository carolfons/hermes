package com.inatel.hermes.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inatel.hermes.entities.Usuario;

public interface UsuarioDAO extends JpaRepository<Usuario, Long> {

	Optional<Usuario> findByEmail(String email);

}
