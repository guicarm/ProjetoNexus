package br.com.plusoft.nexus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.plusoft.nexus.model.Chatbot;

public interface ChatbotRepository extends JpaRepository<Chatbot, Long> {
    
}
