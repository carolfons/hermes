package com.inatel.hermes.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.inatel.hermes.dao.OngDAO;
import com.inatel.hermes.dao.UsuarioDAO;
import com.inatel.hermes.entities.Ong;
import com.inatel.hermes.entities.Role;
import com.inatel.hermes.entities.Usuario;
import com.inatel.hermes.services.RoleService;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner {
	@Autowired
	private OngDAO ongDAO;

	@Autowired
	RoleService roleService;

	@Autowired
	private UsuarioDAO usuarioDAO;

	@Override
	public void run(String... args) throws Exception {

		Role r1 = new Role("ROLE_ADMIN", null);
		Role r2 = new Role("ROLE_USER", null);
		roleService.SaveAll(Arrays.asList(r1, r2));

		Ong ong1 = new Ong(null, "CASA DA SOPA CAPITÃO MAURICIO", "rccontabilidade@veloxmail.com.br", "5535992258033",
				"casadasopa123", "17957374/0001-00",
				"Rua José Garcia da Fonseca, 69 - Jardim Santa Tereza - Três Corações MG",
				"A Casa da Sopa é uma entidade beneficente que ajuda famílias carentes na região do Ouro Verde. Somos uma entidade sem fins lucrativos e precisamos da contribuição de pessoas como você para nos auxiliar no nosso propósito de ajudar famílias carentes e moradores em situação de rua no entorno da comunidade");
 
		Ong ong2 = new Ong(null, "GOODTRUCK", "ongCapoeira@gmail.com", "5541999538866", "goodtruck123",
				"03567936/0001-97", "Av. Armando Ítalo Setti - Baeta Neves, São Bernardo do Campo - SP",
				"Com o objetivo de levar comida da onde SOBRA, para onde FALTA.  promovendo ações de voluntariado, nós resgatamos alimentos que seriam desperdiçados e fazemos a destinação de refeições para populações de rua e de comunidades periféricas vulneráveis.");

		Ong ong3 = new Ong(null, "ONG CASA DO CAMINHO", "ongCapoeira@gmail.com", "5535998534046", "123ong", "70950571/0001-72",
				"Rua Roberto Dias Vilela, 17, Santa Felicidade - Santa Rita do Sapucaí, MG",
				"A ONG Casa do Caminho atende crianças e adolescentes no contra turno escolar, oferecendo atividades socioeducativas e recreação, além de alimentação saudável e apoio às famílias dos assistidos.");

		ongDAO.save(ong1);
		ongDAO.save(ong2);
		ongDAO.save(ong3);

		Usuario usuario1 = new Usuario(null, "André Luis", "andre@inatel.br", "5535992258033",
				new BCryptPasswordEncoder().encode("andre123"), "123456789", "Rua dos anjos 123", Arrays.asList(r1));
		Usuario usuario2 = new Usuario(null, "Caroline Fonseca", "carol@inatel.br", "35123123123",
				new BCryptPasswordEncoder().encode("carol123"), "987654321", "Rua da casa da Carol 321",
				Arrays.asList(r2));

		usuarioDAO.saveAll(Arrays.asList(usuario1, usuario2));
	}

}
