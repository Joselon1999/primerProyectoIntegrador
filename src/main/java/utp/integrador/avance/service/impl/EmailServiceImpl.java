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

    public void sendSimpleMessage() throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();

        message.setFrom("sender@example.com");
        message.setRecipients(MimeMessage.RecipientType.TO, "recipient@example.com");
        message.setSubject("Test email from my Springapplication");
        message.setText(
                "This is the test email template for your email:\n%s\n");
        mailSender.send(message);
    }
}
