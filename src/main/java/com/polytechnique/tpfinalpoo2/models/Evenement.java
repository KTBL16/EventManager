package com.polytechnique.tpfinalpoo2.models;

/*
* classe abstraite représentant un évènement générique*/

import java.time.LocalDateTime;
import java.util.List;

public abstract class Evenement {

    private String id;
    private String nom;
    private LocalDateTime date;
    private String lieu;
    private int capaciteMax;
    private String organisateur; //id de l'organisateur
    private List<String> participants; //id des participants

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
    public String getOrganisateur() {
        return organisateur;
    }

    public void setOrganisateur(String organisateur) {
        this.organisateur = organisateur;
    }

    public List<String> getParticipants() {
        return participants;
    }
    public void setParticipants(List<String> participants) {
        this.participants = participants;
    }
    abstract public void annuler();
        //annuler l'événement

    public void ajouterParticipant(Participant participant){
        participants.add(participant.getEmail());
    }

    abstract public void afficherDetails();
        //afficher les détails de l'événement

}
