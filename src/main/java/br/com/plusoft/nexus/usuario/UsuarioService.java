package br.com.plusoft.nexus.usuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.plusoft.nexus.mail.MailService;

@Service
public class UsuarioService  {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private MailService mailService;


    // GET - FINDALL
    public List<Usuario> findAll(){
        return usuarioRepository.findAll();
    }

    // CREATE
    public Usuario create(Usuario usuario){
        usuario.setSenha(
                passwordEncoder.encode(usuario.getSenha())
        );

        mailService.sendWelcomeMail(usuario);
        return usuarioRepository.save(usuario);
    }

}