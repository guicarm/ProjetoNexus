package br.com.plusoft.nexus.model;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data

public class Funcionario extends Usuario {
    
    @NotBlank(message = "{funcionario.codigoFunc.notblank}")
    @Size(min = 1, max = 9, message = "{funcionario.codigoFunc.size}")
    private long codigoFunc;

}