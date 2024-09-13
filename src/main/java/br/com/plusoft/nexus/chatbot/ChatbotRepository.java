package br.com.plusoft.nexus.chatbot;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatbotRepository extends JpaRepository<Chatbot, Long> {
    
}
