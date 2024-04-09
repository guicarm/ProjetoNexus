package br.com.plusoft.nexus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
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
