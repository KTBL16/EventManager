package com.polytechnique.tpfinalpoo2.gestion;

import com.polytechnique.tpfinalpoo2.sauvegarde.SauvegardeEvenement;

import java.lang.reflect.Field;

public class SauvegardeEvenementTestAccessoir {

    public static void setMockInstance(SauvegardeEvenement mockInstance) {
        try {
            Field field = SauvegardeEvenement.class.getDeclaredField("instance");
            field.setAccessible(true);
            field.set(null, mockInstance);
        } catch (Exception e) {
            throw new RuntimeException("Erreur injection SauvegardeEvenement", e);
        }
    }
}
