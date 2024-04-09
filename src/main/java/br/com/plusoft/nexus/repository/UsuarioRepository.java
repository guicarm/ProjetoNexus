package br.com.plusoft.nexus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.plusoft.nexus.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
}
