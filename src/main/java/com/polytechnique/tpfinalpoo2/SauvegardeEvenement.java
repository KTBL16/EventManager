package com.polytechnique.tpfinalpoo2;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.polytechnique.tpfinalpoo2.models.Evenement;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class SauvegardeEvenement implements Isauvegarde<Evenement> {

    private static SauvegardeEvenement instance;
    private static final String cheminfichier = "evenements.json";
    private ObjectMapper mapper = new ObjectMapper();


    //get instance
    public static SauvegardeEvenement getInstance() {
        if (instance == null) {
            instance = new SauvegardeEvenement();
        }
        return instance;
    }


    @Override
    public void sauvegarder(Map<String, Evenement> evenement) {
        try {
            mapper.writeValue(new File(cheminfichier), evenement);
        } catch (IOException e) {
            throw new RuntimeException("Erreur de sauvegarde JSON", e);
        }
    }

    @Override
    public Map<String, Evenement> charger() {
        File file = new File(cheminfichier);
        if (file.exists()) {
            try {
                return mapper.readValue(file, new TypeReference<>() {
                });
            } catch (IOException e) {
                throw new RuntimeException("Erreur de chargement JSON", e);
            }
        }
        return new HashMap<>();

    }

}
