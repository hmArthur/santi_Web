package com.example.santi.santi_web_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class SantiWebServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SantiWebServiceApplication.class, args);
	}

}
