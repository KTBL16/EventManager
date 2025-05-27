package com.polytechnique.tpfinalpoo2.sauvegarde;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SauvegardeParticipantOfEvent implements Isauvegarde<ArrayList<String>> {

    private static SauvegardeParticipantOfEvent instance;
    private static final String cheminfichier = "participantsOfEvent.json";
    private ObjectMapper mapper = new ObjectMapper();



    //get instance
    public static SauvegardeParticipantOfEvent getInstance() {
        if (instance == null) {
            instance = new SauvegardeParticipantOfEvent();
        }
        return instance;
    }


    @Override
    public void sauvegarder(Map<String, ArrayList<String>> participantsOfEvent) {
        try {
            mapper.writeValue(new File(cheminfichier), participantsOfEvent);
        } catch (IOException e) {
            throw new RuntimeException("Erreur de sauvegarde JSON", e);
        }
    }

    @Override
    public Map<String, ArrayList<String>> charger() {
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
