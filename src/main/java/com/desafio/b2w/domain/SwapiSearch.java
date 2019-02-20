package com.desafio.b2w.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SwapiSearch {	

	private Integer count;
	private SwapiPlaneta[] results;
}
