package br.com.plusoft.nexus.controller;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.NO_CONTENT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.plusoft.nexus.model.Chatbot;
import br.com.plusoft.nexus.repository.ChatbotRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("chatbot")
@Slf4j
public class ChatbotController {
   
 
    @Autowired // Injeção de Dependência
    ChatbotRepository repository;
   
// ========== GET(Listar Chatbot) ============
    @GetMapping
    public List<Chatbot> index(){
        return repository.findAll();
    }

 
 
    // ========== POST(Cadastrar Chatbot) ============
    @PostMapping
    @ResponseStatus(CREATED)
    public Chatbot create(@RequestBody @Valid Chatbot chatbot){
        log.info("Chatbot Cadastrado {}", chatbot);
        return repository.save(chatbot);
    }
 
 
    // ========== GET(Detalhar Chatbot) ============
    @GetMapping("{id}")
    public ResponseEntity<Chatbot> show(@PathVariable Long id){
        log.info("buscando Chatbot com id {}", id);
 
            return repository
                            .findById(id)
                            .map(ResponseEntity::ok)
                            .orElse(ResponseEntity.notFound().build());
    }
 
    // ========== DELETE (Excluir Chatbot) ============
    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void destroy(@PathVariable Long id){
        log.info("Chatbot apagada {}.", id);
 
        verificarSeChatbotExiste(id);
        repository.deleteById(id);
                   
    }
 
 
    // ========== PUT (Atualizar Chatbot) ============
    @PutMapping("{id}")
    public Chatbot update(@PathVariable Long id, @RequestBody Chatbot chatbot){
        log.info("Atualizando Chatbot {} para {}", id, chatbot);
 
        verificarSeChatbotExiste(id);
        chatbot.setId(id);
        return repository.save(chatbot);
 
    }
 

 
  // ==== MÉTODO VERIFICAR SE O Chatbot EXISTE ========
 private void verificarSeChatbotExiste(Long id) {
        repository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                                            NOT_FOUND,
                                            "Não existe Chatbot com o ID informado.")
                            );
    }
}  
