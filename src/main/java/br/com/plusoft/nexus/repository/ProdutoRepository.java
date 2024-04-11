package br.com.plusoft.nexus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.plusoft.nexus.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
    
}
