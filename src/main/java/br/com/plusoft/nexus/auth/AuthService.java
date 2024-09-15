package br.com.plusoft.nexus.auth;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import br.com.plusoft.nexus.usuario.UsuarioRepository;

@Service
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    public AuthService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder, TokenService tokenService) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.tokenService = tokenService;
    }

    public Token login(Credentials credentials) {
        var usuario = usuarioRepository.findByEmail(credentials.email())
                .orElseThrow( () -> new RuntimeException("Acesso negado.") );

        if (!passwordEncoder.matches(credentials.senha(), usuario.getSenha()))
            throw new RuntimeException("Acesso negado.");

        return tokenService.create(credentials);
    }

}
