package com.polytechnique.tpfinalpoo2.services.gestion;

import com.polytechnique.tpfinalpoo2.models.Evenement;
import com.polytechnique.tpfinalpoo2.sauvegarde.SauvegardeEvenement;

import java.util.Map;
import java.util.HashMap;

public class GestionEvenements {

    private static GestionEvenements instance;
    private Map<String, Evenement> evenements;



    //Constructeur privé
    private GestionEvenements() {
        evenements = new HashMap<>();
        SauvegardeEvenement.getInstance().charger();
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
        } else {
            System.out.println("❌ Aucun événement avec l’ID : " + id);
        }
    }

    public void editerEvenement(Evenement e) {
        supprimerEvenement(e.getId());
        ajouterEvenement(e);
    }

    // par exemple pour update un évènement, on doit le rechercher, le supprimer et ajouter la nouvelle instance

    public Evenement rechercherEvenement(String id) {
        return evenements.get(id);
    }

    public Map<String, Evenement> getEvenements() {
        return evenements;
    }

    public void setEvenements(Map<String, Evenement> evenements) {
        this.evenements = evenements;
    }
}
