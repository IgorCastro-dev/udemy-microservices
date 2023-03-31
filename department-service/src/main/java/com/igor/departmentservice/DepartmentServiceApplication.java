package com.igor.departmentservice;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@OpenAPIDefinition(
		info = @Info(
				title = "Department Service Rest API",
				description = "Department Service Rest API documentation",
				version = "V1.0",
				contact = @Contact(name = "Igor Castro",email = "igorjunqueira19@gmail.com"),
				license = @License(name = "Apache 2.0")
				),externalDocs = @ExternalDocumentation(description = "Department-service Doc"))
@SpringBootApplication
public class DepartmentServiceApplication {
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(DepartmentServiceApplication.class, args);
	}

}
