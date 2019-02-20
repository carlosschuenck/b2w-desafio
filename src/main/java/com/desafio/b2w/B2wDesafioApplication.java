package com.desafio.b2w;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.RestTemplate;

@EntityScan(basePackageClasses= {B2wDesafioApplication.class})
@SpringBootApplication
public class B2wDesafioApplication {

	public static void main(String[] args) {
		SpringApplication.run(B2wDesafioApplication.class, args);
	}
	
	
	/**
	 * Configurando RestTemplate para enviar um "User-agent: curl/7.59.0" no header em toda requisição.
	 * Isto é necessário porque o SWAPI recusa requisições com o user-agente original.
	 * @param builder
	 * @return {@link RestTemplate}
	 */
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		RestTemplate restTemplate = builder.build();
		restTemplate.getInterceptors().add(addRequestHeader("User-agent", "curl/7.59.0"));
		return restTemplate;
	}
	
	@Bean
	public ClientHttpRequestInterceptor addRequestHeader(String name, String value) {
		return new ClientHttpRequestInterceptor() {
			@Override
			public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
					throws IOException {
				request.getHeaders().set(name, value);
				return execution.execute(request, body);
			}
		};
	}
}
