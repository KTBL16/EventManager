package com.polytechnique.tpfinalpoo2.services.gestion;

import com.polytechnique.tpfinalpoo2.models.Evenement;

public interface Deletable <T>{

    T delete (String id);
}
