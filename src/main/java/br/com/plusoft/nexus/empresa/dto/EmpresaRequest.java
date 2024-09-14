package br.com.plusoft.nexus.empresa.dto;

import br.com.plusoft.nexus.empresa.Empresa;

public record EmpresaRequest (
    Long id,
    String razaoSocial,
    String nomeFantasia,
    String areaDeAtuacao,
    String cnpj
) {
    public Empresa toModel(){
        return Empresa.builder()
            .razaoSocial(razaoSocial)
            .nomeFantasia(nomeFantasia)
            .areaDeAtuacao(areaDeAtuacao)
            .cnpj(cnpj)
            .build();
    }
}
