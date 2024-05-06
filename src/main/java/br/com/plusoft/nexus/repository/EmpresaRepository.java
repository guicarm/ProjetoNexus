package br.com.plusoft.nexus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.plusoft.nexus.model.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
    
}
