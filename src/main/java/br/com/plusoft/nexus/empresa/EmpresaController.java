package br.com.plusoft.nexus.empresa;

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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("empresa")
@Slf4j
@Tag(name = "Empresas")
public class EmpresaController {
   
 
    @Autowired // Injeção de Dependência
    EmpresaRepository repository;
   
// ========== GET(Listar Empresa) ============
    @GetMapping
    @Operation(
        summary = "Listar Empresas",
        description = "Retorna um array com todas as empresas registradas."
    )
    public List<Empresa> index(){
        return repository.findAll();
    }

 
 
    // ========== POST(Cadastrar Empresa) ============
    @PostMapping
    @ResponseStatus(CREATED)
    @Operation(
        summary = "Cadastrar Empresas",
        description = "Cadastra uma empresa especificada através de seu ID."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "Empresa criada com sucesso."),
        @ApiResponse(responseCode = "400", description = "Validação falhou. Verifique o corpo da requisição.")
    })
    public Empresa create(@RequestBody @Valid Empresa empresa){
        log.info("Empresa Cadastrada {}", empresa);
        return repository.save(empresa);
    }
 
 
    // ========== GET(Detalhar Empresa) ============
    @GetMapping("{id}")
    @Operation(
        summary = "Detalhar Empresas",
        description = "Detalha uma empresa especificada através de seu ID."
    )
    public ResponseEntity<Empresa> show(@PathVariable Long id){
        log.info("buscando Empresa com id {}", id);
 
            return repository
                            .findById(id)
                            .map(ResponseEntity::ok)
                            .orElse(ResponseEntity.notFound().build());
    }
 
    // ========== DELETE (Excluir Empresa) ============
    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    @Operation(
        summary = "Excluir Empresas",
        description = "Exclui uma empresa especificada através de seu ID."
    )
    public void destroy(@PathVariable Long id){
        log.info("Empresa apagada {}.", id);
 
        verificarSeEmpresaExiste(id);
        repository.deleteById(id);
                   
    }
 
 
    // ========== PUT (Atualizar Empresa) ============
    @PutMapping("{id}")
    @Operation(
        summary = "Atualizar Empresas",
        description = "Atualiza uma empresa especificada através de seu ID."
    )
    public Empresa update(@PathVariable Long id, @RequestBody Empresa empresa){
        log.info("Atualizando Empresa {} para {}", id, empresa);
 
        verificarSeEmpresaExiste(id);
        empresa.setId(id);
        return repository.save(empresa);
 
    }
 

 
  // ==== MÉTODO VERIFICAR SE A Empresa EXISTE ========
 private void verificarSeEmpresaExiste(Long id) {
        repository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                                            NOT_FOUND,
                                            "Não existe Empresa com o ID informado.")
                            );
    }
}  
