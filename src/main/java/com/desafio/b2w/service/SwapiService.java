package com.desafio.b2w.service;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.desafio.b2w.domain.Planeta;
import com.desafio.b2w.domain.SwapiPlaneta;
import com.desafio.b2w.domain.SwapiSearch;

@Service
public class SwapiService {
	
	private static final String SWAPI_PLANETS_SEARCH = "https://swapi.co/api/planets?search=";

	@Autowired
	private RestTemplate restTemplate;
	
	
	
	public int findApparitionsCountByPlanet(Optional<Planeta> planeta) {
		
		if(!planeta.isPresent()) return 0;
		
		String swapiUrl = SWAPI_PLANETS_SEARCH + planeta.get().getNome();
		Optional<SwapiSearch> search = Optional.of(restTemplate.getForObject(swapiUrl, SwapiSearch.class));
		
		if(!search.isPresent()) return 0;
		
		int apparitionsCount = 0;
		for (SwapiPlaneta swapiPlaneta : Arrays.asList(search.get().getResults())) {
			apparitionsCount+=swapiPlaneta.getApparitionsCount();
		}
		return apparitionsCount;
	}
}
