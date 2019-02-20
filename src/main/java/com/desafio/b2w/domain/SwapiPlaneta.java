package com.desafio.b2w.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SwapiPlaneta {
	
	private String name;
	private String[] films;
	
	/**
	 * Informa a quantidade de aparições do planeta em filmes.
	 * @return int
	 */
	public int getApparitionsCount() {
		if (films == null) {
			return 0;
		} 
		return films.length;
	}
}