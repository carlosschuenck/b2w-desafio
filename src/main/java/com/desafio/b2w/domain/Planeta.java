package com.desafio.b2w.domain;


import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PUBLIC)
@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor
@Data
@Document
public class Planeta { 
	
	@Id
	@NonNull
	private Long id;
	
	@NonNull
	@NotBlank(message="Atributo obrigatório")
	private String nome, clima, terreno;
	
	@Transient
	private int quantidadeFilmes;
	
	@Transient
    public static final String SEQUENCE_NAME = "planeta_sequence";
}
