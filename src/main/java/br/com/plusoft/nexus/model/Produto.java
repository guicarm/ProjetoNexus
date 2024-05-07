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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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

    @NotNull(message = "{produto.quantidade.notnull}")
    @PositiveOrZero(message="{produto.quantidade.positiveorzero}")
    private int quantidade;

    @NotBlank(message = "{produto.descricao.notblank}")
    @Size(max = 255, message="{produto.descricao.size}")
    private String descricao;

    @NotNull(message = "{produto.valor.notnull}")
    @Positive(message="{produto.valor.positive}")
    private double valor;
    
}
