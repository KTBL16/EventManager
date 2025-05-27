package com.polytechnique.tpfinalpoo2.services.gestion;

import com.polytechnique.tpfinalpoo2.models.Evenement;
import com.polytechnique.tpfinalpoo2.models.Participant;
import com.polytechnique.tpfinalpoo2.sauvegarde.SauvegardeParticipant;
import com.polytechnique.tpfinalpoo2.sauvegarde.SauvegardeParticipantOfEvent;

import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

public class GestionParticipant {

    private static GestionParticipant instance;
    private Map<String, Participant> participants;
    private Map<String, ArrayList<String>> participantOfEvent;

    //Constructeur privé
    private GestionParticipant() {
        participants = SauvegardeParticipant.getInstance().charger();
        participantOfEvent = SauvegardeParticipantOfEvent.getInstance().charger();
    }

    //get instance
    public static GestionParticipant getInstance() {
        if (instance == null) {
            instance = new GestionParticipant();
        }
        return instance;
    }


    public boolean ajouterParticipant(Participant p, Evenement e) {
        if (participantOfEvent.size() == e.getCapaciteMax()){
            return false;
        }else {
            participantOfEvent.get(e.getId()).add(p.getId());
            SauvegardeParticipantOfEvent.getInstance().sauvegarder(participantOfEvent);
            SauvegardeParticipantOfEvent.getInstance().charger();
            return true;
        }
    }

    public boolean ajouterSimpleParticipant(Participant p) {
        if (participants.containsKey(p.getId())){
            return false;
        }else {
            participants.put(p.getId(), p);
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

