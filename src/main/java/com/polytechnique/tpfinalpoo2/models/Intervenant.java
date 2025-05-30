package com.polytechnique.tpfinalpoo2.models;

public class Intervenant extends AbstractParticipant {

    private String aPropos;

    public Intervenant(String nom, String prenom, String email, String aPropos) {
        super(nom, prenom, email);
        this.aPropos = aPropos;
    }

    public String getAPropos() {return aPropos;}

    public void setAPropos(String aPropos) {this.aPropos = aPropos;}

}
