package com.polytechnique.tpfinalpoo2.models;

import java.time.LocalDateTime;
import java.util.List;

public class Conference extends Evenement{
    private String theme;
    private List<String> intervenant;

    public Conference(){

    }
    public Conference(String id, String nom, LocalDateTime date, String lieu, int capaciteMax, String theme, List<String> intervenant) {
        super(id, nom, date, lieu, capaciteMax);
        this.theme = theme;
        this.intervenant = intervenant;
    }

    public String getTheme() {
        return theme;
    }
    public List<String> getIntervenant() {
        return intervenant;
    }
    public void setTheme(String theme) {
        this.theme = theme;
    }
    public void setIntervenant(List<String> intervenant) {
        this.intervenant = intervenant;
    }

    @Override
    public void annuler() {

    }

    @Override
    public void afficherDetails() {

    }


}
