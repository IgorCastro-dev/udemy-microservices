package com.igor.organizationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@OpenAPIDefinition(info = @Info(
		title = "Organization Service Rest API",
		description = "Organization Service Rest API documentation",
		version = "V1.0",
		license = @License(name = "Apache 2.0"),
		contact = @Contact(name = "Igor Castro",email = "igorjunqueira19@gmail.com")
		),externalDocs = @ExternalDocumentation(description = "Department-service Doc"))
@SpringBootApplication
public class OrganizationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrganizationServiceApplication.class, args);
	}

}
