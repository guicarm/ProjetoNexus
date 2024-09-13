package br.com.plusoft.nexus.usuario.dto;
import br.com.plusoft.nexus.usuario.Usuario;

public record UsuarioResponse (
        Long id, 
        String nome,
        String email,
        String senha,
        String tipo
){
    public static UsuarioResponse from(Usuario usuario) {
        return new UsuarioResponse(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getSenha(),
                usuario.getTipo()
        );
    }

}
    