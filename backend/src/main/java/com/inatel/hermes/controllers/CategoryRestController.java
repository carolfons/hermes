package com.inatel.hermes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inatel.hermes.entities.Category;
import com.inatel.hermes.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryRestController {
	@Autowired
	private CategoryService service;

	@GetMapping
	public ResponseEntity<List<Category>> findAll() {
		List<Category> categoryList = service.findAll();
		return ResponseEntity.ok().body(categoryList);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id){
		 Category object = service.findById(id);
		 
		 return ResponseEntity.ok().body(object);
		
	}
	

}
