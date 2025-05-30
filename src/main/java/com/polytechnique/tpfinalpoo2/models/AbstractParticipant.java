package com.polytechnique.tpfinalpoo2.models;



public class AbstractParticipant {
    //donner par le pseudo
    private String nom;
    private String email;

    public AbstractParticipant(){

    }
    public AbstractParticipant(String nom, String email){
        this.nom = nom;
        this.email = email;
    }


    public String getNom() {
        return nom;
    }

    public String getEmail() {
        return email;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}

