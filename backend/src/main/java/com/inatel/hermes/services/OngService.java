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
	private OngDAO ongRepository;

	public List<Ong> findAll() {

		return ongRepository.findAll();
	}

	public Ong findById(Long id) {
		Optional<Ong> object = ongRepository.findById(id);
		return object.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Ong insert(Ong obj) {
		return ongRepository.save(obj);
	}

	public void delete(Long id) {
		try {
			ongRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());

		}
	}

	public Ong update(Long id, Ong obj) {
		try {
			Ong entity = ongRepository.getOne(id);
			updateData(entity, obj);
			return ongRepository.save(entity);
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
