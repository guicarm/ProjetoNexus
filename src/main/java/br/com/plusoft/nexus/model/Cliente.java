package br.com.plusoft.nexus.model;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class Cliente extends Usuario {
    
    @CPF 
    @NotBlank(message = "{cliente.cpf.notblank}")
    private String cpf;
    
}