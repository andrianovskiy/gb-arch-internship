package com.arch.intern.crm.backend.auth.service;

import com.arch.intern.crm.backend.auth.config.MailConfig;
import com.arch.intern.crm.backend.auth.model.User;
import com.arch.intern.crm.backend.config.ServerConfig;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


/**
 * @author Marchenko_DS in 17/06/2021 - 17:51
 */
@Service
public class MailSender {

    private final JavaMailSender javaMailSender;
    private final MailConfig mailConfig;
    private final ServerConfig serverConfig;

    public MailSender(JavaMailSender mailSender, MailConfig mailConfig, ServerConfig serverConfig) {
        this.javaMailSender = mailSender;
        this.mailConfig = mailConfig;
        this.serverConfig = serverConfig;
    }

    /**
     * send
     *
     * @param emailTo
     * @param subject
     * @param message
     */
    public void send(String emailTo, String subject, String message) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(mailConfig.getUsername());
        mailMessage.setTo(emailTo);
        mailMessage.setSubject(subject);
        mailMessage.setText(message);
        javaMailSender.send(mailMessage);
    }

    /**
     * sendActivationMessage
     * @param user
     */
    public void sendActivationMessage(User user) {
        if (!user.getEmail().isEmpty()) {
            send(user.getEmail(), "Activation code",
                    "To activate please, visit next link:" +
                            serverConfig.getHost()
                            + "/activate/" + user.getActivationCode());
        }
    }
}
