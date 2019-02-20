package com.desafio.b2w.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.desafio.b2w.domain.Planeta;
import com.desafio.b2w.repository.PlanetaRepository;

@Service
@Transactional(readOnly = true)
public class PlanetaService {
	
	@Autowired
	private SwapiService swapiService;
	
	@Autowired
	private PlanetaRepository repository;
	
	@Autowired
	private SequenceGeneratorService sequenceGenerator;
	
	
	public List<Planeta> findAll(){
		List<Planeta> planetas = repository.findAll();
		planetas.forEach(planeta -> planeta.setQuantidadeFilmes(swapiService.findApparitionsCountByPlanet(Optional.of(planeta))));
		return planetas;
	}
	
	public Planeta findByNome(String nome){
		Optional<Planeta> planeta = repository.findByNome(nome);
		if(planeta.isPresent()) {
			planeta.get().setQuantidadeFilmes(swapiService.findApparitionsCountByPlanet(planeta));
			return planeta.get();
		}
		return null;
	}
	
	public Planeta findById(Long id) {
		Optional<Planeta> planeta = repository.findById(id);
		if(planeta.isPresent()) {
			planeta.get().setQuantidadeFilmes(swapiService.findApparitionsCountByPlanet(planeta));
			return planeta.get();
		}
		return null;
	}
	
	@Transactional(readOnly=false)
	public Planeta save(Planeta planeta) throws Exception {
		if(planeta.getId() == null) {
			if(repository.findByNome(planeta.getNome()).isPresent()) 
				throw new RuntimeException("Já existe um planeta registrado com o nome: "+planeta.getNome());
			
			planeta.setId(sequenceGenerator.generateSequence(Planeta.SEQUENCE_NAME));
		}
		return repository.save(planeta);
	}
}
