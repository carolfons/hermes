package com.inatel.hermes.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inatel.hermes.entities.Usuario;

public interface UsuarioDAO extends JpaRepository<Usuario, Long> {

}
