package com.capraro.tiers.repository;

import com.capraro.tiers.model.Tiers;

import java.util.List;

/**
 * Tiers Repository.
 * Created by Richard Capraro on 11/08/2015.
 */
public interface TiersRepository {

    /**
     * Returns all Tiers.
     *
     * @return all Tiers.
     */
    List<Tiers> getTiers();

}
