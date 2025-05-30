package com.polytechnique.tpfinalpoo2.services.gestion;

import com.polytechnique.tpfinalpoo2.exception.EvenementExistant;
import com.polytechnique.tpfinalpoo2.models.Evenement;

public interface Addable <T>{

    T ajouter (T t) throws EvenementExistant;
}
