package br.com.plusoft.nexus.mail;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.mail.MessagingException;

public class EmailConsumer {
    
    @Autowired
    MailService mailService;

    @RabbitListener(queues = "empresa-queue")
    public void sendEmail(String message) throws MessagingException {
        mailService.sendEmail(message);
    }
}
