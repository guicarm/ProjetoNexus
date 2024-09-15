package br.com.plusoft.nexus.apis;


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
public class Api {

        
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotBlank(message = "{api.nome.notblank}")
    @Size(min = 3, max = 100, message="{api.nome.size}") 
     String nome;

    @NotBlank(message = "{api.codigoChave.notblank}")
     String codigoChave;

    @NotBlank(message = "{api.dataInicioChave.notblank}")
     String dataInicioChave;

    @NotBlank(message = "{api.dataFimChave.notblank}")
     String dataFimChave;

}
