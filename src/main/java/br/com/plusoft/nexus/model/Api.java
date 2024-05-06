package br.com.plusoft.nexus.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Api {

        
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "{api.nome.notblank}")
    @Size(min = 3, max = 100, message="{api.nome.size}") 
    private String nome;

    @NotBlank(message = "{api.codigoChave.notblank}")
    private String codigoChave;

    //TODO - Conversar com professor de BD pra saber se esses atributos fazem sentido.
    /*
    @NotBlank(message = "{api.dataInicioChave.notblank}")
    private String dataInicioChave;

    @NotBlank(message = "{api.dataFimChave.notblank}")
    private String dataFimChave;
    */
}
