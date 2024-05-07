package br.com.plusoft.nexus.model;

    

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Chatbot {
    
       
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "{chatbot.nome.notblank}")
    @Size(min = 3, max = 100, message="{chatbot.nome.size}")
    private String nome;

    @NotBlank(message = "{chatbot.dataCriacao.notblank}")
    private String dataCriacao;
}
