package com.polytechnique.tpfinalpoo2.sauvegarde;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Sauvegarde {

    private static Sauvegarde intance;
    private ObjectMapper mapper = new ObjectMapper();

    public static Sauvegarde getIntance() {
        if (intance == null){
            intance = new Sauvegarde();
        }
        return intance;
    }

    public void sauvegarder(Map<String, ?> data, String cheminfichier) {
        try {
            mapper.writeValue(new File(cheminfichier), data);
        } catch (IOException e) {
            throw new RuntimeException("Erreur de sauvegarde JSON", e);
        }
    }

    public Map<String, ?> charger(String cheminfichier) {
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