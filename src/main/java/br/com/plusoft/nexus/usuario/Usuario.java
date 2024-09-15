package br.com.plusoft.nexus.usuario;

import br.com.plusoft.nexus.validation.TipoUsuario;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "T_NX_USUARIO")
public class Usuario {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotBlank(message = "{usuario.nome.notblank}")
    @Size(min = 3, max = 255, message = "{usuario.nome.size}")
     String nome;

    @NotBlank(message = "{usuario.email.notblank}")
    @Email(message = "{usuario.email.email}")
     String email;

    @NotBlank(message = "{usuario.senha.notblank}")
     String senha;

    @TipoUsuario
     String tipo; // Cliente e/ou Funcionário

}
