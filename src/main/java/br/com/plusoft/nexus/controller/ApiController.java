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

import br.com.plusoft.nexus.model.Api;
import br.com.plusoft.nexus.repository.ApiRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("api")
@Slf4j
@Tag(name = "API's")
public class ApiController {
   
 
    @Autowired // Injeção de Dependência
    ApiRepository repository;
   
// ========== GET(Listar API) ============
    @Operation(
        summary = "Listar API's",
        description = "Retorna um array com todas as API's registradas."
    )
    @GetMapping
    public List<Api> index(){
        return repository.findAll();
    }

 
 
    // ========== POST(Cadastrar API) ============
    @PostMapping
    @ResponseStatus(CREATED)
    @Operation(
        summary = "Cadastrar API's",
        description = "Cadastra uma API através de um request body."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "API criada com sucesso."),
        @ApiResponse(responseCode = "400", description = "Validação falhou. Verifique o corpo da requisição.")
    })
    public Api create(@RequestBody @Valid Api api){
        log.info("API Cadastrada {}", api);
        return repository.save(api);
    }
 
 
    // ========== GET(Detalhar API) ============
    @GetMapping("{id}")
    @Operation(
        summary = "Detalhar API's",
        description = "Retorna uma API especificada através de seu ID."
    )
    public ResponseEntity<Api> show(@PathVariable Long id){
        log.info("buscando API com id {}", id);
 
            return repository
                            .findById(id)
                            .map(ResponseEntity::ok)
                            .orElse(ResponseEntity.notFound().build());
    }
 
    // ========== DELETE (Excluir API) ============
    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    @Operation(
        summary = "Deletar API's",
        description = "Deleta uma API especificada através de seu ID."
    )
    public void destroy(@PathVariable Long id){
        log.info("API apagada {}.", id);
 
        verificarSeApiExiste(id);
        repository.deleteById(id);
                   
    }
 
 
    // ========== PUT (Atualizar API) ============
    @PutMapping("{id}")
    @Operation(
        summary = "Atualizar API's",
        description = "Atualiza uma API especificada através de seu ID."
    )
    public Api update(@PathVariable Long id, @RequestBody Api api){
        log.info("Atualizando Api {} para {}", id, api);
 
        verificarSeApiExiste(id);
        api.setId(id);
        return repository.save(api);
 
    }
 

 
  // ==== MÉTODO VERIFICAR SE A API EXISTE ========
 private void verificarSeApiExiste(Long id) {
        repository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                                            NOT_FOUND,
                                            "Não existe API com o ID informado.")
                            );
    }
}
 
