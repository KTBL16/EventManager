package com.polytechnique.tpfinalpoo2.services.gestion;

import com.polytechnique.tpfinalpoo2.exception.EvenementExistant;
import com.polytechnique.tpfinalpoo2.models.Concert;
import com.polytechnique.tpfinalpoo2.models.Conference;
import com.polytechnique.tpfinalpoo2.models.Evenement;

import java.util.*;


public class GestionEvenements<T extends Evenement> implements Addable<T>, Findable<T>, Editable<T>, Deletable<T> {

    private SauvegardeFactory sauvegardeFactory;
    private Map<String, T> listEvents;


    public GestionEvenements(T evenement) {

        if(evenement instanceof Concert){
            listEvents = (Map<String, T>) sauvegardeFactory.createSauvegarde(SauvegardeType.CONCERT).charger();
        }else if(evenement instanceof Conference){
            listEvents = (Map<String, T>) sauvegardeFactory.createSauvegarde(SauvegardeType.CONFERENCE).charger();
        }

    }

    // ajouter un evenement
    /*pour ajouter je construis un objet de type evenement puis je construit un evenement de type fille , je fais la recherche
    dans le fichier des evenement pour faire une recherche et voir s'il existe si il existe je renvoie un erreur si non
    j'enregistre dans un fichier de type cette classe fille */
    @Override
    public T ajouter(T t) throws  EvenementExistant{
        if(find(t).isPresent()){
            throw new EvenementExistant("Nous ne pouvez pas creer un evenement qui existe deja");
        }
        Map data = new HashMap<String, T>();
        data.put(t.getId(),t);
        if(t instanceof Concert){
            sauvegardeFactory.createSauvegarde(SauvegardeType.CONCERT).sauvegarder(data);
        }else if(t instanceof Conference){
            sauvegardeFactory.createSauvegarde(SauvegardeType.CONFERENCE).sauvegarder(data);
        }
        return t;
    }



    // rechercher un evenement
    /* je liste tous les events et je transforme en flux et je fais une recherche sur le flux si je trouve je retourne l'objet sinon
    je retourne un objet null */

    @Override
    public Optional<T> find(T id) {
        Optional<T> event = Optional.empty();

        if(id instanceof Concert){
            event = listEvents.values().stream()
                    .filter(entry -> entry.getId().equals(id.getId()))
                    .findFirst();
        }else if(id instanceof Conference){
            event = listEvents.values().stream()
                    .filter(entry -> entry.getId().equals(id.getId()))
                    .findFirst();
        }

        return event;
    }



    @Override
    public void  delete(String id) {
        listEvents.remove(id);
        sauvegardeFactory.createSauvegarde(SauvegardeType.CONCERT).sauvegarder((Map<String, ?>)listEvents);
        sauvegardeFactory.createSauvegarde(SauvegardeType.CONFERENCE).sauvegarder(listEvents);
    }

    @Override
    public T edit(String id) {
        return null;
    }




    //delete an event
    //pour delete un evemnement on récupère son id, et en fonction de la classe T, on suprime
    //son entré soit dans le fichier conférence soit dans le fichier concert
    // ensuite su
    // edit event
}


































































//public void initialiseNotification(T e, String message){
//    ArrayList<String> participantsIds = participantOfEvent.get(e.getId());
//    if (participantsIds != null) {
//        participantsEmails = participantsIds.stream()
//                .map(this::getParticipantEmail)
//                .collect(Collectors.toCollection(ArrayList::new));
//        notificationService.envoyerNotifications(e.getNom(), participantsEmails, message);
//    }
//}
//
//private String getParticipantEmail(String participantId) {
//    Participant participant = participants.get(participantId);
//    return participant != null ? participant.getEmail() : null;
//}
