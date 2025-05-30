package com.polytechnique.tpfinalpoo2.services.gestion;

import com.polytechnique.tpfinalpoo2.models.Evenement;
import com.polytechnique.tpfinalpoo2.models.Participant;
import com.polytechnique.tpfinalpoo2.sauvegarde.Sauvegarde;


import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

public class GestionParticipant {

    private static GestionParticipant instance;
    private Map<String, Participant> participants;
    private Map<String, Evenement> event;
    private String fichierEvent = "evenements.json";
    private String fichierParticipant = "participants.json";

    //Constructeur privé
    private GestionParticipant() {
        participants = (Map<String, Participant>) Sauvegarde.getIntance().charger(fichierParticipant);
        event = (Map<String, Evenement>) Sauvegarde.getIntance().charger(fichierEvent);
    }

    //getter et setter

    public Map<String, Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(Map<String, Participant> participants) {
        this.participants = participants;
    }

    public Map<String, Evenement> getEvent() {
        return event;
    }

    public void setEvent(Map<String, Evenement> event) {
        this.event = event;
    }

    //get instance
    public static GestionParticipant getInstance() {
        if (instance == null) {
            instance = new GestionParticipant();
        }
        return instance;
    }


    public boolean ajouterParticipant(Participant p, String eventId) {
        if (event.get(eventId).getParticipants().size() == event.get(eventId).getCapaciteMax()){
            return false;
        }else {
            event.get(eventId).ajouterParticipant(p);
            Sauvegarde.getIntance().sauvegarder(event, fichierEvent);
            return true;
        }
    }

    public boolean ajouterSimpleParticipant(Participant p) {
        if (participants.containsKey(p.getEmail())){
            return false;
        }else {
            participants.put(p.getEmail(), p);
            SauvegardeParticipant.getInstance().sauvegarder(participants);
            return true;
        }
    }

    public void supprimerParticipant(String id) {

        //utilisation des streams

        if (participants.containsKey(id)) {
            participantOfEvent = participantOfEvent.entrySet().stream()
                    .peek(entry -> entry.getValue().removeIf(element -> element.equals(id)))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
            SauvegardeParticipantOfEvent.getInstance().sauvegarder(participantOfEvent);

            Participant p = participants.remove(id);
            SauvegardeParticipant.getInstance().sauvegarder(participants);
        }else{
            System.out.println("❌ Aucun Participant avec l’ID : " + id);
        }
    }

    public Participant rechercherParticipant(String id) {
        return participants.get(id);
    }


}

