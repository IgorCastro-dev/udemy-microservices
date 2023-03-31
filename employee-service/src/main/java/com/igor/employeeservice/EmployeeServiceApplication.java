package com.igor.employeeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@OpenAPIDefinition(
		info = @Info(
				title = "Employee Service Rest API",
				description = "Employee Service Rest API documentation",
				version = "V1.0",
				contact = @Contact(name = "Igor Castro",email = "igorjunqueira19@gmail.com"),
				license = @License(name = "Apache 2.0")
				),externalDocs = @ExternalDocumentation(description = "Employee-service Doc"))

@SpringBootApplication
@EnableFeignClients
public class EmployeeServiceApplication {
	
//	@Bean
//	public WebClient webClient() {
//		return WebClient.builder().build();
//	}
	
//	@Bean
//	public RestTemplate restTemplate() {
//		return new RestTemplate();
//	}
//	
	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}

}
