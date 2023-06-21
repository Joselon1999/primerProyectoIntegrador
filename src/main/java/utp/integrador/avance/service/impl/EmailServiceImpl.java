package utp.integrador.avance.service.impl;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl {

    @Autowired
    private JavaMailSender mailSender;

    public void sendSimpleMessage(String email) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();

        message.setFrom(email);
        message.setRecipients(MimeMessage.RecipientType.TO, email);
        message.setSubject("Bienvenido a ZEGELIPAE");
        message.setText(
                "Bienvenido a ZEGELIPAE\n");
        mailSender.send(message);
    }


    public void sendCompleteMessage(String email) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();

        message.setFrom(email);
        message.setRecipients(MimeMessage.RecipientType.TO, email);
        message.setSubject("ZEGELIPAE: Registro completado");
        message.setText(
                "Tu registro se ha completado\n");
        mailSender.send(message);
    }
}
