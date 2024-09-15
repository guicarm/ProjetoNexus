package br.com.plusoft.nexus.produto;

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

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotBlank(message = "{produto.tipo.notblank}")
    @Size(max = 255, message="{produto.tipo.size}")
    String tipo;

    @NotBlank(message = "{produto.nome.notblank}")
    @Size(max = 255, message="{produto.nome.size}")
    String nome;

    @NotBlank(message = "{produto.marca.notblank}")
    @Size(max = 255, message="{produto.marca.size}")
    String marca;

    @NotBlank(message = "{produto.modelo.notblank}")
    @Size(max = 255, message="{produto.modelo.size}")
    String modelo;

    @NotNull(message = "{produto.quantidade.notnull}")
    @PositiveOrZero(message="{produto.quantidade.positiveorzero}")
    int quantidade;

    @NotBlank(message = "{produto.descricao.notblank}")
    @Size(max = 255, message="{produto.descricao.size}")
    String descricao;

    @NotNull(message = "{produto.valor.notnull}")
    @Positive(message="{produto.valor.positive}")
    double valor;
    
}
