package com.polytechnique.tpfinalpoo2.models;

import java.time.LocalDateTime;
import java.util.List;

public class Concert extends Evenement{

    private String artiste;
    private String genreMusical;

    public Concert(){

    }
    public Concert(String id, String nom, LocalDateTime date, String lieu, int capaciteMax, String artiste, String genreMusical) {
        super(id, nom, date, lieu, capaciteMax);
        this.artiste = artiste;
        this.genreMusical = genreMusical;
    }

    public String getArtiste() {
        return artiste;
    }

    public String getGenreMusical() {
        return genreMusical;
    }

    public void setArtiste(String artiste) {
        this.artiste = artiste;
    }

    public void setGenreMusical(String genreMusical) {
        this.genreMusical = genreMusical;
    }

    @Override
    public void annuler() {

    }

    @Override
    public boolean ajouterParticipant(Participant participant) {
        return false;
    }

    @Override
    public void afficherDetails() {

    }
}
