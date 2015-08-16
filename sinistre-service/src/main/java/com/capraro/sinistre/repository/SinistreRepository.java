package com.capraro.sinistre.repository;

import com.capraro.sinistre.model.Sinistre;

import java.util.List;

/**
 * sinsitre Repository.
 * Created by Richard Capraro on 11/08/2015.
 */
public interface SinistreRepository {

    /**
     * Returns all sinistres.
     *
     * @return all sinistres.
     */
    List<Sinistre> getSinistres();

}
