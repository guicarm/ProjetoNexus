package br.com.plusoft.nexus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;


@OpenAPIDefinition(
	info = @Info(
		title = "Nexus API",
		version =  "3.0.0",
		description = "API Rest do Projeto Nexus",
		contact = @Contact(name = "Nexus Team", url = "https://github.com/fiap-nexus")	
	)
)
@SpringBootApplication 
public class ProjetoNexusApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoNexusApplication.class, args);
	}

}
