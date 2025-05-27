package com.polytechnique.tpfinalpoo2.sauvegarde;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.polytechnique.tpfinalpoo2.models.Participant;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SauvegardeParticipant implements Isauvegarde<Participant> {

    private static SauvegardeParticipant instance;
    private static final String cheminfichier = "participants.json";
    private ObjectMapper mapper = new ObjectMapper();



    //get instance
    public static SauvegardeParticipant getInstance() {
        if (instance == null) {
            instance = new SauvegardeParticipant();
        }
        return instance;
    }


    @Override
    public void sauvegarder(Map<String, Participant> participants) {
        try {
            mapper.writeValue(new File(cheminfichier), participants);
        } catch (IOException e) {
            throw new RuntimeException("Erreur de sauvegarde JSON", e);
        }
    }

    @Override
    public Map<String, Participant> charger() {
        File file = new File(cheminfichier);
        if (file.exists()) {
            try {
                return mapper.readValue(file, new TypeReference<>() {});
            } catch (IOException e) {
                throw new RuntimeException("Erreur de chargement JSON", e);
            }
        }
        return new HashMap<>();
    }
}

