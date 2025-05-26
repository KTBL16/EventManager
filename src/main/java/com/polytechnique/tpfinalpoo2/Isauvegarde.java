package com.polytechnique.tpfinalpoo2;

import java.util.Map;

public interface Isauvegarde <T>{
    void sauvegarder(Map<String, T> objet);
    Map<String, T> charger();
}

