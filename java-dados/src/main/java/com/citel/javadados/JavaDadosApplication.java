package com.citel.javadados;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.citel.javadados")
public class JavaDadosApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaDadosApplication.class, args);
	}

}
