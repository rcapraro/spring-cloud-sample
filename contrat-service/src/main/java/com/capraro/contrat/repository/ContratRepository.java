package com.capraro.contrat.repository;

import com.capraro.contrat.model.Contrat;

import java.util.List;

/**
 * Contrat Repository.
 * Created by Richard Capraro on 11/08/2015.
 */
public interface ContratRepository {

    /**
     * Returns all contrats.
     *
     * @return all contrats.
     */
    List<Contrat> getContrats();

}
