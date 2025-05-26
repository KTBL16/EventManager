package com.polytechnique.tpfinalpoo2.models;

import java.util.List;

public class Organisateur extends Participant{
    private List<Evenement> evementsOrganises;

    public Organisateur(){

    }
    public Organisateur(String id, String nom, String email, List<Evenement> evementsOrganises){
        super(id, nom, email);
        this.evementsOrganises = evementsOrganises;
    }

    public List<Evenement> getEvementsOrganises() {
        return evementsOrganises;
    }

    public void setEvementsOrganises(List<Evenement> evementsOrganises) {
        this.evementsOrganises = evementsOrganises;
    }
}
