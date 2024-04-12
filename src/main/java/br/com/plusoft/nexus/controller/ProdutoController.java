package br.com.plusoft.nexus.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.NO_CONTENT;

import java.util.List;

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

import br.com.plusoft.nexus.model.Produto;
import br.com.plusoft.nexus.repository.ProdutoRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
 
 
@RestController
@RequestMapping("produto")
@Slf4j
public class ProdutoController {
   
 
    @Autowired // Injeção de Dependência
    ProdutoRepository repository;
   
// ========== GET(Listar Produtos) ============
    @GetMapping
    public List<Produto> index(){
        return repository.findAll();
    }
 
 
    // ========== POST(Cadastrar Produto) ============
    @PostMapping
    @ResponseStatus(CREATED)
    public Produto create(@RequestBody @Valid Produto produto){
        log.info("Produto Cadastrado {}", produto);
        return repository.save(produto);
    }
 
 
    // ========== GET(Detalhar Produto) ============
    @GetMapping("{id}")
    public ResponseEntity<Produto> show(@PathVariable Long id){
        log.info("buscando produto com id {}", id);
 
            return repository
                            .findById(id)
                            .map(ResponseEntity::ok)
                            .orElse(ResponseEntity.notFound().build());
    }
 
    // ========== DELETE (Excluir Produto) ============
    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void destroy(@PathVariable Long id){
        log.info("Produto apagado {}.", id);
 
        verificarSeProdutoExiste(id);
        repository.deleteById(id);
                   
    }
 
 
    // ========== PUT (Atualizar Produto) ============
    @PutMapping("{id}")
    public Produto update(@PathVariable Long id, @RequestBody Produto produto){
        log.info("Atualizando produto {} para {}", id, produto);
 
        verificarSeProdutoExiste(id);
        produto.setId(id);
        return repository.save(produto);
 
    }
 

 
  // ==== MÉTODO VERIFICAR SE PRODUTO EXISTE ========
 private void verificarSeProdutoExiste(Long id) {
        repository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                                            NOT_FOUND,
                                            "Não existe produto com o ID informado.")
                            );
    }
}
 
