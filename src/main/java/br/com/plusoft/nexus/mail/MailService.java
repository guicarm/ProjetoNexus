package br.com.plusoft.nexus.mail;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import br.com.plusoft.nexus.usuario.Usuario;

@Service
public class MailService {

    private final JavaMailSenderImpl mailSender;

    public MailService(JavaMailSenderImpl mailSender) {
        this.mailSender = mailSender;
    }

    public void sendWelcomeMail(Usuario usuario) {

        var email = new SimpleMailMessage();
        email.setTo(usuario.getEmail());
        email.setSubject("Boas Vindas");
        email.setText("""
                    Olá, %s.
                    
                    Obrigado por adentrar ao Nexus
                    Bem-vindo ao seu mundo de mudanças.
                    
                    Att
                    Nexus
                """.formatted(usuario.getNome()));

        mailSender.send(email);

    }
}
