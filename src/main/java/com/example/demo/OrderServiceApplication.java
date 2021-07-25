package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class OrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}

	/**
	 * Rest template.
	 *
	 * @param builder the builder
	 * @return the rest template
	 *//*
		 * @Bean public RestTemplate restTemplate(RestTemplateBuilder builder) { // Do
		 * any additional configuration here return builder.build(); }
		 */

	@Bean
	public ObjectMapper objectMapper() {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper;
	}

}
