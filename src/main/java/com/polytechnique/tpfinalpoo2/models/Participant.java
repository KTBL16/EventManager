package com.polytechnique.tpfinalpoo2.models;



public class Participant extends AbstractParticipant {

    private String motDePasse;

    public Participant(){
        super();
    }
    public Participant(String nom, String email, String motDePasse){
        super(nom, email);
        this.motDePasse = motDePasse;
    }

    public String getMotDePasse() {return motDePasse;}

    public void setMotDePasse(String motDePasse) {this.motDePasse = motDePasse;}
}
