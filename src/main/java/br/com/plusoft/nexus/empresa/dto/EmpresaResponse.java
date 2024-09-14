package br.com.plusoft.nexus.empresa.dto;

import br.com.plusoft.nexus.empresa.Empresa;

public record EmpresaResponse (
    Long id,
    String razaoSocial,
    String nomeFantasia,
    String areaDeAtuacao,
    String cnpj
) {
   public static EmpresaResponse from (Empresa empresa) {
        return new EmpresaResponse(
                empresa.getId(),
                empresa.getRazaoSocial(),
                empresa.getNomeFantasia(),
                empresa.getAreaDeAtuacao(),
                empresa.getCnpj()
        );
   } 
}
