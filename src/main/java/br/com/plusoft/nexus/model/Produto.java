package br.com.plusoft.nexus.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@NotNull
@NotBlank(message = "{produto.notblank}")
@Data
public class Produto {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(max = 255, message="{produto.tipo.size}")
    private String tipo;

    @Size(max = 255, message="{produto.nome.size}")
    private String nome;

    @Size(max = 255, message="{produto.marca.size}")
    private String marca;

    @Size(max = 255, message="{produto.modelo.size}")
    private String modelo;

    @PositiveOrZero(message="{produto.quantidade.positiveorzero}")
    private int quantidade;

    @Size(max = 255, message="{produto.descricao.size}")
    private String descricao;

    @Positive(message="{produto.valor.positive}")
    private double valor;
    
}
