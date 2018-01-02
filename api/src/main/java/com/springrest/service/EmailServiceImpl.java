package com.springrest.service;

import com.springrest.entity.Alert;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class EmailServiceImpl implements EmailService{

    public void sendEmail(Alert alert, String to) {

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        String subject = "High Alert From Car Sensor";
        String from = "example@gmail.com";

        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("example@gmail.com", "password");
                    }
                });

        Message msg = new MimeMessage(session);
        try {
            msg.setFrom(new InternetAddress(from));
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            msg.setSubject(subject);
            msg.setText("Hi,\n\nThis is an auto-generated mail in order to inform you about an Alert with High priority." +
                             "\n You must perform an appropriate action to solve this issue." +
                             "\n Alert Name: " + alert.getAlertType() +
                             "\n Vehicle No: " + alert.getVin() +
                             "\n Alert Priority: " + alert.getPriority());

            // Send the message.
            Transport.send(msg);
        } catch (MessagingException e) {
            System.out.println( "Make sure to add your domain password for your host." +
                    e.getMessage());
        }
    }
}
