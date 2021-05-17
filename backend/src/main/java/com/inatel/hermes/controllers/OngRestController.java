package com.inatel.hermes.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.inatel.hermes.entities.Category;
import com.inatel.hermes.entities.Ong;
import com.inatel.hermes.services.CategoryService;
import com.inatel.hermes.services.OngService;

@RestController
@RequestMapping(value = "/ongs")
public class OngRestController {
	@Autowired
	private OngService service;
	
	@GetMapping
	public ResponseEntity<List<Ong>> findAll() {
		List<Ong> ongList = service.findAll();
		return ResponseEntity.ok().body(ongList);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Ong> findById(@PathVariable Long id) {
		Ong object = service.findById(id);

		return ResponseEntity.ok().body(object);

	}

	@PostMapping
	public ResponseEntity<Ong> insert(@RequestBody Ong obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);

	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();

	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Ong> update(@PathVariable Long id, @RequestBody Ong obj) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}