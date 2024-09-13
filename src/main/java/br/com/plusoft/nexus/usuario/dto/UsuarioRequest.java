package br.com.plusoft.nexus.usuario.dto;
import br.com.plusoft.nexus.usuario.Usuario;

public record UsuarioRequest (
        Long id, 
        String nome,
        String email,
        String senha,
        String tipo
){
    public Usuario toModel() {
        return Usuario.builder()
                .nome(nome)
                .email(email)
                .senha(senha)
                .tipo(tipo)
                .build();
    }
}