package br.com.plusoft.nexus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.plusoft.nexus.model.Api;

public interface ApiRepository extends JpaRepository<Api, Long>{
    
}
