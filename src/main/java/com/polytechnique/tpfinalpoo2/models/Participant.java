package com.polytechnique.tpfinalpoo2.models;



public class Participant {

    private String id;
    private String nom;
    private String email;
    private String motDePasse;

    public Participant(){

    }
    public Participant(String id, String nom, String email, String motDePasse){
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.motDePasse = motDePasse;
    }

    public String getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getEmail() {
        return email;
    }

    public String getMotDePasse() {return motDePasse;}

    public void setId(String id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMotDePasse(String motDePasse) {this.motDePasse = motDePasse;}
}
