package org.playground.dopelemon.service;

import org.playground.dopelemon.model.RegistrationToken;
import org.playground.dopelemon.model.User;
import org.playground.dopelemon.repository.RegistrationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailService {

    @Autowired
    private JavaMailSenderImpl mailSender;

    @Autowired
    private TemplateEngine templateEngine;

    @Autowired
    private RegistrationTokenRepository tokenRepository;

    public void sendInvitationLink(User user) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
        Context ctx = new Context();
        ctx.setVariable("user", user);
        RegistrationToken token = tokenRepository.saveAndFlush(new RegistrationToken(user));
        ctx.setVariable("registrationToken", token.getToken());
        String template = templateEngine.process("invitation_link", ctx);
        messageHelper.setSubject("Tues registration");
        messageHelper.setText(template, true);
        messageHelper.setTo(user.getEmail());
        mailSender.send(mimeMessage);
    }
}
