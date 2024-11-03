package br.com.plusoft.nexus.empresa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Table(name = "T_NX_EMPRESA")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotBlank(message = "{empresa.razaoSocial.notblank}")
    @Size(min = 3, max = 50, message = "{empresa.razaoSocial.size}") 
    @Column(name = "nm_razao_social", nullable = false) 
    String razaoSocial;

    @Size(min = 3, max = 50, message = "{empresa.nomeFantasia.size}")
    @Column(name = "nm_fantasia") 
    String nomeFantasia;

    @NotBlank(message = "{empresa.areaDeAtuacao.notblank}")
    @Size(min = 3, max = 50, message = "{empresa.areaDeAtuacao.size}")
    @Column(name = "tp_area_atuacao", nullable = false) 
    String areaDeAtuacao; 

    @NotBlank(message = "{empresa.cnpj.notblank}")
    @Size(max = 15, message = "{empresa.cnpj.size}") 
    @Column(name = "nr_cnpj", nullable = false) 
    String cnpj;
}
