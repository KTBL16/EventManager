package com.polytechnique.tpfinalpoo2.models;

import java.util.List;

public class Organisateur extends Participant{
    private List<Evenement> evementsOrganises;

    public Organisateur(){

    }
    public Organisateur(String id, String nom, String email, String motDePasse, List<Evenement> evementsOrganises){
        super(id, nom, email, motDePasse);
        this.evementsOrganises = evementsOrganises;
    }

    public List<Evenement> getEvementsOrganises() {
        return evementsOrganises;
    }

    public void setEvementsOrganises(List<Evenement> evementsOrganises) {
        this.evementsOrganises = evementsOrganises;
    }
}
