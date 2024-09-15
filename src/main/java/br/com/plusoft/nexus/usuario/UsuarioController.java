package br.com.plusoft.nexus.usuario;

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
import org.springframework.web.util.UriComponentsBuilder;

import br.com.plusoft.nexus.usuario.dto.UsuarioRequest;
import br.com.plusoft.nexus.usuario.dto.UsuarioResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("usuario")
@Slf4j
@Tag(name = "Usuários")
public class UsuarioController {
   
 
    @Autowired
    UsuarioService usuarioService;

    @Autowired // Injeção de Dependência
    UsuarioRepository repository;


    // ========== GET(Listar Usuarios) ============
    @GetMapping
    @Operation(
        summary = "Listar Usuários",
        description = "Retorna um array com todos usuários registrados."
    )
    public List<Usuario> index(){
        return repository.findAll();
    }
 
 
    // ========== POST(Cadastrar Usuario) ============
    @PostMapping
    @ResponseStatus(CREATED)
    @Operation(
        summary = "Cadastrar Usuários",
        description = "Cadastra um usuário especificado através de seu ID."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "Usuário criado com sucesso."),
        @ApiResponse(responseCode = "400", description = "Validação falhou. Verifique o corpo da requisição.")
    })
    public ResponseEntity<UsuarioResponse> create(@RequestBody UsuarioRequest usuarioRequest, UriComponentsBuilder uriBuilder){
        var usuario = usuarioService.create(usuarioRequest.toModel());

        var uri = uriBuilder
                    .path("/usuario/{id}")
                    .buildAndExpand(usuario.getId())
                    .toUri();

        return ResponseEntity
                .created(uri)
                .body(UsuarioResponse.from(usuario));
    }
 
 
    // ========== GET(Detalhar Usuario) ============
    @GetMapping("{id}")
    @Operation(
        summary = "Detalhar Usuários",
        description = "Detalha um usuário especificado através de seu ID."
    )
    public ResponseEntity<Usuario> show(@PathVariable Long id){
        log.info("buscando usuario com id {}", id);
 
            return repository
                            .findById(id)
                            .map(ResponseEntity::ok)
                            .orElse(ResponseEntity.notFound().build());
    }
 

    // ========== DELETE (Excluir Usuario) ============
    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    @Operation(
        summary = "Excluir Usuários",
        description = "Exclui um usuário especificado através de seu ID."
    )
    public void destroy(@PathVariable Long id){
        log.info("Usuario apagado {}.", id);
 
        verificarSeUsuarioExiste(id);
        repository.deleteById(id);
                   
    }
 
 
    // ========== PUT (Atualizar Usuario) ============
    @PutMapping("{id}")
    @Operation(
        summary = "Atualizar Usuários",
        description = "Atualiza um usuário especificado através de seu ID."
    )
    public Usuario update(@PathVariable Long id, @RequestBody Usuario usuario){
        log.info("Atualizando usuario {} para {}", id, usuario);
 
        verificarSeUsuarioExiste(id);
        usuario.setId(id);
        return repository.save(usuario);
 
    }
 


  // ==== MÉTODO VERIFICAR SE USUARIO EXISTE ========
 private void verificarSeUsuarioExiste(Long id) {
                repository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                                            NOT_FOUND,
                                            "Não existe usuario com o ID informado.")
                            );
    }
}