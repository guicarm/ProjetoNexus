package br.com.plusoft.nexus.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class AuthController {
    
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public Token login(@RequestBody Credentials credentials){
        return authService.login(credentials);
    }
    
}
