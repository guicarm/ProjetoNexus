package br.com.plusoft.nexus.usuario.dto;

import java.time.LocalDateTime;

public record UsuarioResponse (
        
        Long id,
        String name,
        String bio,
        String email,
        LocalDateTime createdAt

){}
    