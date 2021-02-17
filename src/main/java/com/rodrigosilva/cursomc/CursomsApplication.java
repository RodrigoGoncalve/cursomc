package com.rodrigosilva.cursomc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rodrigosilva.cursomc.services.DBService;

@SpringBootApplication
public class CursomsApplication implements CommandLineRunner {
	
	@Autowired
	private DBService dbservice;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomsApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		dbservice.instantiateTestDatabase();
	}
}
