package com.rodrigosilva.cursomc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@SpringBootApplication
public class CursomsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CursomsApplication.class, args);
	}

}
