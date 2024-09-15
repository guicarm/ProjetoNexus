package br.com.plusoft.nexus.auth;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;


import br.com.plusoft.nexus.usuario.Usuario;
import br.com.plusoft.nexus.usuario.UsuarioRepository;

@Service
public class TokenService {

    @Autowired
    UsuarioRepository usuarioRepository;
    
    private Algorithm algorithm;

    public TokenService(UsuarioRepository usuarioRepository, @Value("${jwt.secret}") String secret) {
        this.usuarioRepository = usuarioRepository;
        this.algorithm = Algorithm.HMAC256(secret);
    }

    public Token create(Credentials credentials) {
        var expiresAt = LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.ofHours(-3));
        var token = JWT.create()
                .withSubject(credentials.email())
                .withExpiresAt(expiresAt)
                .sign(algorithm);
        return new Token(token, credentials.email());
    }

    public Usuario getUsuarioFromToken(String token) {
        var email = JWT.require(algorithm)
                .build()
                .verify(token)
                .getSubject();

        return usuarioRepository.findByEmail(email).orElseThrow(
                () -> new UsernameNotFoundException("Usuário não encontrado")
        );
    }
}