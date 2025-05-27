package com.polytechnique.tpfinalpoo2.services.notification;

import java.util.List;

public interface INotificationService {

    public void envoyerNotifications(String nomEvenement, List<String> participantEmails, String message);
}
