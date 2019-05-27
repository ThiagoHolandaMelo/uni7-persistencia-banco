package com.example.banco;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.banco.db.repository.VetRepository;

@SpringBootApplication
public class BancoApplication {
	
	@Bean
	public CommandLineRunner demoSpecialty(VetRepository repository) {
        return (args) -> {
        	repository.findAll().forEach(System.out::println);;
        };
	}

	public static void main(String[] args) {
		SpringApplication.run(BancoApplication.class, args);
	}

}
