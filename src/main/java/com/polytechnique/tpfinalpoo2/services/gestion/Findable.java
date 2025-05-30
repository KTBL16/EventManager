package com.polytechnique.tpfinalpoo2.services.gestion;

import com.polytechnique.tpfinalpoo2.models.Evenement;

import java.util.Optional;

public interface Findable<T> {

    Optional<T> find (T id);
}
