package com.desafio.b2w.resource;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.b2w.domain.Planeta;
import com.desafio.b2w.service.PlanetaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags="Planeta")
@RestController
@RequestMapping("/planeta")
public class PlanetaResource {

	@Autowired
	private PlanetaService service;

	@GetMapping
	@ApiOperation(nickname="findAll", value="Método responsável por listar todos os planetas existentes na base de dados", response=List.class)
	public ResponseEntity<List<Planeta>> findAll() {
		return ResponseEntity.ok(service.findAll());
	}

	@GetMapping("/nome/{nomePlaneta}")
	@ApiOperation(nickname="findByNome", value="Método responsável por buscar um planeta de acordo com nome informado", response=Planeta.class)
	public ResponseEntity<Planeta> findByNome(@PathVariable("nomePlaneta") String nomePlaneta) {
		return ResponseEntity.ok(service.findByNome(nomePlaneta));
	}

	@GetMapping("/id/{idPlaneta}")
	@ApiOperation(nickname="findById", value="Método responsável por buscar um planeta de acordo com o id informado", response=Planeta.class)
	public ResponseEntity<Planeta> findById(@PathVariable("idPlaneta") Long idPlaneta) {
		return ResponseEntity.ok(service.findById(idPlaneta));
	}

	@PostMapping
	@ApiOperation(nickname="save", value="Método responsável por salvar um planeta na base de dados", response=Planeta.class)
	public ResponseEntity<Planeta> save(@Valid Planeta planeta) throws Exception {
		return ResponseEntity.ok(service.save(planeta));
	}
}
