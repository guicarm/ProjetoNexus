package br.com.plusoft.nexus.model;

import org.hibernate.validator.constraints.br.CNPJ;

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
public class Empresa {
    
    
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "{empresa.razaoSocial.notblank}")
    @Size(min = 3, max = 255, message="{empresa.razaoSocial.size}")
    private String razaoSocial;


    @Size(min = 3, max = 255, message="{empresa.nomeFantasia.size}")
    private String nomeFantasia;

    @NotBlank(message = "{empresa.areaDeAtuacao.notblank}")
    @Size(min = 3, max = 100, message="{empresa.areaDeAtuacao.size}")
    private String areaDeAtuacao;       // Varejo, Saúde, Beleza, Tecnologia, Etc.

    @NotBlank(message = "{empresa.cnpj.notblank}")
    @CNPJ
    private String cnpj;
}
