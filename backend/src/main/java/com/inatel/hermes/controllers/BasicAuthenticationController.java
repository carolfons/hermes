package com.inatel.hermes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inatel.hermes.entities.Usuario;
import com.inatel.hermes.services.UsuarioService;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" })
@RestController
@RequestMapping(value = "/session")
public class BasicAuthenticationController {

	@Autowired
	private UsuarioService service;

	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping
	public ResponseEntity<Usuario> checkLogin(@RequestBody Usuario usuario) {
		System.out.println("Email: " + usuario.getEmail() + " Senha: " + usuario.getPassword());
		System.out.println(usuario);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Usuario newUser = service.findByEmail(usuario.getEmail());
		System.out.println(newUser);
		if (encoder.matches(usuario.getPassword(), newUser.getPassword())) {
			System.out.println("AEEEEEEEE");
			return ResponseEntity.ok().body(newUser);
		} else {
			System.out.println("deu ruim");
			return ResponseEntity.badRequest().build();
		}

	}
}