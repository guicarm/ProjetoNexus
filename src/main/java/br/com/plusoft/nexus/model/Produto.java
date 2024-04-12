package br.com.plusoft.nexus.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Produto {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "{produto.tipo.notblank}")
    @Size(max = 255, message="{produto.tipo.size}")
    private String tipo;

    @NotBlank(message = "{produto.nome.notblank}")
    @Size(max = 255, message="{produto.nome.size}")
    private String nome;

    @NotBlank(message = "{produto.marca.notblank}")
    @Size(max = 255, message="{produto.marca.size}")
    private String marca;

    @NotBlank(message = "{produto.modelo.notblank}")
    @Size(max = 255, message="{produto.modelo.size}")
    private String modelo;

    @NotBlank(message = "{produto.quantidade.notblank}")
    @PositiveOrZero(message="{produto.quantidade.positiveorzero}")
    private int quantidade;

    @NotBlank(message = "{produto.descricao.notblank}")
    @Size(max = 255, message="{produto.descricao.size}")
    private String descricao;

    @NotBlank(message = "{produto.valor.notblank}")
    @Positive(message="{produto.valor.positive}")
    private double valor;
    
}
