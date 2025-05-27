package com.polytechnique.tpfinalpoo2.controllers;

import com.polytechnique.tpfinalpoo2.services.gestion.GestionParticipant;

public class ConnexionController {
    public void traiterConnexion(String identifiant, String password) {
        GestionParticipant.getInstance().rechercherParticipant(identifiant);

    }
}
