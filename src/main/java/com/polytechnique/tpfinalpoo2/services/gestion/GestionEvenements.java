package com.polytechnique.tpfinalpoo2.services.gestion;

import com.polytechnique.tpfinalpoo2.models.Evenement;
import com.polytechnique.tpfinalpoo2.models.Participant;
import com.polytechnique.tpfinalpoo2.sauvegarde.SauvegardeEvenement;
import com.polytechnique.tpfinalpoo2.sauvegarde.SauvegardeParticipant;
import com.polytechnique.tpfinalpoo2.sauvegarde.SauvegardeParticipantOfEvent;
import com.polytechnique.tpfinalpoo2.services.notification.INotificationService;
import com.polytechnique.tpfinalpoo2.services.notification.NotificationService;


import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;


public class GestionEvenements {

    private static GestionEvenements instance;
    private Map<String, Evenement> evenements;
    private Map<String, Participant> participants;
    private Map<String, ArrayList<String>> participantOfEvent;
    private INotificationService notificationService;


    private ArrayList<String> participantsEmails;



    //Constructeur privé
    private GestionEvenements() {
        evenements = new HashMap<>();
        SauvegardeEvenement.getInstance().charger();
        participants = SauvegardeParticipant.getInstance().charger();
        participantOfEvent = SauvegardeParticipantOfEvent.getInstance().charger();
        notificationService = new NotificationService();
    }


    //get instance
    public static GestionEvenements getInstance() {
        if (instance == null) {
            instance = new GestionEvenements();
        }
        return instance;
    }


    public void ajouterEvenement(Evenement e) {
        evenements.put(e.getId(), e);
        SauvegardeEvenement.getInstance().sauvegarder(evenements);
        System.out.println("Évènement ajouté : " + e.getNom());
    }

    public void supprimerEvenement(String id) {

        if (evenements.containsKey(id)) {
            Evenement e = evenements.remove(id);
            SauvegardeEvenement.getInstance().sauvegarder(evenements);
            System.out.println("Évènement supprimé : " + e.getNom());
            initialiseNotification(e, "L'événement " + e.getNom() + " a été supprimer");
        } else {
            System.out.println("❌ Aucun événement avec l’ID : " + id);
        }
    }

    public void editerEvenement(Evenement e) {
        supprimerEvenement(e.getId());
        ajouterEvenement(e);

        initialiseNotification(e, "L'événement " + e.getNom() + " a été modifié. Bien vouloir vous rendre dans l'application pour consulter les modifications ");
    }

    public void initialiseNotification(Evenement e, String message){

        ArrayList<String> participantsIds = participantOfEvent.get(e.getId());
        participantsEmails = participantsIds.stream()
                .map(this::getParticipantEmail)
                .collect(Collectors.toCollection(ArrayList::new));

        if (participantsIds != null) {
            notificationService.envoyerNotifications(e.getNom(), participantsEmails, message);
        }
    }

    private String getParticipantEmail(String participantId) {

        Participant participant = participants.get(participantId);
        if (participant != null) {
            return participant.getEmail();
        }
        return null;
    }


    // par exemple pour update un évènement, on doit le rechercher, le supprimer et ajouter la nouvelle instance

    public Evenement rechercherEvenement(String id) {
        return evenements.get(id);
    }


    //getter et setter

    public Map<String, Evenement> getEvenements() {
        return evenements;
    }

    public void setEvenements(Map<String, Evenement> evenements) {
        this.evenements = evenements;
    }
}
