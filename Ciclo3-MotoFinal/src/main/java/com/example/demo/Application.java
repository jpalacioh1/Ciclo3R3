// 1. Modelo o Entidad
// 2. Interface : se herada del JPA los metodos 
// 3. Repositorio: donde se construyen los metodos para consumir el crud
// 4. Servicios: donde se especifican las condiciones para consumirlos
// 5. Controlador o Web: donde se crea la URL de la apiRest


package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties
@EntityScan(basePackages = {"com.example.demo"})  // scan JPA entities
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
