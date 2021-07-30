package com.teste.testeStarWars;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;



@SpringBootApplication
@EnableFeignClients
public class TesteStarWarsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TesteStarWarsApplication.class, args);
	}

}
