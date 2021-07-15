package com.inatel.hermes.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.inatel.hermes.entities.Usuario;

public interface UsuarioDAO extends JpaRepository<Usuario, Long> {

	Optional<Usuario> findByEmail(String email);
	
	@Query("select u from Usuario u where u.email like :email and u.password like :password")
	Optional<Usuario> findByEmailAndPassword(String email, String password);

}
