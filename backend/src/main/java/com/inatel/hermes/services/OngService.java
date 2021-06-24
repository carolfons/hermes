package com.inatel.hermes.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.inatel.hermes.dao.OngDAO;
import com.inatel.hermes.entities.Ong;
import com.inatel.hermes.services.exceptions.DatabaseException;
import com.inatel.hermes.services.exceptions.ResourceNotFoundException;

@Service
public class OngService {

	@Autowired
	private OngDAO ongDAO;

	public List<Ong> findAll() {

		return ongDAO.findAll();
	}

	public Ong findById(Long id) {
		Optional<Ong> object = ongDAO.findById(id);
		return object.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Ong insert(Ong obj) {
		return ongDAO.save(obj);
	}

	public void delete(Long id) {
		try {
			ongDAO.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	public Ong update(Long id, Ong obj) {
		try {
			Ong entity = ongDAO.getOne(id);
			updateData(entity, obj);
			return ongDAO.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Ong entity, Ong obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
		entity.setAddress(obj.getAddress());
		entity.setCnpj(obj.getCnpj());
		entity.setPassword(obj.getPassword());
	}
}
