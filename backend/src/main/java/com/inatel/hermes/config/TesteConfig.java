package com.inatel.hermes.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.inatel.hermes.dao.CategoryDAO;
import com.inatel.hermes.dao.OngDAO;
import com.inatel.hermes.entities.Category;
import com.inatel.hermes.entities.Ong;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner {
	@Autowired
	private OngDAO ongRepository;

	@Autowired
	private CategoryDAO categoryRepository;

	@Override
	public void run(String... args) throws Exception {

		Category cat1 = new Category(null, "Fundação",
				"Dentre os tipos de ONGs, a fundação é uma das mais conhecida"
						+ "s e é criada através da doação de patrimônio, seja por empresas ou pessoas físicas, "
						+ "em prol de uma causa sem fins lucrativos.");
		Category cat2 = new Category(null, "Associação",
				"Diferentemente da fundação, a Associação é caracterizada pela união"
						+ " de pessoas em vista de um único propósito que não tenha objetivos de lucro.");
		Category cat3 = new Category(null, "Organização da Sociedade Civil com Interesse Público (OSCIP)",
				"As OSCIPs são reconhecidas "
						+ "pelo Ministério da Justiça do Brasil como organizações que desenvolvem e administram, de maneira idônea, projetos sociais.");
		Category cat4 = new Category(null, "Organização Social (OS)",
				"A Organização Social é uma dentre os muitos tipos de ONGs, sendo assim,"
						+ " ela tem como objetivo principal atuar no ensino,"
						+ "  pesquisa, desenvolvimento tecnológico, cultura e mantenimento do meio ambiente.");
		Category cat5 = new Category(null, "Entidade Beneficente de Assistência Social",
				" as Entidades de Assistência Social "
						+ "são reconhecidas pelo Governo devido à sua atuação específica em relação às necessidades da população.");
		Category cat6 = new Category(null, "Negócio Social",
				"Negócios Sociais enquadram-se nos tipos de ONGs que são caracterizada"
						+ "s pela posição da pessoa jurídica que visa o lucro, mas tem como objetivo causar um impacto social positivo.");

		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6));
		
		
		Ong ong1 = new Ong(null,"Ong legal", "ong@gmail.com", "35987654321", "ong123", "123123123","Rua dos Ouros 123", cat1);
		
		ongRepository.save(ong1);
	}

}
