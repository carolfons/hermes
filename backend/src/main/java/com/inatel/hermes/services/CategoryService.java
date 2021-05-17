package com.inatel.hermes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inatel.hermes.dao.CategoryDAO;
import com.inatel.hermes.entities.Category;

@Service
public class CategoryService {

	@Autowired
	private CategoryDAO repository;
	
	public List<Category> findAll(){
		
		return repository.findAll();
	}
	
	public Category findById(Long id) {
		 Optional<Category> object = repository.findById(id);
		return object.get();
	}
}
