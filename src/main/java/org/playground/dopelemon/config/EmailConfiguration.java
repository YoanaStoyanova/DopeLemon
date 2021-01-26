package org.playground.dopelemon.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class EmailConfiguration {

    private String username;

    private String password;

    private int port;

    private String protocol;

    private String server;

    @Autowired
    public EmailConfiguration(@Value("${mail.username}")String username,
                              @Value("${mail.password}")String password,
                              @Value("${mail.server}") String server,
                              @Value("${mail.transport.protocol}")String protocol,
                              @Value("${mail.port}")int port){
        this.username = username;
        this.password = password;
        this.server = server;
        this.port = port;
        this.protocol = protocol;
    }

    @Bean
    public JavaMailSenderImpl getJavaMailSender(){
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(server);
        mailSender.setPort(port);
        mailSender.setUsername(username);
        mailSender.setPassword(password);
        Properties properties = new Properties();
        properties.put("mail.transport.protocol", protocol);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.auth", "true");
        mailSender.setJavaMailProperties(properties);
        return mailSender;
    }
}
