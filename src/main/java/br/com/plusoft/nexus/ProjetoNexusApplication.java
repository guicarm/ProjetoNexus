package br.com.plusoft.nexus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@Controller
@OpenAPIDefinition(
	info = @Info(
		title = "Nexus API",
		version =  "1.0.0",
		description = "API Rest do Projeto Nexus",
		contact = @Contact(name = "Nexus Team", url = "https://github.com/fiap-nexus")	
	)
)
public class ProjetoNexusApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoNexusApplication.class, args);
	}

	@RequestMapping
	@ResponseBody
	public String home(){
		return "Bem-vindo ao Nexus.";
	}
}
