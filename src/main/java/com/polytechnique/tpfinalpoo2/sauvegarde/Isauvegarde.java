package com.polytechnique.tpfinalpoo2.sauvegarde;

import java.util.Map;

public interface Isauvegarde <T>{
    void sauvegarder(Map<String, T> objet);
    Map<String, T> charger();
}

