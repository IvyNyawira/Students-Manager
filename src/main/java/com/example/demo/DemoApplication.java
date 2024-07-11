package com.example.demo;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "STUDENT REST API Documentation",
				description = "Student REST API Documentation",
				version = "v1",
				contact = @Contact(
						name = "Backend Team",
						email = "test@test.com",
						url = "https://www.emtechnologies.com"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://www.emtechnologies.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description =  "REST API Documentation",
				url = "https://localhost:8080/swagger-ui.html"
		)
)
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	}
