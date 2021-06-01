package com.inatel.hermes.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.inatel.hermes.dao.OngDAO;
import com.inatel.hermes.dao.UsuarioDAO;
import com.inatel.hermes.entities.Ong;
import com.inatel.hermes.entities.Usuario;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner {
	@Autowired
	private OngDAO ongDAO;
	
	@Autowired
	private UsuarioDAO usuarioDAO;

	@Override
	public void run(String... args) throws Exception {

		
		
		Ong ong1 = new Ong(null,"Ong legal", "ong@gmail.com", "35987654321", "ong123", "123123123","Rua dos Ouros 123", "Cuida de cachorros abandonados.");
		Ong ong2 = new Ong(null,"Ong de Capoeira", "ongCapoeira@gmail.com", "35123456789", "123ong", "321321321","Rua das Pratas 321", "Aulas gratuitas de capoeira.");
		
		ongDAO.save(ong1);
		ongDAO.save(ong2);
		
		Usuario usuario1 = new Usuario(null, "andre", "andre@inatel.br", "35992258033", "andre123", "123456789", "Rua dos anjos 123");
		Usuario usuario2 = new Usuario(null, "carol", "caroL@inatel.br", "35123123123", "carol123", "987654321", "Rua da casa da Carol 321");
		
		usuarioDAO.saveAll(Arrays.asList(usuario1, usuario2));
	}

}
