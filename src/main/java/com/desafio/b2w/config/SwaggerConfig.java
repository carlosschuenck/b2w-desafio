package com.desafio.b2w.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
													  .apis(RequestHandlerSelectors.basePackage("com.desafio.b2w.resource"))
													  .paths(PathSelectors.any())
													  .build()
													  .apiInfo(apiInfo());
	}
	
	private ApiInfo apiInfo() {
	    return new ApiInfo(
	      "BW2 Desafio REST API", 
	      "Projeto criado com o objetivo de cumprir o desafio oferecido pela empresa B2W", 
	      "1.0.0", 
	      null, 
	      new Contact("Carlos Alberto Schuenck Junior", null, "carlosschuenck@hotmail.com"),
	      "","",new ArrayList<>());
	}
}
