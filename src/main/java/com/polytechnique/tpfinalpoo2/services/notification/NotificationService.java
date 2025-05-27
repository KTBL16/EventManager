package com.polytechnique.tpfinalpoo2.services.notification;

import io.github.cdimascio.dotenv.Dotenv;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.CompletableFuture;

public class NotificationService implements INotificationService {

    @Override
    public void envoyerNotifications(String nomEvenement, List<String> participantEmails, String message) {
        CompletableFuture.runAsync(() -> {
            participantEmails.stream()
                    .forEach(participant -> envoyerEmail(participant, nomEvenement, message));
        });
    }

    private void envoyerEmail(String participantEmails, String evenementNom, String message) {
        Dotenv dotenv = Dotenv.load();
        String username = dotenv.get("EMAIL_USER");
        String password = dotenv.get("EMAIL_PASSWORD");
        String host = "smtp.gmail.com";
        String port = "587";

        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message emailMessage = new MimeMessage(session);
            emailMessage.setFrom(new InternetAddress(username));
            emailMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(participantEmails));
            emailMessage.setSubject("Notification pour l'événement " + evenementNom);
            emailMessage.setText(message);

            Transport.send(emailMessage);

            System.out.println("Email envoyé avec succès à " + participantEmails);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
