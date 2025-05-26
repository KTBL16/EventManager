package com.polytechnique.tpfinalpoo2.models;

/*
* classe abstraite représentant un évènement générique*/

import java.time.LocalDateTime;

public abstract class Evenement {

    private String id;
    private String nom;
    private LocalDateTime date;
    private String lieu;
    private int capaciteMax;

    public Evenement(){

    }

    public Evenement(String id, String nom, LocalDateTime date, String lieu, int capaciteMax) {
        this.id = id;
        this.nom = nom;
        this.date = date;
        this.lieu = lieu;
        this.capaciteMax = capaciteMax;
    }
    public String getId() {
        return id;
    }
    public String getNom() {
        return nom;
    }
    public LocalDateTime getDate() {
        return date;
    }
    public String getLieu() {
        return lieu;
    }
    public int getCapaciteMax() {
        return capaciteMax;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setDate(LocalDateTime date) {
        this.date = date;
    }
    public void setLieu(String lieu) {
        this.lieu = lieu;
    }
    public void setCapaciteMax(int capaciteMax) {
        this.capaciteMax = capaciteMax;
    }


    abstract public void annuler();
        // TODO: annuler l'événement

    abstract public boolean ajouterParticipant(Participant participant);
        // TODO: ajouter le participant à l'événement

    abstract public void afficherDetails();
        // TODO: afficher les détails de l'événement

}
