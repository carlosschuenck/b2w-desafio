package com.desafio.b2w.repository;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.desafio.b2w.domain.Planeta;

public interface PlanetaRepository extends MongoRepository<Planeta, Long> {
	
	public Optional<Planeta> findByNome(String nome);

}
