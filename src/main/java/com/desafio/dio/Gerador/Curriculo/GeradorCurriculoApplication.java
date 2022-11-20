package com.desafio.dio.Gerador.Curriculo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class GeradorCurriculoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeradorCurriculoApplication.class, args);
		System.out.println("http://localhost:8080/swagger-ui/index.html");
	}

}
