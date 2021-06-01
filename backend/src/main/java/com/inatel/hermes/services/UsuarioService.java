package com.inatel.hermes.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.inatel.hermes.dao.UsuarioDAO;
import com.inatel.hermes.entities.Usuario;
import com.inatel.hermes.services.exceptions.DatabaseException;
import com.inatel.hermes.services.exceptions.ResourceNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioDAO usuarioDAO;

	public List<Usuario> findAll() {

		return usuarioDAO.findAll();
	}

	public Usuario findById(Long id) {
		Optional<Usuario> object = usuarioDAO.findById(id);
		return object.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Usuario insert(Usuario obj) {
		return usuarioDAO.save(obj);
	}

	public void delete(Long id) {
		try {
			usuarioDAO.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());

		}
	}

	public Usuario update(Long id, Usuario obj) {
		try {
			Usuario entity = usuarioDAO.getOne(id);
			updateData(entity, obj);
			return usuarioDAO.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Usuario entity, Usuario obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
		entity.setAddress(obj.getAddress());
		entity.setCpf(obj.getCpf());
		entity.setPassword(obj.getPassword());

	}
}
