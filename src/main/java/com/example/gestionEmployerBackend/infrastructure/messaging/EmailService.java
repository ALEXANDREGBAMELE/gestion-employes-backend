package com.example.gestionEmployerBackend.infrastructure.messaging;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.example.gestionEmployerBackend.application.exception.EmailException;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private TemplateEngine templateEngine;

    public void sendSimpleEmail(String to, String subject, String text) {
        validateEmailParameters(to, subject, text);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        mailSender.send(message);
    }

    public void sendEmailWithAttachment(String to, String subject, String text, String attachmentPath) {
        validateEmailParameters(to, subject, text);

        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(text);

            FileSystemResource file = new FileSystemResource(new File(attachmentPath));
            helper.addAttachment("piece-jointe.pdf", file);

            mailSender.send(message);
        } catch (MessagingException e) {
            throw new EmailException("Erreur lors de l'envoi de l'e-mail avec pièce jointe", e);
        }
    }

    public void sendHtmlEmail(String to, String subject, String html) {
        validateEmailParameters(to, subject, html);

        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(html, true);
            mailSender.send(message);
        } catch (MessagingException e) {
            throw new EmailException("Erreur lors de l'envoi de l'e-mail HTML", e);
        }
    }

    public void sendHtmlEmailWithTemplate(String to, String subject, String templateName, Context context) {
        validateEmailParameters(to, subject, templateName);

        String htmlContent = templateEngine.process(templateName, context);
        sendHtmlEmail(to, subject, htmlContent);
    }

    private void validateEmailParameters(String to, String subject, String content) {
        if (!StringUtils.hasText(to)) {
            throw new IllegalArgumentException("L'adresse e-mail du destinataire ne peut pas être vide.");
        }
        if (!StringUtils.hasText(subject)) {
            throw new IllegalArgumentException("Le sujet de l'e-mail ne peut pas être vide.");
        }
        if (!StringUtils.hasText(content)) {
            throw new IllegalArgumentException("Le contenu de l'e-mail ne peut pas être vide.");
        }
    }
}