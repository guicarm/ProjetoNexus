package br.com.plusoft.nexus.mail;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import br.com.plusoft.nexus.usuario.Usuario;
import jakarta.mail.MessagingException;

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

    public void sendEmail(String message) throws MessagingException {

        var email = mailSender.createMimeMessage();
        var helper = new MimeMessageHelper(email);

        helper.setTo("gui@gmail.com");
        helper.setSubject("Nova Parceria Cadastrada");
        helper.setText("""
                    <h1>Boas notícias!!!</h1>
                    <p>%s foi cadastrada como empresa parceira</p>
                """.formatted(message), true);

        mailSender.send(email);

    }
}
