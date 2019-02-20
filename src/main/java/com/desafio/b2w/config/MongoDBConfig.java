package com.desafio.b2w.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.desafio.b2w.domain.Planeta;
import com.desafio.b2w.repository.PlanetaRepository;

import lombok.extern.slf4j.Slf4j;

@EnableMongoRepositories(basePackageClasses= {PlanetaRepository.class})
@Configuration
@Slf4j
public class MongoDBConfig {
	
	@Bean
	CommandLineRunner commandLineRunner(PlanetaRepository repository) {
		return strings ->{
			log.info("====== INSERINDO MASSA DE DADOS PARA FACILITAR TESTES DA API ==========");
			repository.save(new Planeta(1L, "Alderaan", "temperate", "grasslands, mountains"));
			repository.save(new Planeta(2L, "Hoth", "frozen", "tundra, ice caves, mountain ranges"));
			log.info("====== MASSA DE DADOS INSERIDA ==========");
		};
	}

}
